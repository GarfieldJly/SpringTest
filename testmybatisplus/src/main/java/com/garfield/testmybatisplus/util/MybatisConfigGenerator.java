package com.garfield.testmybatisplus.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.util.StringUtils;


/**
 * @author Jingly 生成mybatis generatorConfig.xml里的context格式输出
 */
public class MybatisConfigGenerator {

  /**
   * mysql url
   */
  private String url = "jdbc:mysql://172.27.83.14:3306/crm?useUnicode=true&characterEncoding=utf-8&useSSL=false";
  private String user = "root";
  private String password = "2F9Tkw1vDvgR9gy1";

  /**
   * 连接mysql
   */
  public MybatisConfigGenerator(String url, String user, String password) {
    this.url = url;
    this.user = user;
    this.password = password;
  }

  private MybatisConfigGenerator() {
  }

  public static void main(String[] args) {
    try {
      String schemaName = "crm";
      String tableName = "call_record";
      new MybatisConfigGenerator().generate(schemaName, tableName);
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }


  private static void validateHotWords(String hotWords) {
    String hotWordsArray[] = hotWords.split("，");
    for (String item : hotWordsArray) {
      boolean isChinese = WordUtils.isChinese(item);
      if (isChinese) {
        if (!StringUtils.isEmpty(item)) {
          int length = item.length();
          System.out.println("length : " + length);
        }
      }
    }
  }

  private static final Pattern CHINESE_PATTERN = Pattern.compile("[\u4e00-\u9fa5]");

  public static boolean isContainChinese(String str) {
    Matcher m = CHINESE_PATTERN.matcher(str);
    if (m.find()) {
      return true;
    }
    return false;
  }

  public void generate(String schemaName, String tableName) throws SQLException,
      ClassNotFoundException {
    generate(schemaName, tableName, convertToClassNomi(tableName) + "DO");
  }

  public void generate(String schemaName, String tableName, String doName) throws SQLException,
      ClassNotFoundException {
    Connection connection = null;
    ResultSet resultSet = null;
    Statement statement = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      connection = DriverManager.getConnection(url, user, password);

      String sql =
          "SELECT col.COLUMN_NAME , col.DATA_TYPE FROM information_schema.COLUMNS col WHERE LOWER(col.TABLE_SCHEMA) = '"
              + schemaName + "' AND LOWER(col.TABLE_NAME) in ('" + tableName + "')";
      statement = connection.createStatement();
      resultSet = statement.executeQuery(sql);
      System.out.println("<table tableName=\"" + tableName + "\" domainObjectName=\"" + doName
          + "\" enableCountByExample=\"false\">");

      int index = 0;
      while (resultSet.next()) {

        String columnName = resultSet.getString(1);
        String dataType = resultSet.getString(2);
        if (index++ == 0) {
          System.out.println("<generatedKey column=\"" + columnName
              + "\" sqlStatement=\"MySql\" identity=\"true\"/>");
        }
        if (!("varchar".equals(dataType) || "text".equals(dataType))) {
          System.out.println(
              " <columnOverride column=\"" + columnName + "\" property=\"" + convertToCamel(
                  columnName)
                  + "\" javaType=\"" + dob(dataType) + "\" jdbcType=\"" + doc(dataType) + "\"/>");
        }
      }
      System.out.println("</table>");
    } finally {
      if (resultSet != null) {
        resultSet.close();
      }
      if (statement != null) {
        statement.close();
      }
      if (connection != null) {
        connection.close();
      }
    }
  }

  private String doc(String dataType) {
    switch (dataType) {
      case "int":
        return "INTEGER";
      case "mediumint":
        return "INTEGER";
      case "enum":
        return "VARCHAR";
      case "datetime":
        return "TIMESTAMP";
      default:
        return dataType.toUpperCase();
    }
  }

  private String dob(String dataType) {
    switch (dataType) {
      case "decimal":
        return "java.lang.Double";
      case "bigint":
        return "java.lang.Long";
      case "int":
        return "java.lang.Long";
      case "smallint":
        return "java.lang.Integer";
      case "tinyint":
        return "java.lang.Integer";
      case "mediumint":
        return "java.lang.Long";
      case "enum":
        return "java.lang.Integer";
      case "date":
        return "java.util.Date";
      case "datetime":
        return "java.util.Date";
      case "timestamp":
        return "java.util.Date";
      default:
        return dataType;
    }
  }

  private String convertToCamel(String columnName) {
    StringBuffer buffer = new StringBuffer();
    String[] split = columnName.split("_");
    if (split.length <= 1) {
      return columnName;
    }
    for (int j = 0; j < split.length; j++) {
      if (j == 0) {
        buffer.append(split[j]);
        continue;
      }
      String s = split[j];
      buffer.append(String.valueOf(Character.toUpperCase(s.charAt(0))) + s.substring(1));
    }
    return buffer.toString();
  }

  private String convertToClassNomi(String columnName) {
    String s = convertToCamel(columnName);
    char[] chars = s.toCharArray();
    char aChar = chars[0];
    chars[0] = Character.toUpperCase(aChar);
    s = new String(chars);
    return s;
  }
}

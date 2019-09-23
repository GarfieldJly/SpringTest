package com.garfield.wechatorder.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 生成mybatis generatorConfig.xml里的context格式输出
 *
 * @author zhenggaojie 2015-09-18.
 */
public class MybatisConfigGenerator {

    // public static final String URL =
    // "jdbc:mysql://112.124.52.188:3306/?zeroDateTimeBehavior=convertToNull&amp;characterEncoding=utf-8&amp;allowMultiQueries=true";
    // public static final String URL = "jdbc:mysql://127.0.0.1:3306/maijia?zeroDateTimeBehavior=convertToNull";
    // public static final String USER = "root";
    // public static final String PASSWORD = "you";
    public String URL = "jdbc:mysql://dev.jingzheit.com:3306/xinhua_dictionary?characterEncoding=utf-8&useSSL=false";

    public String USER = "root";
    public String PASSWORD = "Tryme!23";

    public MybatisConfigGenerator(String URL, String USER, String PASSWORD) {
        this.PASSWORD = PASSWORD;
        this.URL = URL;
        this.USER = USER;
    }

    public MybatisConfigGenerator() {
    }

    public static void main(String[] args) {
        try {
            String schemaName = "xinhua_dictionary";
            String tableName = "xiehouyu";
            new MybatisConfigGenerator().generate(schemaName, tableName);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void generate(String schemaName, String tableName) throws SQLException,
            ClassNotFoundException {
        generate(schemaName, tableName, convertToClassNomi(tableName) + "Do");
    }

    public void generate(String schemaName, String tableName, String doName) throws SQLException,
            ClassNotFoundException {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            String sql = "SELECT col.COLUMN_NAME , col.DATA_TYPE FROM information_schema.COLUMNS col WHERE LOWER(col.TABLE_SCHEMA) = '"
                    + schemaName + "' AND LOWER(col.TABLE_NAME) in ('" + tableName + "')";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            System.out.println("<table tableName=\"" + tableName + "\" domainObjectName=\"" + doName
                    + "\" enableCountByExample=\"false\">");
//            System.out.println("<property name=\"runtimeSchema\" value=\"" + schemaName + "\"/>");
            int index = 0;
            while (resultSet.next()) {

                String columnName = resultSet.getString(1);
                String dataType = resultSet.getString(2);
                if (index++ == 0) {
                    System.out.println("<generatedKey column=\"" + columnName
                            + "\" sqlStatement=\"MySql\" identity=\"true\"/>");
                }
                if (!("varchar".equals(dataType) || "text".equals(dataType))) {
                    System.out.println(" <columnOverride column=\"" + columnName + "\" property=\"" + convertToCamel(columnName)
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
            case "enums":
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
            case "enums":
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
        StringBuffer buf = new StringBuffer();
        String[] split = columnName.split("_");
        if (split.length <= 1) {
            return columnName;
        }
        for (int j = 0; j < split.length; j++) {
            if (j == 0) {
                buf.append(split[j]);
                continue;
            }
            String s = split[j];
            buf.append(String.valueOf(Character.toUpperCase(s.charAt(0))) + s.substring(1));
        }
        return buf.toString();
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

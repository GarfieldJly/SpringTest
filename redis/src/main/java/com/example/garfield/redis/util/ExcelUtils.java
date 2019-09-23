package com.example.garfield.redis.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.springframework.util.CollectionUtils;

/**
 * @Description: excel 处理工具类
 */
public class ExcelUtils {

  private static final Pattern NUMBER_PATTERN = Pattern.compile("[-]?[\\d.]+");
  private static final FastDateFormat FDF = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");
  private static final DecimalFormat DF = new DecimalFormat("0.00");


  public static SXSSFWorkbook createWorkBook(String sheetName, List<String> titles,
      List<List> contents) throws Exception {

    SXSSFWorkbook wb = new SXSSFWorkbook();
    SXSSFSheet sheet = null;

    // 对每个表生成一个新的sheet,并以表名命名
    if (sheetName == null) {
      sheetName = "sheet1";
    }
    sheet = wb.createSheet(sheetName);
    sheet.setDefaultColumnWidth(10 * 256);
    // 设置表头的说明
    SXSSFRow topRow = sheet.createRow(0);
    for (int i = 0; i < titles.size(); i++) {
      setCellGBKValue(topRow.createCell(i), titles.get(i));
      sheet.setColumnWidth(i, titles.get(i).getBytes().length * 258);
    }

    XSSFCellStyle wrapStyle = (XSSFCellStyle) wb.createCellStyle();
    // 设置单元格内容是否自动换行
    wrapStyle.setWrapText(true);

    Map columnWidth = new HashMap<Integer, Integer>();
    for (int i = 0; i < contents.size(); i++) {
      List one = contents.get(i);
      SXSSFRow row = sheet.createRow(i + 1);
      // 行高
      int height = 1;
      for (int j = 0; j < titles.size(); j++) {
        Object cellValue = one.get(j);
        /**
         * 数字按照数字样式处理 2018/1/18 王斌
         */
        if (cellValue == null) {
          setCellGBKValue(row.createCell(j), "");
        } else {
          String cellStringValue = cellValue.toString();
          SXSSFCell cell = row.createCell(j);
          /*if (NUMBER_PATTERN.matcher(cellStringValue).matches()
              && cellStringValue.length() < 11) {// 非11位的数字、设置数字格式
            setCellGBKValue(cell, Double.valueOf(cellStringValue));
          } else {
            setCellGBKValue(cell, cellStringValue);
          }*/
          setCellGBKValue(cell, cellStringValue);
          if (cellStringValue.length() > 4) {// 内容长度大于4做自适应处理
            int width = (cellStringValue.getBytes().length + 4) * 256;
            sheet.setColumnWidth(j, width < 3000 ? 3000 : width < 255 * 256 ? width : 6000);
            int old = columnWidth.get(j) != null ? (int) columnWidth.get(j) : 0;
            if (width > old) {
              columnWidth.put(j, width);
              sheet.setColumnWidth(j, width < 3000 ? 3000 : width < 255 * 256 ? width : 60000);
            }
          }
          if (cellStringValue.contains("\n")) {
            cell.setCellStyle(wrapStyle);
            int newH = StringUtils.countMatches(cellStringValue, "\n") + 1;
            if (height < newH) {
              height = newH;
            }
          }
        }
        if (height != 1) {
          row.setHeightInPoints(height * 20);
        }
      }
    }
    return wb;
  }

  /**
   * excel导出
   *
   * @param fileNamePath 导出的文件名称
   * @param sheetName 导出的sheet名称
   * @param titles 第一行表头
   * @param contents 数据集合
   */
  public static <T> File export(String fileNamePath, String sheetName, List<String> titles,
      List<List> contents)
      throws Exception {

    SXSSFWorkbook wb = createWorkBook(sheetName, titles, contents);
    File file = null;
    OutputStream os = null;
    file = new File(fileNamePath);
    try {
      os = new FileOutputStream(file);
      wb.write(os);
    } catch (Exception e) {
      throw new Exception("write excel file error!", e);
    } finally {
      if (null != os) {
        os.flush();
        os.close();
      }
    }
    return file;
  }

  public static void export(Workbook wb, String fileName, List<String> titles,
       HttpServletResponse response) throws Exception {
    try {
      if(!CollectionUtils.isEmpty(titles)){
        wb = appendTitles(wb, titles);
      }
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      wb.write(baos);
      baos.flush();
      byte[] aa = baos.toByteArray();
      response.addHeader("Content-Disposition",
          "attachment;filename*=utf-8'zh_cn'" + fileName);
      response.setHeader("Content-Type", "application/vnd.ms-excel");
      response.setCharacterEncoding("UTF-8");
      response.getOutputStream().write(aa);
      response.setContentLength(aa.length);
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception("write excel to stream error!", e);
    } finally {
      if (response.getOutputStream() != null) {
        response.getOutputStream().flush();
      }
    }
  }

  private static Workbook appendTitles(Workbook wb, List<String> titles) throws Exception {

    Sheet sheet = wb.getSheetAt(0);
    // 设置表头的说明
    Row topRow = sheet.getRow(1);
    for (int i = 0; i < titles.size(); i++) {
      Cell cell = topRow.createCell(i + 6);
      cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
      cell.setCellValue(titles.get(i));
      sheet.setColumnWidth( i + 6, titles.get(i).getBytes().length * 258);
    }
    return wb;
  }

  private static void setCellGBKValue(SXSSFCell cell, String value) {
    cell.setCellType(HSSFCell.CELL_TYPE_STRING);
    cell.setCellValue(value);
  }

  private static void setCellGBKValue(SXSSFCell cell, double value) {
    cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
    cell.setCellValue(value);
  }

}

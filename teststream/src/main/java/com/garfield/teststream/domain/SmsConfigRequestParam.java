package com.garfield.teststream.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 短信请求参数对象
 */
@Data
@AllArgsConstructor
public class SmsConfigRequestParam {

  /**
   * 参数名称
   */
  private String paramName;
  /**
   * 参数值
   */
  private String paramValue;
  /**
   * 是否动态生成
   */
  private boolean isDynamic;
  /**
   * 算法
   */
  private String arithmetic;
  /**
   * 分隔符
   */
  private String separator;

  public String getParamName() {
    return paramName;
  }

  public void setParamName(String paramName) {
    this.paramName = paramName;
  }

  public String getParamValue() {
    return paramValue;
  }

  public void setParamValue(String paramValue) {
    this.paramValue = paramValue;
  }

  public boolean isDynamic() {
    return isDynamic;
  }

  public void setDynamic(boolean dynamic) {
    isDynamic = dynamic;
  }

  public String getArithmetic() {
    return arithmetic;
  }

  public void setArithmetic(String arithmetic) {
    this.arithmetic = arithmetic;
  }

  public String getSeparator() {
    return separator;
  }

  public void setSeparator(String separator) {
    this.separator = separator;
  }

  @Override
  public String toString() {
    return "SmsConfigRequestParam{" +
        "paramName='" + paramName + '\'' +
        ", paramValue='" + paramValue + '\'' +
        ", isDynamic=" + isDynamic +
        ", arithmetic='" + arithmetic + '\'' +
        ", separator='" + separator + '\'' +
        '}';
  }
}

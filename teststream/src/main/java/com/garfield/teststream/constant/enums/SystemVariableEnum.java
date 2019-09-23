package com.garfield.teststream.constant.enums;

public enum SystemVariableEnum {

  /**
   * 客户姓名
   */
  CUSTOMER_NAME("zx_name", "客户姓名"),

  /**
   * 客户手机号码
   */
  CUSTOMER_PHONE("zx_phone", "客户手机号码"),

  /**
   * 客户手机号码后四位
   */
  CUSTOMER_PHONE_LAST_FOUR("zx_phone_last_four", "客户手机号码后四位"),

  /**
   * 客户性别
   */
  CUSTOMER_SEX("zx_sex", "客户性别"),

  ;
  /**
   * 变量名称
   */
  private String name;

  /**
   * 变量描述
   */
  private String desc;

  SystemVariableEnum(String name, String desc) {
    this.name = name;
    this.desc = desc;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }


  @Override
  public String toString() {
    return "{\"name\":" + name + ",\"desc\":" + desc + "}";
  }
}

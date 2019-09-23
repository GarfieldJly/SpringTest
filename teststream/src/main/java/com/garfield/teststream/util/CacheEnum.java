package com.garfield.teststream.util;

import lombok.Data;

/**
 * @author: Jingly
 * @create: 2019-08-02 17:07
 **/
public enum  CacheEnum {
  /**
   *
   */
  callTask(10,100),
  user(20,100),
  crm(30,100);

  int ttl;
  int value;

  CacheEnum(int ttl, int value) {
    this.ttl = ttl;
    this.value = value;
  }

  CacheEnum() {
  }

  public int getTtl() {
    return ttl;
  }

  public void setTtl(int ttl) {
    this.ttl = ttl;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }}

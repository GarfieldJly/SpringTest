package com.garfield.teststream.service;

/**
 * @author: Jingly
 * @create: 2019-08-08 15:10
 **/
public interface StringService {
  default String getOldName(){
    return "景丽媛";
  }

  String getNewName();

  static String bron(){
    return "按喇叭";
  }
}

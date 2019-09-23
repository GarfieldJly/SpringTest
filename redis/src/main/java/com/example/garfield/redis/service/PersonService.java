package com.example.garfield.redis.service;

/**
 * @author: Jingly
 * @create: 2019-09-02 10:01
 **/
public interface PersonService {

  default void getOldName(){
    System.out.println("曾用名是：景丽园");
  }

  static String getNewName(){
    return "景丽媛";
  }

  String getName();

}

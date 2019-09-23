package com.garfield.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Jingly
 * @create: 2019-06-25 14:39
 **/
@RestController
public class TestController {
  @GetMapping("hello")
  public String hello() {
    return "hello spring security";
  }
}

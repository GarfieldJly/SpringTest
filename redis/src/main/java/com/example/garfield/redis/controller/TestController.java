package com.example.garfield.redis.controller;

import com.example.garfield.redis.service.impl.TestService;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Jingly
 * @create: 2019-09-03 10:51
 **/
@RequestMapping
@RestController
public class TestController {

  @Autowired
  private TestService testService;

  @GetMapping("/test")
  public void test(){
    testService.testSeptember();
  }

  /**
   * 下载模板
   *
   */
  @GetMapping("/customer/download/sample")
  public void downloadSample(HttpServletResponse response) {
    this.testService.downloadSample(response);
  }
}

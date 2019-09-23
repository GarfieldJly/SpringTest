package com.garfield.teststream.controller;

import com.garfield.teststream.domain.vo.SystemVariableVO;
import com.garfield.teststream.service.StringService;
import com.garfield.teststream.service.impl.TestServiceImpl;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Jingly
 * @create: 2019-07-26 15:27
 **/
@RestController
@RequestMapping
@Slf4j
public class StringController {

  @Autowired
  private StringService stringService;
  @Autowired
  private TestServiceImpl testService;

  @GetMapping(value = "/test")
  public void test() {
    log.info("请求....");
    String oldName = stringService.getOldName();
    log.info("旧名称为:"+oldName);
    String newName = stringService.getNewName();
    log.info("新名称为:"+newName);

  }

  @GetMapping(value = "/testSystemVariableVOList")
  public void testSystemVariableVOList() {
    testService.testSeptember();
  }

  /**
   * 获取初始化列表
   */
  @GetMapping(value = "/testBean")
  public void testBean() {
    testService.testSeptember();
  }


}

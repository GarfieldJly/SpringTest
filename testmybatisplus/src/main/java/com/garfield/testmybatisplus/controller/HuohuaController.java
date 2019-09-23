package com.garfield.testmybatisplus.controller;


import com.garfield.testmybatisplus.domain.Huohua;
import com.garfield.testmybatisplus.service.HuohuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jingly
 * @since 2019-05-22
 */
@RestController
@RequestMapping("/huohua")
public class HuohuaController {
  @Autowired
  private HuohuaService huohuaService;

  @GetMapping("/{id}")
  public Huohua getHuohuaById(@PathVariable("id") Long id){
    return huohuaService.getById(id);
  }
}

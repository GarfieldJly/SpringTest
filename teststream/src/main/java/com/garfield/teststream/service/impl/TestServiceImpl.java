package com.garfield.teststream.service.impl;

import com.garfield.teststream.service.PersonService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author: Jingly
 * @create: 2019-09-03 10:49
 **/
@Service
public class TestServiceImpl {
  @Autowired
  private  ApplicationContext applicationContext;

  public void testSeptember(){
    //取出所有的PersonService的实现类的bean
    Map<String, PersonService> beansOfType = applicationContext.getBeansOfType(PersonService.class);
    beansOfType.forEach((k,v) ->{
      System.out.println("key is："+ k + ";; value is:"+v);
    });

  }
}

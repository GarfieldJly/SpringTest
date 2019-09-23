package com.example.garfield.redis.config;

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

/**
 * @author: Jingly
 * @create: 2019-09-20 11:12
 **/
@Component
@Slf4j
public class ProjectConfiguration {

  @Autowired
  private ResourceLoader resourceLoader;

  public  byte[] fileBytes;
  public  String fileName;

  @PostConstruct
  public void init(){
    log.info("在启动方法之前执行");
    Resource resource = resourceLoader.getResource("classpath:template/customer_template.xls");
    try {
      InputStream inputStream = resource.getInputStream();
      fileName = "customer_template.xls";
      fileBytes = IOUtils.toByteArray(inputStream);

      log.info("byte:{}",fileBytes);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

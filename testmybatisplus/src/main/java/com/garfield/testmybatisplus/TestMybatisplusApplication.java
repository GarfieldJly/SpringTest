package com.garfield.testmybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@MapperScan("com.garfield.testmybatisplus.mapper")
public class TestMybatisplusApplication {

  public static void main(String[] args) {
    SpringApplication.run(TestMybatisplusApplication.class, args);
  }

}

package com.garfield.testmybatisplus.config;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: Jingly
 * @create: 2019-09-19 10:27
 **/
@Component
@ConfigurationProperties(prefix = "speech")
@Slf4j
public class SpeechConfig {
  private String name;
  private Integer age;
  private String gender;

  @PostConstruct
  public void init(){
    getAge();
    getGender();
    getName();
    log.info("姓名:{};年龄:{};性别:{}",name,age,gender);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

}

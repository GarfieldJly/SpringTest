package com.example.garfield.redis.service.impl;

import com.example.garfield.redis.service.PersonService;
import org.springframework.stereotype.Service;

/**
 * @author: Jingly
 * @create: 2019-09-02 10:02
 **/
@Service
public class TeacherServiceImpl implements PersonService {

  @Override
  public String getName(){
    String newName = "景仕进";
    return newName;
  }
}

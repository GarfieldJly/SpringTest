package com.garfield.teststream.service.impl;

import com.garfield.teststream.service.PersonService;
import org.springframework.stereotype.Service;

/**
 * @author: Jingly
 * @create: 2019-09-02 10:02
 **/
@Service
public class StudentServiceImpl implements PersonService {

  @Override
  public String getName(){
    String newName = PersonService.getNewName();
    getOldName();
    System.out.println();
    System.out.println("新名字是: "+newName);
    return newName;
  }
}

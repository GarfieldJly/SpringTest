package com.garfield.teststream.service.impl;

import com.garfield.teststream.service.NameService;
import com.garfield.teststream.service.StringService;
import org.springframework.stereotype.Service;

/**
 * @author: Jingly
 * @create: 2019-08-08 15:11
 **/
@Service
public class StringServiceImpl implements StringService, NameService {

  @Override
  public String getOldName() {
//    return NameService.super.getOldName();
    return "景秀合" + StringService.bron();
  }

  @Override
  public String getNewName() {
    return "景仕进";
  }
}

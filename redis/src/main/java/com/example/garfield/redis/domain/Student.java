package com.example.garfield.redis.domain;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

/**
 * @author: Jingly
 * @create: 2019-08-27 11:37
 **/
@Data
@Builder
public class Student implements Serializable {
  private String name;
  private Integer age;
}

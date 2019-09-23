package com.garfield.teststream.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Jingly
 * @create: 2019-08-02 16:11
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
  private Long id;
  private String name;
}

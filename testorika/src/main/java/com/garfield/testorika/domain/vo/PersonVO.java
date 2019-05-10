package com.garfield.testorika.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonVO {
  private String name;
  private String nickname;
  private int age;

}

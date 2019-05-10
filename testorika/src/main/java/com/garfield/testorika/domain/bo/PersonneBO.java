package com.garfield.testorika.domain.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jingly
 * 和 PersonVO 类的 nickname 不同
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonneBO {
  private String nom;
  private String surnom;
  private int age;

}

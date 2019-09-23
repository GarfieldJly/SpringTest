package com.garfield.teststream.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Jingly
 * @create: 2019-09-04 17:44
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SystemVariableVO {
  private String name;
  private String describe;
}

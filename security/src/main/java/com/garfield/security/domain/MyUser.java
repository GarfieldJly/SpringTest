package com.garfield.security.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * @author: Jingly
 * @create: 2019-06-25 16:24
 **/
@Data
public class MyUser implements Serializable {
  private static final long serialVersionUID = 3497935890426858541L;

  private String userName;

  private String password;

  private boolean accountNonExpired = true;

  private boolean accountNonLocked= true;

  private boolean credentialsNonExpired= true;

  private boolean enabled= true;
}

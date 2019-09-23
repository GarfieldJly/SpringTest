package com.garfield.testmybatisplus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestmybatisplusApplicationTests {

  @Test
  public void contextLoads() {
    String rule = "a<b";
    String[] split = rule.split("<");
    for (int i = 0; i < split.length; i++) {

    }
  }

}

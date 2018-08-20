package com.garfield.wechatorder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.garfield.wechatorder.dal.mapper")
public class WechatorderApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechatorderApplication.class, args);
    }
}

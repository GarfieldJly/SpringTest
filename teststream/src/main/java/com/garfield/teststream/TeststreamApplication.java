package com.garfield.teststream;

import com.garfield.teststream.dao.UserDao;
import com.garfield.teststream.util.CacheEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TeststreamApplication {

  @Autowired
  UserDao userDao;
  public static void main(String[] args) {
    SpringApplication.run(TeststreamApplication.class, args);
//    new SpringApplication(TeststreamApplication.class).run(args);
  }

//  @Override
//  public void run(String... args) throws Exception {
////    System.out.println("第一次查询");
////    System.out.println(userDao.getUser(1L));
////    System.out.println("第二次查询");
////    System.out.println(userDao.getUser(1L));
////    userDao.removeUser(1L);// 移除缓存
////    System.out.println("第三次查询");
////    userDao.getUser(1L);// 没有缓存了
////
////    System.out.println("--------");
////    // 测试不同的key缓存
////    userDao.getUserByName("micro1");
////    userDao.getUserByName(1L, "micro1");// 指定了参数name 为key 此次读取缓存
//
//
//    for (CacheEnum cacheEnum : CacheEnum.values()){
//      System.out.println(cacheEnum.getTtl());
//    }
//
//  }

}

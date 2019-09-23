package com.garfield.teststream.dao;

import com.garfield.teststream.domain.User;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;

/**
 * @author: Jingly
 * @create: 2019-08-02 16:12
 **/
@Component
@EnableCaching
public class UserDao {
  private Map<Long, User> userMap;

  @PostConstruct
  public void init(){
    userMap = new HashMap<>();
    userMap.put(1L,new User(1L,"景丽媛"));
    userMap.put(2L,new User(1L,"大傻子"));

  }

  @Cacheable(value = "user",unless = "#result==null ") // 注解key属性可以执行缓存对象user(可以理解为一个map)的key
  public User getUser(Long id){
    return userMap.get(id);
  }

  @Cacheable(value = "nameCache", key = "#name")
  public User getUserByName(Long userId, String name) {
    System.out.println("查询数据库:userId ->" + userId);
    return userMap.get(userId);
  }

  @Cacheable("nameCache")
  public User getUserByName(String name) {
    for (Long k : userMap.keySet()){
      if (userMap.get(k).getName().equals(name)) {
        return userMap.get(k);
      }
    }
    return null;
  }

  @CachePut("user") // 与Cacheable区别就是Cacheable先看缓存如果有，直接缓存换回，CachePut则是每次都会调用并且把返回值放到缓存
  public User getUser2(Long userId) {
    System.out.println("查询数据库:userId : " + userId);
    return userMap.get(userId);
  }

  @CacheEvict("user")
  public void removeUser(Long userId){
    userMap.remove(userId);
  }



}

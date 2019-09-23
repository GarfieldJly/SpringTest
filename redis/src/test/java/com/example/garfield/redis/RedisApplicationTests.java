package com.example.garfield.redis;

import com.example.garfield.redis.config.RedisUtils;
import com.example.garfield.redis.domain.Student;
import com.example.garfield.redis.service.PersonService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {

  @Autowired
  private RedisUtils redisUtils;

  @Test
  public void contextLoads() {
    Map<String, Student> studentMap = new HashMap<>();
    Student student1 = Student.builder().name("a").build();
    Student student2 = Student.builder().name("b").build();
    studentMap.put("b", student1);
    studentMap.put("c", student2);

    redisUtils.multiSetObj(studentMap);

    List<String> keys = new ArrayList();
    keys.add("b");
    List list = redisUtils.mMap(keys);
    System.out.println(list);

  }

  @Test
  public void testList() {
//    List<String> roleNames = new ArrayList<>();
//    roleNames.add("1");
//    roleNames.add("2");
////    System.out.println(roles);
////    String roleNames = "[abc]";
//    String tex = roleNames.toString().replace("[", "").replace("]", "");
//    System.out.println(tex);

//    int count = 0;
//    if(!(count > 0) && !(count <0)){
//
//    }
    long l = System.nanoTime();
    System.out.println(l);


  }

  /**
   * 八月总结复习
   */
  @Autowired
  private PersonService studentService;
  @Test
  public void testAugust(){
    //1. System.out::println
//    List<String> roleNames = new ArrayList<>();
//    roleNames.add("1");
//    roleNames.add("2");
//    roleNames.forEach(System.out::println);

    //2. interface的新用法
//    studentService.getName();

    //3. 统计
//    List<Integer> numberList = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
//    IntSummaryStatistics intSummaryStatistics = numberList.stream().mapToInt((n) -> n)
//        .summaryStatistics();
//    double average = intSummaryStatistics.getAverage();
//    System.out.println(average);
//    long sum = intSummaryStatistics.getSum();
//    System.out.println(sum);

    //4. 下载jar包命令  mvn -pl crm -am clean package -U
//    mvn -pl crm -am clean package -U

    //5. String 转成List<Object>
//    List<CallPhoneParam> callPhoneParamList = JSONObject
//        .parseArray(callPhoneParams, CallPhoneParam.class);

    //6. @Builder注解
//    Student student = Student.builder().name("jly").age(27).build();
//    System.out.println(student);

    //7. Map的循环
//    Map map = new HashMap<String,String>();
//    map.put("name","景丽媛");
//    map.put("age","27");
//    map.forEach((k,v) ->{
//      System.out.println("key值:"+k);
//      System.out.println("value值:"+v);
//    });
//
//    Set<Map.Entry<String, String>> set1 = map.entrySet();
//    for(Entry entry : set1){
//      System.out.println(entry.getKey() + ";;;" + entry.getValue());
//    }




  }




}

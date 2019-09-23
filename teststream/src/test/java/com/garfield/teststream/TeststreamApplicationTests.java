package com.garfield.teststream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import com.garfield.teststream.domain.Person;
import com.garfield.teststream.util.ComparatorUtil;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TeststreamApplicationTests {

  @Test
  public void testFilter() {
    Person person1 = new Person("jly", 20);
    Person person2 = new Person("jsj", 13);
    List<Person> personList = new ArrayList<>();
    personList.add(person1);
    personList.add(person2);
    //filter 过滤条件
    List<Person> result = personList.stream().filter(person -> person.getAge() < 18).collect(
        toList());
    log.info("result size is :{}", result.size());
  }


  @Test
  public void testDistinct() {
    Person person1 = new Person("jly", 20);
    Person person2 = new Person("jly", 20);
    Person person3 = new Person("jly", 21);
    List<Person> personList = new ArrayList<>();
    personList.add(person1);
    personList.add(person2);
    personList.add(person3);
    //distinct 过滤重复
    List<Person> result = personList.stream().distinct().collect(
        toList());
    log.info("result  is :{}", result);
  }

  @Test
  public void testSort() {
    Person person1 = new Person("jly", 20);
    Person person2 = new Person("jly", 18);
    Person person3 = new Person("jly", 21);
    List<Person> personList = new ArrayList<>();
    personList.add(person1);
    personList.add(person2);
    personList.add(person3);
    //sorted 对元素进行排序
    List<Person> result = personList.stream().sorted(Comparator.comparingInt(Person::getAge))
        .collect(
            toList());
    log.info("result  is :{}", result);
  }

  @Test
  public void testLimit() {
    Person person1 = new Person("jly", 20);
    Person person2 = new Person("jly", 18);
    Person person3 = new Person("jly", 21);

    PropertiesUtil.getProperties().
    List<Person> personList = new ArrayList<>();
    personList.add(person1);
    personList.add(person2);
    personList.add(person3);
    //limit 返回前 n 个元素
    List<Person> result = personList.stream().limit(1).collect(
        toList());
    log.info("result  is :{}", result);
  }

  @Test
  public void testSkip() {
    Person person1 = new Person("jly", 20);
    Person person2 = new Person("jly", 18);
    Person person3 = new Person("jly", 21);
    List<Person> personList = new ArrayList<>();
    personList.add(person1);
    personList.add(person2);
    personList.add(person3);
    //skip 去除前 n 个元素
    List<Person> result = personList.stream().skip(1).collect(
        toList());
    log.info("result  is :{}", result);
  }

  @Test
  public void testMap() {
//    Person person1 = new Person("jly",20);
//    Person person2 = new Person("jly",18);
//    Person person3 = new Person("jly",21);
//    List<Person> personList = new ArrayList<>();
//    personList.add(person1);
//    personList.add(person2);
//    personList.add(person3);
//    //map(T -> R)
//    //将流中的每一个元素 T 映射为 R（类似类型转换）
//    List<Integer> result = personList.stream().filter(person -> person.getAge() > 18).map(Person::getAge).collect(Collectors.toList());
//    log.info("result  is :{}",result);

//    List<String> list = new ArrayList<>();
//    list.add("aaa bbb ccc");
//    list.add("ddd eee fff");
//    list.add("ggg hhh iii");
//
//    list = list.stream().map(s -> s.split(" ")).flatMap(Arrays::stream).collect(toList());
//    log.info("list  is :{}", list);

    Map<String,String> map = new HashMap<>();
    String requestParam = "phone=aiccPhone,content=aiccContent";
    String[] split = requestParam.split(",");
    for (int i = 0; i < split.length; i++) {
      String temp = split[i];
      String[] split1 = temp.split("=");
      if(split1.length == 2){
        map.put(split1[1],split1[0]);
      }
    }


//    for (String key : map.keySet()){
//      System.out.println("Key:"+key + ";Value:"+map.get(key));
//    }

//    map.forEach((k,v)-> {
//      System.out.println("key : "+k);
//      System.out.println("value : "+v);
//    });

    for(Entry<String, String> set : map.entrySet()){
      System.out.println(set.getKey());
      System.out.println(set.getValue());
    }

  }

  @Test
  public void testAnyMatch() {
    Person person1 = new Person("jly", 20);
    Person person2 = new Person("jly", 18);
    Person person3 = new Person("jly", 21);
    List<Person> personList = new ArrayList<>();
    personList.add(person1);
    personList.add(person2);
    personList.add(person3);
    //anyMatch 流中是否有一个元素匹配给定的 T -> boolean 条件
    boolean flag = personList.stream().anyMatch(person -> person.getAge() < 15);
    log.info("flag  is :{}", flag);
  }

  @Test
  public void testAllMatch() {
    Person person1 = new Person("jly", 20);
    Person person2 = new Person("jly", 18);
    Person person3 = new Person("jly", 21);
    List<Person> personList = new ArrayList<>();
    personList.add(person1);
    personList.add(person2);
    personList.add(person3);
    //流中是否所有元素都匹配给定的 T -> boolean 条件
    boolean flag = personList.stream().allMatch(person -> person.getAge() < 15);
    log.info("flag  is :{}", flag);
  }

  @Test
  public void testNoneMatch() {
    Person person1 = new Person("jly", 20);
    Person person2 = new Person("jly", 18);
    Person person3 = new Person("jly", 21);
    List<Person> personList = new ArrayList<>();
    personList.add(person1);
    personList.add(person2);
    personList.add(person3);
    //流中是否没有元素匹配给定的 T -> boolean 条件
    boolean flag = personList.stream().noneMatch(person -> person.getAge() < 15);
    log.info("flag  is :{}", flag);
  }

  @Test
  public void testFind() {
    Person person1 = new Person("jly", 20);
    Person person2 = new Person("jly", 18);
    Person person3 = new Person("jly", 21);
    List<Person> personList = new ArrayList<>();
    personList.add(person1);
    personList.add(person2);
    personList.add(person3);
    //找到其中一个元素 （使用 stream() 时找到的是第一个元素；使用 parallelStream() 并行时找到的是其中一个元素）
    Person item1 = personList.parallelStream().findAny().orElse(new Person());
//    Person item =  personList.parallelStream().filter(person -> person.getAge() > 21).findAny().orElse(new Person());
    //findFirst()：找到第一个元素
    Person item2 = personList.parallelStream().findFirst().orElse(new Person());
    log.info("item1  is :{}", item1);
    log.info("item2  is :{}", item2);
  }

  @Test
  public void testReduce() {
    Person person1 = new Person("jly", 20);
    Person person2 = new Person("jly", 18);
    Person person3 = new Person("jly", 21);
    List<Person> personList = new ArrayList<>();
    personList.add(person1);
    personList.add(person2);
    personList.add(person3);
    //用于组合流中的元素，如求和，求积，求最大值等
    int sumAge = personList.stream().map(person -> person.getAge()).reduce(0, Integer::sum);
    log.info("sumAge  is :{}", sumAge);

    int maxAge = personList.stream().map(person -> person.getAge()).reduce(0, Integer::max);
    log.info("maxAge  is :{}", maxAge);

    Optional<Integer> reduce = personList.stream().map(person -> person.getAge())
        .reduce(Integer::min);
    if (reduce.isPresent()) {
      int minAge = reduce.get();
      log.info("minAge  is :{}", minAge);
    }
  }

  @Test
  public void testForEach() {
    Person person1 = new Person("jly", 20);
    Person person2 = new Person("jlj", 18);
    Person person3 = new Person("jsj", 21);
    List<Person> personList = new ArrayList<>();
    personList.add(person1);
    personList.add(person2);
    personList.add(person3);
    //流中是否没有元素匹配给定的 T -> boolean 条件
    personList.stream().forEach(person -> log.info(person.getName()));
  }

  @Test
  public void testMapType() {
    Person person1 = new Person("jly", 20);
    Person person2 = new Person("jlj", 18);
    Person person3 = new Person("jsj", 21);
    List<Person> personList = new ArrayList<>();
    personList.add(person1);
    personList.add(person2);
    personList.add(person3);
    //流转换为数值流
    //mapToInt(T -> int) : return IntStream
    //mapToDouble(T -> double) : return DoubleStream
    //mapToLong(T -> long) : return LongStream
    OptionalInt reduce = personList.stream().mapToInt(person -> person.getAge())
        .reduce(Integer::sum);
    if (reduce.isPresent()) {
      int minAge = reduce.getAsInt();
      log.info("minAge  is :{}", minAge);
    }
  }

  @Test
  public void testNumerical() {
    Person person1 = new Person("jly", 20);
    Person person2 = new Person("jlj", 18);
    Person person3 = new Person("jsj", 21);
    List<Person> personList = new ArrayList<>();
    personList.add(person1);
    personList.add(person2);
    personList.add(person3);
    //流转换为数值流
    //mapToInt(T -> int) : return IntStream
    //mapToDouble(T -> double) : return DoubleStream
    //mapToLong(T -> long) : return LongStream
    //类似 reduce()
    int sum = personList.stream().mapToInt(person -> person.getAge()).sum();
    log.info("sum  is :{}", sum);

    OptionalInt maxOptionalInt = personList.stream().mapToInt(person -> person.getAge()).max();
    if (maxOptionalInt.isPresent()) {
      log.info("max  is :{}", maxOptionalInt.getAsInt());
    }
  }

  @Test
  public void testMapInt() {
    //range() 开区间
    int sum1 = IntStream.range(1, 10).sum();
    log.info("sum1 is :{}", sum1);
    //rangeClosed() 闭区间
    int sum2 = IntStream.rangeClosed(1, 10).sum();
    log.info("sum2 is :{}", sum2);
  }

  @Test
  public void testMapInt1() {
    String str = "[123]";
    String temp = str.substring(1, str.length() - 1);
    System.out.println(temp);
  }

  @Test
  public void testStream() {
    Stream.of("jly", "jlj").forEach(item -> System.out.println(item));

    int[] a = {1, 2, 3, 4};
    Arrays.stream(a, 1, 3).forEach(item -> System.out.println(item));

  }

  @Test
  public void testCollector() {
    Person person1 = new Person("jly", 20);
    Person person2 = new Person("jlj", 18);
    Person person3 = new Person("jsj", 21);
    List<Person> personList = new ArrayList<>();
    personList.add(person1);
    personList.add(person2);
    personList.add(person3);
    //把流中所有元素收集到一个 List, Set 或 Collection 中
    List<Person> collect = personList.stream().filter(person -> person.getAge() > 18)
        .collect(toList());
    log.info("collect is :{}", collect);

    Map<String, Integer> collectMap = personList.stream().filter(person -> person.getAge() > 18)
        .collect(toMap(person -> person.getName(), person -> person.getAge()));
    log.info("collectMap is :{}", collectMap);

    Set<Person> collectSet = personList.stream().filter(person -> person.getAge() > 18)
        .collect(Collectors.toSet());
    log.info("collectSet is :{}", collectSet);

  }

  @Test
  public void testJoining() {
    Person person1 = new Person("jly", 20);
    Person person2 = new Person("jlj", 18);
    Person person3 = new Person("jsj", 21);
    List<Person> personList = new ArrayList<>();
    personList.add(person1);
    personList.add(person2);
    personList.add(person3);
    //joining() 对流里面的字符串元素进行连接
    String collect1 = personList.stream().map(Person::getName).collect(Collectors.joining());
    log.info("collect1 is :{}", collect1);

    String collect2 = personList.stream().map(Person::getName).collect(Collectors.joining(","));
    log.info("collect2 is :{}", collect2);
  }

  @Test
  public void testGroupingBy() {
    Person person1 = new Person("jly", 20);
    Person person2 = new Person("jlj", 18);
    Person person3 = new Person("jlj", 21);
    List<Person> personList = new ArrayList<>();
    personList.add(person1);
    personList.add(person2);
    personList.add(person3);
    //groupingBy 用于将数据分组，最终返回一个 Map 类型
    Map<String, List<Person>> collect1 = personList.stream()
        .collect(Collectors.groupingBy(Person::getName));
    log.info("collect1 is :{}", collect1);

  }

  @Test
  public void test2() {
//    String str[] = {"jly","jlj"};
//    String s = Arrays.toString(str);
//    for (int i = 0; i < s.length(); i++) {
//      System.out.println(s.charAt(i));
//    }
//    System.out.println(s.length());

    UUID uuid = UUID.randomUUID();
    System.out.println(uuid);

//    List<Integer> list = new ArrayList<>();
//    list.add(1);
//    list.add(2);
//    list.add(3);
//    list.add(0,5);
//    for (Integer item :
//        list) {
//      System.out.println(item);
//    }

//    String allKeyWordValue = "[1]";
//    allKeyWordValue = allKeyWordValue.substring(1,allKeyWordValue.length() - 1);
//    System.out.println(allKeyWordValue);
  }

  @Test
  public void testSwitch() {
    String paramStr = "jly";
    switch (paramStr) {
      case "jlj":
        System.out.println("娟");
        break;
      case "jly":
        System.out.println("媛");
        break;
    }
  }

  @Test
  public void testInit() {
//    int i = 2_000;
//    System.out.println(i);
    List<String> tempList = new ArrayList<>();
    tempList.add("abc");
    tempList.set(0, "bbb");
    System.out.println(tempList);
  }

  @Test
  public void testIO() {
    try (BufferedReader br = new BufferedReader(new FileReader("d://a.txt"))) {
      String line;
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      // handle exception
    }
  }

  @Test
  public void testAsList() {
    String str = "";
    boolean flag1 = ObjectUtils.isEmpty(str);
    System.out.println(flag1);

    boolean flag2 = StringUtils.isEmpty(str);
    System.out.println(flag2);
  }

  @Test
  public void contextLoads() {
    List<String> list = new ArrayList<>();
    System.out.println(list);
  }

  private static Pattern NLP_NODE_COMPILE = Pattern.compile("\\$\\$\\$(\\S*)");

  private String getSortIndex(String asText) {
    Matcher matcher = NLP_NODE_COMPILE.matcher(asText);
    if (matcher.find()) {
      return matcher.group(1);
    } else {
      return null;

    }
  }


  @Test
  public void testNode() {
    String node = getSortIndex(
        "process1$$$1284_b80a8f80-9bb0-11e9-a46f-7fc068ee6fe7$$$1$$$1da98140-a3ca-11e9-a534-d9f56a2e5f54");
    System.out.println(node);
    StringTokenizer token = new StringTokenizer(node, "_");
    System.out.println(token.countTokens());
    System.out.println(token.nextToken());
    System.out.println(token.nextToken());

//    String trainVersion = "V1.21.0";
//    String speechDeployTrainVersion = "V1.22.0";
//    if(trainVersion.compareTo(speechDeployTrainVersion) < 0){
//      System.out.println("小于它");
//    }else{
//      System.out.println("大于等于它");
//    }
  }

  @Test
  public void testArray() {
    List<String> list1 = new ArrayList<>();
    list1.add("1");
    list1.add("2");

    List<String> list2 = new ArrayList<>();

    list1.retainAll(list2);
    for (int i = 0; i < list1.size(); i++) {
      System.out.println(list1.get(i));
    }
  }


  @Test
  public void testArray1() {
    int count = 0;
    count = aa(count);
    System.out.println(count);
  }

  private int aa(int count) {
//    return ++count;
    return count++;
  }

  /**
   * 给定一个数组和一个目标和，从数组中找两个数字相加等于目标和，输出这两个数字的下标。
   */
  @Test
  public void test1() {
    int[] aa = new int[]{1, 2, 3};
    int result = 4;
    for (int i = 0; i < aa.length; i++) {
      int bb = aa[i];
      for (int j = (i + 1); j < aa.length; j++) {
        int cc = aa[j];
        if (bb + cc == result) {
          System.out.println("i的值是:" + i + ";j的值是:" + j);
          break;
        }
      }
    }

  }

  public int[] twoSum2(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
//    for(int i=0;i<nums.length;i++){
//      map.put(nums[i],i);
//    }
    for (int i = 0; i < nums.length; i++) {
      int sub = target - nums[i];

      if (map.containsKey(sub)) {
        return new int[]{i, map.get(sub)};
      }
      map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
  }

  @Test
  public void test3() {
    int[] aa = new int[]{1, 2, 3};
    int result = 4;
    int[] ints = twoSum2(aa, result);
    for (int i = 0; i < ints.length; i++) {
      System.out.println(ints[i]);
    }
  }


  /**
   * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
   */
  public int lengthOfLongestSubstring(String s) {
    int n = s.length();
    int ans = 0;//保存当前得到满足条件的子串的最大值
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j <= n; j++) //之所以 j<= n，是因为我们子串是 [i,j),左闭右开
      {
        if (allUnique(s, i, j)) {
          ans = Math.max(ans, j - i); //更新 ans
        }
      }
    }
    return ans;
  }

  public boolean allUnique(String s, int start, int end) {
    Set<Character> set = new HashSet<>();//初始化 hash set
    for (int i = start; i < end; i++) {//遍历每个字符
      Character ch = s.charAt(i);
      if (set.contains(ch)) {
        return false; //判断字符在不在 set 中
      }
      set.add(ch);//不在的话将该字符添加到 set 里边
    }
    return true;
  }

  @Test
  public void test4() {
//    String temp = "abcdddcfghijd";
//    int i1 = lengthOfLongestSubstring(temp);
//    System.out.println("最大子串的长度是:"+i1);

    List<String> list = new ArrayList<>();
    setList(list);
    System.out.println(list.size());
  }

  private void setList(List<String> list) {
    list.add("abc");
  }

  @Test
  public void test5() {
//    LocalDateTime startTime = LocalDateTime.now();
//    try {
//      Thread.sleep(1000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//    Duration duration = Duration.between(startTime, LocalDateTime.now());
//
//    System.out.println("间隔为:"+duration.toMillis());

    //6000ms 转换成minute
    long convert = TimeUnit.MINUTES.convert(60000, TimeUnit.MILLISECONDS);

    for (int i = 1; i <= 8; i++) {
      int nextMinute = (1 << i) - (1 << (i - 1));
      System.out.println(nextMinute);
    }


  }

//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
  /**
   * java 8 的新特性
   */
  @Test
  public void setList(){
    List<String> names1 = new ArrayList<String>();
    names1.add("Google ");
    names1.add("Runoob ");
    names1.add("Taobao ");
    names1.add("Baidu ");
    names1.add("Sina ");

    Iterator<String> iterator = names1.iterator();
    while (iterator.hasNext()){
      String next = iterator.next();
      if("Baidu".equals(next.trim())){
        iterator.remove();
      }
    }

    names1.forEach(System.out::println);


    List<String> names2 = new ArrayList<>();
    names2.add("Google ");
    names2.add("Runoob ");
    names2.add("Taobao ");
    names2.add("Baidu ");
    names2.add("Sina ");

//    Java8Tester tester = new Java8Tester();
//    System.out.println("使用 Java 7 语法: ");
//
//    tester.sortUsingJava7(names1);
//    System.out.println(names1);
//    System.out.println("使用 Java 8 语法: ");

//    sortUsingJava8(names2);
//    names2.forEach(System.out::println);
//    System.out.println(names2);
  }

  /**
   * java8 的排序
   */
  public void sortUsingJava8(List<String> nameList) {
    java.util.Collections.sort(nameList, String::compareTo);

    MathOperation addMathOperation = (a,b) ->a+b;
    int operate = operate(5, 8, addMathOperation);
    System.out.println(operate);
  }

  interface MathOperation {
    int operation(int a, int b);
  }

  private int operate(int a, int b, MathOperation mathOperation){
    return mathOperation.operation(a, b);
  }

  /**
   * 函数式接口
   */
  public static void eval(List<Integer> list, Predicate<Integer> predicate) {
//    for(Integer n: list) {
//
//      if(predicate.test(n)) {
//        System.out.println(n + " ");
//      }
//    }
    list.stream().filter(predicate).forEach(System.out::println);
  }

  @Test
  public void testPredicate(){
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

    // Predicate<Integer> predicate = n -> true
    // n 是一个参数传递到 Predicate 接口的 test 方法
    // n 如果存在则 test 方法返回 true

    System.out.println("输出所有数据:");

    // 传递参数 n
//    eval(list, n->true);
    //用下面的代替
    list.forEach(System.out::println);

    // Predicate<Integer> predicate1 = n -> n%2 == 0
    // n 是一个参数传递到 Predicate 接口的 test 方法
    // 如果 n%2 为 0 test 方法返回 true

    System.out.println("输出所有偶数:");
//    eval(list, n-> n%2 == 0 );
    list.stream().filter(n -> n%2 == 0).forEach(System.out::println);

    System.out.println("输出所有奇数:");
//    eval(list,n-> n%2 == 1);
    list.stream().filter(n -> n%2 ==1).forEach(System.out::println);
    // Predicate<Integer> predicate2 = n -> n > 3
    // n 是一个参数传递到 Predicate 接口的 test 方法
    // 如果 n 大于 3 test 方法返回 true

    System.out.println("输出大于 3 的所有数字:");
//    eval(list, n-> n > 3 );
    list.stream().filter(n -> n > 3).forEach(System.out::println);


  }

  /**
   * IntStream
   */
  @Test
  public void testStreamFunction(){
    Random random = new Random();
    System.out.println("生成的正数随机数为:");
    random.ints().filter(n -> n > 0).limit(5).forEach(System.out::println);

    List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
    System.out.println("输出每个元素不相同的平方值:");
    numbers.stream().map(n -> n*n).distinct().forEach(System.out::println);
    System.out.println("获取元素不同的集合:");
    numbers.stream().distinct().forEach(System.out::println);

    List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
    System.out.println("输出非空字符串:");
    strings.stream().filter(str -> !StringUtils.isEmpty(str)).forEach(System.out::println);

    int nowTime = LocalDateTime.now().getHour();
    System.out.println("nowTime:"+nowTime);

    List<Integer> numberList = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
    IntSummaryStatistics intSummaryStatistics = numberList.stream().mapToInt((n) ->n).summaryStatistics();
    System.out.println("总和是:"+intSummaryStatistics.getSum());
    System.out.println("最大值是:"+intSummaryStatistics.getMax());
    System.out.println("最小值是:"+intSummaryStatistics.getMin());
    System.out.println("平均值是:"+intSummaryStatistics.getAverage());
  }

  @Test
  public void testOptional(){
    Integer a = null;
    Optional<Integer> optional1 = Optional.ofNullable(a);
    Integer otherA = optional1.orElse(8);
    boolean present = optional1.isPresent();
    System.out.println("a为："+a);
    System.out.println("otherA为："+otherA);
    System.out.println("present为："+present);
  }

  /**
   * 测试本地时间
   */
  @Test
  public void testLocalDateTime(){
    LocalDateTime localDateTime = LocalDateTime.now();
    System.out.println(localDateTime);

    LocalDate localDate = localDateTime.toLocalDate();
    System.out.println(localDate);

    System.out.println(localDate.getMonthValue()+"月"+localDate.getDayOfMonth()+"日"+localDateTime.getHour()+"时"+localDateTime.getMinute()+"分");

    LocalDateTime date2 = localDateTime.withDayOfMonth(10).withYear(2018);
    System.out.println("date2: " + date2);

    ZoneId currentZone = ZoneId.systemDefault();
    System.out.println("当期时区: " + currentZone);

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String format = simpleDateFormat.format(new Date());
    System.out.println(format);

    LocalDateTime localDateTime1 = LocalDateTime.now();
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String format1 = localDateTime1.format(dateTimeFormatter);
    System.out.println(format1);
  }

  /**
   * 输入整数，输出它的倒置。
   * 注意：判断是不是溢出
   */
  @Test
  public void testCalculate1(){
    int num = 123456789;
    int result = reverse(num);
    System.out.println("result is :"+result);
  }

  public int reverse(int x) {
    long rev = 0;
    while (x != 0) {
      int pop = x % 10;
      x /= 10;
      rev = rev * 10 + pop;
    }
    if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE ){
      return 0;
    }
    return (int)rev;
  }

  /**
   * 整体的思路就是遍历字符串，然后依次取出一个字符就可以了。无非是考虑一些特殊情况，还有就是理解题目意思。
   * 经过多次试错，题目的意思是这样的。
   * 从左遍历字符串，可以遇到空格，直到遇到 ' + ' 或者数字或者 ' - ' 就表示要转换的数字开始，如果之后遇到除了数字的其他字符（包括空格）就结束遍历，
   * 输出结果，不管后边有没有数字了，例如 " - 32332ada2323" 就输出 "- 32332"。
   * 如果遇到空格或者 ' + ' 或者数字或者 ' - ' 之前遇到了其他字符，就直接输出 0 ，例如 " we1332"。
   * 如果转换的数字超出了 int ，就返回 intMax 或者 intMin。
   */
  @Test
  public void testCalculate2(){
   //  we1332  => 0
    //  - 32332ada2323 => -32332
    int result = myAtoi("- 32332ada2323");
    System.out.println(result);
  }

  public int myAtoi(String str) {
    int sign = 1;
    int ans = 0, pop = 0;
    boolean hasSign = false; //代表是否开始转换数字
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '-' && !hasSign) {
        sign = -1;
        hasSign = true;
        continue;
      }
      if (str.charAt(i) == '+' && !hasSign) {
        sign = 1;
        hasSign = true;
        continue;
      }
      if (str.charAt(i) == ' ' && !hasSign) {
        continue;
      }

      if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
        hasSign = true;
        pop = str.charAt(i) - '0';
        //和上道题判断出界一个意思只不过记得乘上 sign 。
        if (ans * sign > Integer.MAX_VALUE / 10 || (ans * sign == Integer.MAX_VALUE / 10 && pop * sign > 7))
          return 2147483647;
        if (ans * sign < Integer.MIN_VALUE / 10 || (ans * sign == Integer.MIN_VALUE / 10 && pop * sign < -8))
          return -2147483648;
        ans = ans * 10 + pop;
      } else {
        return ans * sign;
      }
    }
    return ans * sign;
  }

  /**
   * 判断是否是回文串
   * 一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。
   */
  @Test
  public void testCalculate3(){
    boolean result = check("levele");
    System.out.println(result);
  }

  public  boolean check(String str){
    if(null == str || "".equals(str)){
      return false;
    }
    int i = 0;
    int j = str.length() - 1;
    String[] strings = str.split("");
    for (; i <= j; i++,j--) {
      if(!strings[i].equals(strings[j])){
        return false;
      }
    }
    return true;
  }

  @Test
  public void testCalculate4(){
    Double dd = 3.1415926;
    DecimalFormat decimalFormat = new DecimalFormat("0.00");
    String format = decimalFormat.format(dd);
    System.out.println(format);
  }

  @Test
  public void testCalculate5(){
    Map map = new HashMap();
    map.put("name",20);
    map.put("age",21);
    List<Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
    list.sort(ComparatorUtil.valueComparator());
    list.stream().forEach(System.out::println);

//    String aff = null;
//    assert aff != null;

    String str = "";
    if(str.equals("")){
      System.out.println("success");
    }


  }

}

package com.garfield.testorika;

import com.garfield.testorika.config.PersonCustomMapper;
import com.garfield.testorika.domain.bo.Person3BO;
import com.garfield.testorika.domain.bo.PersonneBO;
import com.garfield.testorika.domain.bo.TargetBO;
import com.garfield.testorika.domain.vo.Person3VO;
import com.garfield.testorika.domain.vo.PersonNameList;
import com.garfield.testorika.domain.vo.PersonNamePartsVO;
import com.garfield.testorika.domain.vo.PersonVO;
import com.garfield.testorika.domain.vo.SourceVO;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.SocketUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestorikaApplicationTests {

  /**
   * MapperFacade 单个对象的复制 SourceVO 转 TargetBO
   */
  @Test
  public void sourceVOToTargetBO() {
    MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
    MapperFacade mapperFacade = mapperFactory.getMapperFacade();
    SourceVO sourceVO = new SourceVO("jingly", 27);
    TargetBO targetBO = mapperFacade.map(sourceVO, TargetBO.class);
    System.out.println(targetBO.toString());
  }

  /**
   * MapperFacade 单个对象的复制  TargetBO转 SourceVO
   */
  @Test
  public void targetBOToSourceVO() {
    MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
    MapperFacade mapperFacade = mapperFactory.getMapperFacade();
    TargetBO targetBO = new TargetBO("jingly", 27);
    //两个对象相互转换都用 map()
    SourceVO sourceVO = mapperFacade.map(targetBO, SourceVO.class);
    System.out.println(sourceVO.toString());
  }

  /**
   * 单个对象的复制 SourceVO 转 TargetBO BoundMapperFacade 代替缺省性能较慢的 MapperFacade 类
   */
  @Test
  public void sourceVOToTargetBOBoundMapperFacade() {
    MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
    BoundMapperFacade mapperFacade = mapperFactory.getMapperFacade(SourceVO.class, TargetBO.class);
    SourceVO sourceVO = new SourceVO("jingly", 27);
    TargetBO targetBO = (TargetBO) mapperFacade.map(sourceVO);
    System.out.println(targetBO.toString());
  }

  /**
   * BoundMapperFacade 单个对象的复制  TargetBO转 SourceVO
   */
  @Test
  public void targetBOToSourceVOBoundMapperFacade() {
    MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
    BoundMapperFacade mapperFacade = mapperFactory.getMapperFacade(SourceVO.class, TargetBO.class);
    TargetBO targetBO = new TargetBO("jingly", 27);
    //两个对象相互转换都用 map()
    SourceVO sourceVO = (SourceVO) mapperFacade.mapReverse(targetBO);
    System.out.println(sourceVO.toString());
  }

  /**
   * MapperFacade 对象属性名称不同的复制 PersonVO 转 PersonneBO
   */
  @Test
  public void personVOToPersonneBO() {
    //通过调用byDefault()方法，我们已经使用ClassMapBuilder API配置映射行为：
    // byDefault()映射所有字段使用缺省配置
    //register()方法，为了给MapperFactory注册配置信息
    MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
    mapperFactory.classMap(PersonVO.class, PersonneBO.class).field("name", "nom")
        .field("nickname", "surnom").byDefault().register();
    MapperFacade mapperFacade = mapperFactory.getMapperFacade();
    PersonVO personVO = new PersonVO("jly", "jingly", 27);
    PersonneBO personneBO = mapperFacade.map(personVO, PersonneBO.class);
    System.out.println(personneBO.toString());
  }

  /**
   * MapperFacade 对象属性名称不同的复制,排除某些属性  PersonneBO转  PersonVO exclude()
   */
  @Test
  public void personneBOToPersonVO() {
    //通过调用byDefault()方法，我们已经使用ClassMapBuilder API配置映射行为：
    // byDefault()映射所有字段使用缺省配置
    //register()方法，为了给MapperFactory注册配置信息
    MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
    mapperFactory.classMap(PersonVO.class, PersonneBO.class).exclude("name")
        .field("nickname", "surnom").byDefault().register();
    MapperFacade mapperFacade = mapperFactory.getMapperFacade();
    PersonneBO personneBO = new PersonneBO("jly", "jingly", 27);
    PersonVO personVO = mapperFacade.map(personneBO, PersonVO.class);
    System.out.println(personVO.toString());
  }

  /**
   * List 对象属性的复制
   */
  @Test
  public void personNameListToPersonNamePartsVO() {
    //通过调用byDefault()方法，我们已经使用ClassMapBuilder API配置映射行为：
    // byDefault()映射所有字段使用缺省配置
    //register()方法，为了给MapperFactory注册配置信息
    MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
    //假设我们确定索引0映射到firstName，索引1映射至lastName。Orika允许使用括号来表示集合成员
    mapperFactory.classMap(PersonNameList.class, PersonNamePartsVO.class)
        .field("nameList[0]", "firstName")
        .field("nameList[1]", "lastName").byDefault().register();
    MapperFacade mapperFacade = mapperFactory.getMapperFacade();
    List<String> nameList = Arrays.asList(new String[]{"jingly", "jingsj"});
    PersonNameList personNameList = new PersonNameList(nameList);
    PersonNamePartsVO personNamePartsVO = mapperFacade.map(personNameList, PersonNamePartsVO.class);
    System.out.println(personNamePartsVO.toString());
  }

  /**
   * 缺省情况下，遇到null值会映射
   */
  @Test
  public void givenSrcWithNullField_whenMapsThenCorrect() {
    MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
    mapperFactory.classMap(SourceVO.class, TargetBO.class).byDefault();
    MapperFacade mapper = mapperFactory.getMapperFacade();
    SourceVO src = new SourceVO(null, 10);
    TargetBO targetBO = mapper.map(src, TargetBO.class);
    System.out.println(targetBO.toString());
  }

  /**
   * 设置源对象某些属性为null值，目标对象有值，不覆盖
   */
  @Test
  public void givenSrcWithNullAndGlobalConfigForNoNull_whenFailsToMap_ThenCorrect() {
    //mapNulls(false)
    //映射null值可以通过ClassMapBuilder类mapNulls(true|false)方法进行控制，
    // 或 mapNullsInReverse(true|false)方法进行反向映射控制。
    MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).build();
    mapperFactory.classMap(SourceVO.class, TargetBO.class).byDefault();
    MapperFacade mapper = mapperFactory.getMapperFacade();
    SourceVO src = new SourceVO(null, 10);
    TargetBO targetBO = new TargetBO("jly", 10);
    mapper.map(src, TargetBO.class);
    System.out.println(targetBO.toString());
  }

  /**
   * 对象类型不一样时的复制
   * (此方法没有生效)
   */
  @Test
  public void givenSrcAndDest_whenCustomMapperWorks_thenCorrect() {
    PersonCustomMapper personCustomMapper = new PersonCustomMapper();
    //mapNulls(false)
    //映射null值可以通过ClassMapBuilder类mapNulls(true|false)方法进行控制，
    // 或 mapNullsInReverse(true|false)方法进行反向映射控制。
    MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).build();
    mapperFactory.classMap(Person3BO.class, Person3VO.class).customize(personCustomMapper).byDefault();
    MapperFacade mapper = mapperFactory.getMapperFacade();
    String dateTime = "2007-06-26T21:22:39Z";
    long timestamp = new Long("1182882159000");
    Person3BO person3BO = new Person3BO("Leornardo", timestamp);
    Person3VO person3VO = mapper.map(person3BO, Person3VO.class);
    System.out.println(person3VO.toString());
  }


  @Test
  public void helloWorld() {
    ExpressionParser parser = new SpelExpressionParser();
    Expression expression = parser.parseExpression("('Hello' + ' World').concat(#end)");
    EvaluationContext context = new StandardEvaluationContext();
    context.setVariable("end", "!");
    Object value = expression.getValue(context);
    System.out.println("value is :"+value);
  }

  @Test
  public void testEL(){
//    String test = " '车' matches '.*(开车|开会).*' ";
//
//    SpelExpressionParser expressionParser = new SpelExpressionParser();
//    Boolean expressionRes = expressionParser.parseExpression(test).getValue(Boolean.class);
//    System.out.println(expressionRes);

    String uuid = UUID.randomUUID().toString();
    Integer length = uuid.length();
    System.out.println(length);

  }

  /**
   * com.google.common.collect.Lists 类的用法
   */
  @Test
  public void testPartition(){
    //step.1 集合切割正常逻辑
    List<Integer> numList = Lists.newArrayList(1,2,3,4,5,6,7);
    List<List<Integer>> partitionList = Lists.partition(numList, 3);
    if(!ObjectUtils.isEmpty(partitionList)){
      for (List<Integer> item : partitionList){
        System.out.println("集合切割正常逻辑:"+item);
      }
    }

    //step.2 切割数量大于集合数量
    List<Integer> numList2 = Lists.newArrayList(1);
    List<List<Integer>> partitionList2 = Lists.partition(numList2, 3);
    if(!CollectionUtils.isEmpty(partitionList2)){
      for (List<Integer> item : partitionList2){
        System.out.println("切割数量大于集合数量:"+item);
      }
    }

    //step.3 修改切割后的集合，检查原集合是否被修改
    //原集合会被修改
    //partition返回的是原list的subview.视图,即原list改变后,partition之后的结果也会随着改变
    List<Integer> numList3 = Lists.newArrayList(1,2,3,4,5,6,7,89,9);
    List<List<Integer>> partList3 = Lists.partition(numList3, 3);
    numList3.set(4,77);
    if (!CollectionUtils.isEmpty(partList3)) {
      for (List<Integer> list : partList3) {
//        for(int i=0,len = list.size();i<len;i++){
//          list.set(i,8);
//        }
        System.out.println(list);
      }
      //打印原集合
      System.out.println(numList3.toString());

    }
  }

  @Test
  public void testList(){
    List<String> list = new ArrayList<>();
    addList(list);
    System.out.println(list.size());
  }

  private void addList(List<String> list){
    list.add("jly");

  }

  @Test
  public void testCollectors(){
    // 定义人名数组
    final String[] names = {"Zebe", "Hebe", "Mary", "July", "David"};
    Stream<String> stream1 = Stream.of(names);
    Stream<String> stream2 = Stream.of(names);
    Stream<String> stream3 = Stream.of(names);
// 拼接成 [x, y, z] 形式
    String result1 = stream1.collect(Collectors.joining(", ", "[", "]"));
// 拼接成 x | y | z 形式
    String result2 = stream2.collect(Collectors.joining(" | ", "", ""));
// 拼接成 x -> y -> z] 形式
    String result3 = stream3.collect(Collectors.joining(" -> ", "", ""));
    System.out.println(result1);
    System.out.println(result2);
    System.out.println(result3);

    //stream3使用过流已关闭，再次使用会报错 ，流类型于迭代器
    String result4 = stream3.collect(Collectors.joining(" -> ", "", ""));
    System.out.println(result4);

  }


}

package com.garfield.teststream.util;

import static com.garfield.teststream.constant.SensitiveType.PHONE;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.garfield.teststream.annotation.SensitiveInfo;
import com.garfield.teststream.domain.CardInfo;
import com.garfield.teststream.domain.Person;
import java.lang.reflect.Field;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: Jingly
 * @create: 2019-08-12 15:00
 **/
public class SensitiveInfoUtils {
  public static String toJsonString(Object object) {
    return JSON.toJSONString(object, getValueFilter());
  }

  private static String desensitizePhoneOrIdCard(String num) {
    if (StringUtils.isEmpty(num)) {
      return "";
    }
    return StringUtils.left(num, 3).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(num, 4), StringUtils.length(num), "*"), "***"));
  }

  private static String desensitizeBankCard(String cardNum) {
    if (StringUtils.isBlank(cardNum)) {
      return "";
    }
    return StringUtils.left(cardNum, 4).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(cardNum, 4), StringUtils.length(cardNum), "*"), "****"));
  }

  private static final ValueFilter getValueFilter() {
    return new ValueFilter() {
      @Override
      public Object process(Object obj, String key, Object value) {//obj-对象  key-字段名  value-字段值
        try {
          Field field = obj.getClass().getDeclaredField(key);
          SensitiveInfo annotation = field.getAnnotation(SensitiveInfo.class);
          if (null != annotation && value instanceof String) {
            String strVal = (String) value;
            if (StringUtils.isNotBlank(strVal)) {
              switch (annotation.value()) {
                case PHONE:
                  return desensitizePhoneOrIdCard(strVal);
                case ID_CARD:
                  return desensitizePhoneOrIdCard(strVal);
                case BANK_CARD:
                  return desensitizeBankCard(strVal);
                default:
                  break;
              }
            }
          }
        } catch (NoSuchFieldException e) {
          //找不到的field对功能没有影响,空处理
        }
        return value;
      }
    };
  }

  public static void main(String[] args) {
//    CardInfo cardInfo = new CardInfo();
//    cardInfo.setId("11111111111111111");
//    cardInfo.setCardId("6228480402564890018");
//    System.out.println(SensitiveInfoUtils.toJsonString(cardInfo));

//    Person person = Person.builder().age(27).name("加菲猫").build();
//    System.out.println(person);



  }

//  public static String getData(String key){
//    //从缓存中获取数据
//    String result = getDataFromRedis();
//    if(org.springframework.util.StringUtils.isEmpty(result)){
//      //去获取锁，获取成功后，从数据库获取数据
//      if(reenLock.tryLock()){
//        try{
//          result = getDataFromMySQL();
//          //更新缓存数据
//          if(!org.springframework.util.StringUtils.isEmpty(result)){
//            setDataCache(key,result);
//          }
//        }finally {
//          //释放锁
//          reenLock.unLock();
//        }
//
//      }else{
//        //获取锁失败
//        try {
//          //暂停100ms后再重新获取数据
//          Thread.sleep(100);
//          getData(key);
//        } catch (InterruptedException e) {
//          e.printStackTrace();
//        }
//
//      }
//    }
//    return result;
//  }
}

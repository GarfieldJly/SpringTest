package com.garfield.teststream.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;


import com.garfield.teststream.domain.Person;
import com.garfield.teststream.domain.SmsConfigRequestParam;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.http.HttpMethod;

/**
 * @author: Jingly
 * @create: 2019-08-13 11:16
 **/
public class ObjectMapperUtils {
  public static void main(String[] args){
//    ObjectMapper objectMapper = new ObjectMapper();
//    String json = "{\"name\":\"jly\", \"age\":21}";
//    try {
//      Person person = objectMapper.readValue(json, Person.class);
//      System.out.println(person);
//
//      objectMapper.enable(Feature.INCLUDE_SOURCE_IN_LOCATION);
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//
//    String temp1 = "type=,sign=aiccSign";
//    String[] split = temp1.split(",");
//    for (int i = 0; i < split.length; i++) {
//      String temp2 = split[i];
//      String[] split1 = temp2.split("=");
//      System.out.println(split1.length);
//      for (int j = 0; j < split1.length; j++) {
//        String temp3 = split1[j];
//        System.out.println(temp3);
//      }
//    }


//    List<SmsConfigRequestParam> list = new ArrayList();
//    SmsConfigRequestParam smsConfigRequestParam1 = new SmsConfigRequestParam("mobile","aiccPhone",false,"",",");
//    SmsConfigRequestParam smsConfigRequestParam2 = new SmsConfigRequestParam("sTime","",true,"ms","");
//    SmsConfigRequestParam smsConfigRequestParam3 = new SmsConfigRequestParam("sign","aiccSign",true,"JinZhiMd5","");
//    list.add(smsConfigRequestParam1);
//    list.add(smsConfigRequestParam2);
//    list.add(smsConfigRequestParam3);
//
//    SmsConfigRequestParam smsConfigRequestParam = list.stream().findFirst().get();
//    System.out.println(smsConfigRequestParam);
////    System.out.println(list);
//
//    JSONArray jsonArray = new JSONArray();
//    jsonArray.add(smsConfigRequestParam1);
//    jsonArray.add(smsConfigRequestParam2);
//    jsonArray.add(smsConfigRequestParam3);
//    JSONObject jsonObject = new JSONObject();
//    jsonObject.put("smsConfigRequestParam",jsonArray);
//    System.out.println(jsonObject);

//    StringBuilder stringBuilder = new StringBuilder();
//    stringBuilder.append("jly").append("=").append("name").append("&");
//    String parameter = stringBuilder.toString();
//    parameter = parameter.substring(0,parameter.length()-1);
//    System.out.println(parameter);

//    String requestType = "Get";
//    if (HttpMethod.GET.matches(requestType.toUpperCase())) {
//      System.out.println("true");
//    }else {
//      System.out.println("false");
//    }

//    Pattern successPattern = Pattern.compile("^0");
//    Matcher matcher = successPattern.matcher("1,0suc");
//    if (matcher.find()) {
//      System.out.println("success");
//    }else{
//      System.out.println("fail");
//    }

//    List<String> list1 = new ArrayList<>() ;
//    list1.add("1");
//    list1.add("2");
//    list1.add("3");
//    list1.add("4");
//
//    List<String> list2 = new ArrayList<>() ;
//    list2.add("3");
//    list2.add("4");
//
//    list2.retainAll(list1);
//    System.out.println(list2.size() > 0);


    try{
      String temp = null;
      Objects.requireNonNull(temp).substring(0,2);
    }catch (Exception e){
      System.out.println(e.getMessage());
    }
  }

}

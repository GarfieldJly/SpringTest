package com.garfield.testorika.config;

import com.garfield.testorika.domain.bo.Person3BO;
import com.garfield.testorika.domain.vo.Person3VO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

/**
 * 不标记哪个是源，哪个是目标，因为CustomMapper允许处理双向映射。
 */
public class PersonCustomMapper extends CustomMapper<Person3BO,Person3VO> {

  @Override
  public void mapBtoA(Person3VO person3VO, Person3BO person3BO, MappingContext context) {
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    Date date = null;
    try {
      date = format.parse(person3VO.getDtob());
    } catch (ParseException e) {
      e.printStackTrace();
    }
    long timestamp = date.getTime();
    person3BO.setDtob(timestamp);
  }

  @Override
  public void mapAtoB(Person3BO person3BO, Person3VO person3VO, MappingContext context) {
    Date date = new Date(person3BO.getDtob());
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    String isoDate = format.format(date);
    person3VO.setDtob(isoDate);
  }
}

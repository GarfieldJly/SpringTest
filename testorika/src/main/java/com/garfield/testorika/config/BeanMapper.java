package com.garfield.testorika.config;

import com.garfield.testorika.domain.bo.Person3BO;
import com.garfield.testorika.domain.bo.TargetBO;
import com.garfield.testorika.domain.vo.Person3VO;
import com.garfield.testorika.domain.vo.SourceVO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

/**
 * 与spring 集成仅需定义统一的mapperFactory，然后把需要转换的bean依次注册至mapperFactory
 */
@Component
public class BeanMapper extends ConfigurableMapper {

  @Override
  protected void configure(MapperFactory factory) {
    factory.classMap(SourceVO.class, TargetBO.class).byDefault().mapNulls(false).register();

    factory.classMap(Person3VO.class, Person3BO.class).customize(
        new CustomMapper<Person3VO, Person3BO>() {
          @Override
          public void mapAtoB(Person3VO person3VO, Person3BO person3BO, MappingContext context) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String value = format.format(person3BO.getDtob());
            person3VO.setDtob(value);
          }

          @Override
          public void mapBtoA(Person3BO person3BO, Person3VO person3VO, MappingContext context) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
              Date date = format.parse(person3VO.getDtob());
              person3BO.setDtob(date.getTime());
            } catch (ParseException e) {
              e.printStackTrace();
            }
          }
        }).byDefault().register();
  }
}

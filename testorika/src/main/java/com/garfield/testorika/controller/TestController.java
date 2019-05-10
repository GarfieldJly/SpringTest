package com.garfield.testorika.controller;

import com.garfield.testorika.config.BeanMapper;
import com.garfield.testorika.domain.bo.Person3BO;
import com.garfield.testorika.domain.bo.TargetBO;
import com.garfield.testorika.domain.vo.Person3VO;
import com.garfield.testorika.domain.vo.SourceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/orika")
@RestController
public class TestController {

    @Autowired
    private BeanMapper beanMapper;


    @PostMapping("/testOrika")
    public TargetBO testOrika(){
        SourceVO sourceVO = new SourceVO("jingliyuan",27);
        TargetBO targetBO = beanMapper.map(sourceVO,TargetBO.class);
        return targetBO;
    }

    @PostMapping("/testCustomerMapper")
    public Person3BO testCustomerMapper(){
        Person3VO person3VO = new Person3VO("jingliyuan","2019-05-09 20:11:14");
        Person3BO person3BO = beanMapper.map(person3VO,Person3BO.class);
        return person3BO;
    }
}

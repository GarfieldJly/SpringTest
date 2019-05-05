package com.garfield.demo.controller;

import com.garfield.demo.service.TestQualifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/qualifier")
@RestController
public class TestController {


    @Qualifier("TestQualifierService2")
    @Autowired
    private TestQualifierService testQualifierService;

    @GetMapping("/show")
    public void sentMail(){
        testQualifierService.testQualifier();
    }
}

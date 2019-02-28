package com.garfield.demo.controller;

import com.garfield.demo.entity.MailEntity;
import com.garfield.demo.service.MailSendService;
import com.garfield.demo.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/mail")
@RestController
public class MailController  {

    @Autowired
    private MailService mailService;

    @Autowired
    private MailSendService mailSendService;

    @GetMapping("/send")
    public void sentMail(){
//        mailService.sendMail();

        mailSendService.sendMail();
    }
}

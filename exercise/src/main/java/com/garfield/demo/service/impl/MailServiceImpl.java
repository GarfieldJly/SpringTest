package com.garfield.demo.service.impl;

import com.garfield.demo.entity.MailEntity;
import com.garfield.demo.service.MailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Properties;

@Service
public class MailServiceImpl implements MailService {

    @Value("${send.mail.to}")
    private String sendMailTo;
    @Value("${send.mail.host}")
    private String sendMailHost;
    @Value("${send.mail.username}")
    private String sendMailUserName;
    @Value("${send.mail.password}")
    private String sendMailPassword;
    @Value("${send.mail.default-encoding}")
    private String sendMailDefaultEncoding;
    @Value("${send.mail.username}")
    private String sendMailFrom;

    @Override
    public void sendMail() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(sendMailHost);
        javaMailSender.setDefaultEncoding(sendMailDefaultEncoding);
        javaMailSender.setUsername(sendMailUserName);
        javaMailSender.setPassword(sendMailPassword);
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.timeout", "25000");
        javaMailSender.setJavaMailProperties(prop);
        // 建立邮件消息
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(sendMailFrom);
        simpleMailMessage.setTo(sendMailTo);
        //设置主题
        simpleMailMessage.setSubject("测试发送邮件");
        simpleMailMessage.setSentDate(new Date());
        simpleMailMessage.setText("测试是否发送邮件");

        javaMailSender.send(simpleMailMessage);

    }
}

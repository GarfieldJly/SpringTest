package com.garfield.demo.service.impl;

import com.garfield.demo.service.MailSendService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.Security;
import java.util.Date;
import java.util.Properties;

/**
 * @author pjk
 * @date 2019-02-12 19:23
 * @since
 */
@Service
public class MailSendServiceImpl implements MailSendService {

    @Value("${send.mail.port}")
    private String port;
    private static final String TO_MAIL = "jingliyuan@jinkejoy.com";
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

    /**
     * 使用加密的方式,利用465端口进行传输邮件,开启ssl
     */
    @Override
    public void sendMail(){
        try {
            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
            //设置邮件会话参数
            Properties props = new Properties();
            //邮箱的发送服务器地址
            props.setProperty("mail.smtp.host", sendMailHost);
            props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            //邮箱发送服务器端口,这里设置为465端口
            props.setProperty("mail.smtp.port", port);
            props.setProperty("mail.smtp.socketFactory.port", port);
            props.put("mail.smtp.auth", "true");

            //获取到邮箱会话,利用匿名内部类的方式,将发送者邮箱用户名和密码授权给jvm
            Session session = Session.getDefaultInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(sendMailUserName, sendMailPassword);
                }
            });
            //通过会话,得到一个邮件,用于发送
            Message msg = new MimeMessage(session);
            //设置发件人
            msg.setFrom(new InternetAddress(sendMailFrom));
            //设置收件人,to为收件人,cc为抄送,bcc为密送
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(TO_MAIL, false));
            msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(sendMailTo, false));
            msg.setSubject("测试邮件");
            //设置邮件消息
            msg.setText("test");
            //设置发送的日期
            msg.setSentDate(new Date());
            //调用Transport的send方法去发送邮件
            Transport.send(msg);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

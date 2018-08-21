package com.garfield.wechatorder;

import com.garfield.wechatorder.service.FileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WechatorderApplicationTests {

    @Autowired
    private FileService fileService;

    @Test
    public void contextLoads() {

//        fileService.readIdiom("D://idiom.json");
        fileService.readXiehouyu("D://xiehouyu.json");
    }

}

package com.example.garfield.redis.service.impl;

import com.example.garfield.redis.config.ProjectConfiguration;
import com.example.garfield.redis.service.PersonService;
import com.example.garfield.redis.util.ExcelUtils;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author: Jingly
 * @create: 2019-09-03 10:49
 **/
@Service
@Slf4j
public class TestService {
  @Autowired
  private  ApplicationContext applicationContext;

  @Autowired
  private ProjectConfiguration projectConfiguration;

  public  void testSeptember(){
    //取出所有的PersonService的实现类的bean
    Map<String, PersonService> beansOfType = applicationContext.getBeansOfType(PersonService.class);
    beansOfType.forEach((k,v) ->{
      System.out.println("key is："+ k + ";; value is:"+v);
    });

  }

  public void downloadSample(HttpServletResponse response) {
    byte[] fileSource = projectConfiguration.fileBytes;
//防止对原数据进行操作
    byte[] fileBytes = Arrays.copyOf(fileSource, fileSource.length);
    //下载模板
    try {
      Workbook wb = WorkbookFactory.create(new ByteArrayInputStream(fileBytes));
      List<String> titleList = new ArrayList();
      titleList.add("兴趣爱好");
      ExcelUtils.export(wb, projectConfiguration.fileName, titleList, response);
    } catch (Exception e) {
      log.info("下载模板出现问题");
      e.printStackTrace();
    }
  }
}

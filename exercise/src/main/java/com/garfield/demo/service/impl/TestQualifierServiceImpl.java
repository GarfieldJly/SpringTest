package com.garfield.demo.service.impl;

import com.garfield.demo.service.TestQualifierService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("TestQualifierService1")
@Slf4j
public class TestQualifierServiceImpl implements TestQualifierService {
    private Logger logger = LoggerFactory.getLogger(TestQualifierServiceImpl.class);
    @Override
    public void testQualifier() {
        logger.info("TestQualifierService1  测试@Qualifier");
    }
}

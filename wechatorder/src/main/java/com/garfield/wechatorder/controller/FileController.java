package com.garfield.wechatorder.controller;

import com.garfield.wechatorder.service.FileService;
import com.garfield.wechatorder.util.ResponseBean;
import com.garfield.wechatorder.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jingly on 2018/8/21.
 */
@RestController
@RequestMapping("file")
public class FileController {
    @Autowired
    private FileService fileService;

    @GetMapping("getAllDivision")
    public ResponseBean<String> getAllDivision(){
        String result = fileService.readIdiom("classpath:idiom.json");
        return ResponseUtil.success(result);
    }
}
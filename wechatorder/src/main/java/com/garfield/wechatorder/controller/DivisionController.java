package com.garfield.wechatorder.controller;

import com.garfield.wechatorder.bean.DivisionBo;
import com.garfield.wechatorder.service.DivisionService;
import com.garfield.wechatorder.dal.domain.DivisionDo;
import com.garfield.wechatorder.util.ResponseBean;
import com.garfield.wechatorder.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Jingly on 2018/8/20.
 */
@RestController
@RequestMapping("division")
public class DivisionController {
    @Autowired
    private DivisionService divisionService;

    @PostMapping("getAllDivision")
    public ResponseBean<List<DivisionBo>> getAllDivision(){
        List<DivisionBo> result = divisionService.getAllDivision();
        return ResponseUtil.success(result);
    }
}
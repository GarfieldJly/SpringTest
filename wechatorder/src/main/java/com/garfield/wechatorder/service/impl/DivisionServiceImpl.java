package com.garfield.wechatorder.service.impl;

import com.garfield.wechatorder.bean.DivisionBo;
import com.garfield.wechatorder.service.DivisionService;
import com.garfield.wechatorder.dal.domain.DivisionDo;
import com.garfield.wechatorder.dal.mapper.DivisionDoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jingly on 2018/8/20.
 */
@Service
public class DivisionServiceImpl implements DivisionService {

    @Autowired
    private DivisionDoMapper divisionDoMapper;

    @Override
    public List<DivisionBo> getAllDivision() {

        return divisionDoMapper.getAllDivision();
    }
}
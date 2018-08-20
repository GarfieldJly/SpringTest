package com.garfield.wechatorder.service;

import com.garfield.wechatorder.bean.DivisionBo;
import com.garfield.wechatorder.dal.domain.DivisionDo;

import java.util.List;

/**
 * Created by Jingly on 2018/8/20.
 */
public interface DivisionService {
    List<DivisionBo> getAllDivision();
}

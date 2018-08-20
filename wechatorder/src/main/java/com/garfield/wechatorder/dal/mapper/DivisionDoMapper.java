package com.garfield.wechatorder.dal.mapper;

import com.garfield.wechatorder.bean.DivisionBo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DivisionDoMapper {
    List<DivisionBo> getAllDivision();
}
package com.garfield.wechatorder.dal.mapper;

import com.garfield.wechatorder.dal.domain.UserDo;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDoMapper {
    List<UserDo> selectAll();
}
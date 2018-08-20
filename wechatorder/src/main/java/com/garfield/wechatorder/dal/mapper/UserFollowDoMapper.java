package com.garfield.wechatorder.dal.mapper;

import com.garfield.wechatorder.dal.domain.UserFollowDo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFollowDoMapper {
    List<UserFollowDo> selectAll();
}
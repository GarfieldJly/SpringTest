package com.garfield.wechatorder.dal.mapper;

import com.garfield.wechatorder.dal.domain.ScenicSpotDo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScenicSpotDoMapper {
    List<ScenicSpotDo> selectAll();
}
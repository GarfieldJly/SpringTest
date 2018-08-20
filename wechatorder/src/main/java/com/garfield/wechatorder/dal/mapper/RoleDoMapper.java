package com.garfield.wechatorder.dal.mapper;

import com.garfield.wechatorder.dal.domain.RoleDo;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoleDoMapper {
    List<RoleDo> selectAll();
}
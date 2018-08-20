package com.garfield.wechatorder.dal.mapper;

import com.garfield.wechatorder.dal.domain.NoteDo;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface NoteDoMapper {
    List<NoteDo> selectAll();
}
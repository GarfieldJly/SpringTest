package com.garfield.wechatorder.dal.mapper;

import com.garfield.wechatorder.dal.domain.NoteCommentDo;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface NoteCommentDoMapper {

    List<NoteCommentDo> selectAll();
}
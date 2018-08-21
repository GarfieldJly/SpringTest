package com.garfield.wechatorder.dal.mapper;

import com.garfield.wechatorder.bean.XiehouyuBo;
import com.garfield.wechatorder.dal.domain.XiehouyuDo;
import com.garfield.wechatorder.query.XiehouyuQuery;
import com.garfield.wechatorder.util.SortPagerQuery;
import com.garfield.wechatorder.util.db.MyMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface XiehouyuDoMapper extends MyMapper<XiehouyuDo> {
    List<XiehouyuBo> getXiehouyuList(SortPagerQuery<XiehouyuQuery> sortPagerQuery);
}
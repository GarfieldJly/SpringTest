package com.garfield.wechatorder.service.impl

import com.garfield.wechatorder.bean.XiehouyuBo
import com.garfield.wechatorder.dal.mapper.XiehouyuDoMapper
import com.garfield.wechatorder.query.XiehouyuQuery
import com.garfield.wechatorder.service.XiehouyuService
import com.garfield.wechatorder.util.ListBean
import com.garfield.wechatorder.util.SortPagerQuery
import com.handarui.qafun.manager.dal.util.extention.startPageQuery
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by Jingly on 2018/8/21.
 */
@Service
class XiehouyuServiceImpl : XiehouyuService {

    @Autowired
    private lateinit var xiehouyuDoMapper: XiehouyuDoMapper

    override fun getXiehouyuList(sortPagerQuery: SortPagerQuery<XiehouyuQuery>): ListBean<XiehouyuBo> {
        return xiehouyuDoMapper.startPageQuery(sortPagerQuery, { xiehouyuDoMapper.getXiehouyuList(sortPagerQuery) })
    }
}
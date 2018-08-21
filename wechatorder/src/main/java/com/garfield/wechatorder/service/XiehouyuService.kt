package com.garfield.wechatorder.service

import com.garfield.wechatorder.bean.XiehouyuBo
import com.garfield.wechatorder.query.XiehouyuQuery
import com.garfield.wechatorder.util.ListBean
import com.garfield.wechatorder.util.SortPagerQuery

/**
 * Created by Jingly on 2018/8/21.
 */
interface XiehouyuService {
    fun getXiehouyuList(sortPagerQuery: SortPagerQuery<XiehouyuQuery>): ListBean<XiehouyuBo>
}
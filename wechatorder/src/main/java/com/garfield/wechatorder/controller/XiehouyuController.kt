package com.garfield.wechatorder.controller

import com.garfield.wechatorder.bean.XiehouyuBo
import com.garfield.wechatorder.query.XiehouyuQuery
import com.garfield.wechatorder.service.XiehouyuService
import com.garfield.wechatorder.util.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by Jingly on 2018/8/21.
 */
@RestController
@RequestMapping("xiehouyu")
class XiehouyuController {

    @Autowired
    lateinit var xiehouyuService: XiehouyuService

    /**
     *  获取歇后语列表
     */
    @PostMapping("getXiehouyuList")
    fun getXiehouyuList(@RequestBody requestBean: RequestBean<SortPagerQuery<XiehouyuQuery>>): ResponseBean<ListBean<XiehouyuBo>> {
        val sortPagerQuery = requestBean.param
        return ResponseUtil.success(xiehouyuService.getXiehouyuList(sortPagerQuery))
    }
}
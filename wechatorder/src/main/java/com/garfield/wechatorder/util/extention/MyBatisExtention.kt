package com.handarui.qafun.manager.dal.util.extention

import com.garfield.wechatorder.util.ListBean
import com.garfield.wechatorder.util.PagerQuery
import com.garfield.wechatorder.util.ValidSortPagerQuery
import com.garfield.wechatorder.util.db.MyMapper
import com.github.pagehelper.Page
import com.github.pagehelper.PageHelper

fun <T, E, K> MyMapper<T>.startPageQuery(pager: PagerQuery<K>, doSelect: () -> List<E>): ListBean<E> {
    val page: Page<E> = PageHelper.startPage<E>(pager.current, pager.pageSize).doSelectPage({ doSelect() })
    val list: List<E> = page.result
    val total = page.total
    return ListBean(total.toInt(), list)
}

fun <T, E, K> MyMapper<T>.startPageQuery(pageNum: Int, pageSize: Int, doSelect: () -> List<E>): ListBean<E> {
    val page: Page<E> = PageHelper.startPage<E>(pageNum, pageSize).doSelectPage({ doSelect() })
    val list: List<E> = page.result
    val total = page.total
    return ListBean(total.toInt(), list)
}

fun <T, E, K> MyMapper<T>.startPageQuery(pager: ValidSortPagerQuery<K>, doSelect: () -> List<E>): ListBean<E> {
    val page: Page<E> = PageHelper.startPage<E>(pager.current, pager.pageSize).doSelectPage({ doSelect() })
    val list: List<E> = page.result
    val total = page.total
    return ListBean(total.toInt(), list)
}
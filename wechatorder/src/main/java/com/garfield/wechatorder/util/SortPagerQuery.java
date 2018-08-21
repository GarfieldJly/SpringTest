package com.garfield.wechatorder.util;

import javax.validation.constraints.Pattern;

/**
 * 分页兼排序查询包装类
 * Created by guofe on 2017/7/27.
 */
public class SortPagerQuery<T> extends PagerQuery<T> {

    /**
     * 正序
     */
    public static final String SORT_ORDER_ASC = "ASC";

    /**
     * 倒序
     */
    public static final String SORT_ORDER_DESC = "DESC";

    /**
     * 排序字段
     */
    @Pattern(regexp = "[a-zA-Z0-9_]+", message = "must be a legal column name")
    private String sortField;

    /**
     * 排序方式，可选值见 SORT_ORDER_ASC 和 SORT_ORDER_DESC，默认为正序
     */
    @Pattern(regexp = "(ASC)|(DESC)", message = "must be one of 'ASC' or 'DESC'")
    private String sortOrder = SORT_ORDER_ASC;

    public SortPagerQuery() {
    }

    public SortPagerQuery(int current, int pageSize, String sortField, String sortOrder, T data) {
        super(current, pageSize, data);
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }
}

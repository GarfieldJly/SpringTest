package com.garfield.wechatorder.util;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ValidSortPagerQuery<T> {

    /**
     * 正序
     */
    public static final String SORT_ORDER_ASC = "ASC";

    /**
     * 倒序
     */
    public static final String SORT_ORDER_DESC = "DESC";

    /**
     * 当前页码，默认值为1
     */
    private int current = 1;

    /**
     * 每页项目数
     */
    private int pageSize = 10;

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

    /**
     * 主体类
     */
    @Valid
    @NotNull
    private T data;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

package com.garfield.wechatorder.util;

/**
 * 分页查询包装类
 * Created by guofe on 2017/7/27.
 */
public class PagerQuery<T> {

    /**
     * 当前页码，默认值为1
     */
    private int current = 1;

    /**
     * 每页项目数
     */
    private int pageSize = 10;

    /**
     * 主体类
     */
    private T data;

    public PagerQuery() {
    }

    public PagerQuery(int current, int pageSize, T data) {
        this.current = current;
        this.pageSize = pageSize;
        this.data = data;
    }

    public int getOffset(){
        return current>1?(current -1)*pageSize:0;
    }

    public int getLimit(){
        return pageSize;
    }

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

package com.garfield.wechatorder.util;

import javax.validation.Valid;

/**
 * json请求的包装类
 * Created by guofe on 2017/7/27.
 */
public class RequestBean<T> {

    /**
     * 请求标识，每次请求应唯一
     */
    private String reqId;

    /**
     * 毫秒时间戳
     */
    private Long timestamp;

    /**
     * 查询参数
     */
    @Valid
    private T param;

    public RequestBean() {
    }

    public RequestBean(String reqId, Long timestamp, T param) {
        this.reqId = reqId;
        this.timestamp = timestamp;
        this.param = param;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }

    @Override
    public String toString() {
        return "RequestBean{" +
                "reqId='" + reqId + '\'' +
                ", timestamp=" + timestamp +
                ", param=" + param +
                '}';
    }
}

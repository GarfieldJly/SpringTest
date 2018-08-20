package com.garfield.wechatorder.util;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public class ResponseUtil {
    public ResponseUtil() {
    }

    public static <T> ResponseBean<T> success(T result) {
        return fail((String)null, 0, "ok", result);
    }

    public static <T> ResponseBean<T> success(String reqId, T result) {
        return fail(reqId, 0, "ok", result);
    }

    /**
     * 封装ResponseBean,无内容
     *
     * @param <T>
     * @return
     */
    public static <T> ResponseBean<T> success() {
        return fail(null, 0, "ok", null);
    }

    /**
     * 返回CommonException作为ResponseBean错误信息
     *
     * @param exception
     * @param <T>
     * @return
     */
    public static <T> ResponseBean<T> fail(CommonException exception) {
        return fail(null, exception.getCode(), exception.getMessage(), null);
    }

    /**
     * 返回ResultEnum
     *
     * @param resultEnum
     * @param <T>
     * @return
     */
    public static <T> ResponseBean<T> fail(IResultEnum resultEnum) {
        return fail(null, resultEnum.getCode(), resultEnum.getMessage(), null);
    }

    /**
     * 返回CommonException作为ResponseBean错误信息
     *
     * @param exception
     * @param <T>
     * @return
     */
    public static <T> ResponseBean<T> fail(String reqId, CommonException exception) {
        return fail(reqId, exception.getCode(), exception.getMessage(), null);
    }

    /**
     * 返回ResultEnum
     *
     * @param resultEnum
     * @param <T>
     * @return
     */
    public static <T> ResponseBean<T> fail(String reqId, IResultEnum resultEnum) {
        return fail(reqId, resultEnum.getCode(), resultEnum.getMessage(), null);
    }

    /**
     * 封装ResponseBean
     *
     * @param code
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ResponseBean<T> fail(int code, String message, T result) {
        ResponseBean<T> responseBean = new ResponseBean();
        responseBean.setCode(code);
        responseBean.setMessage(message);
        responseBean.setResult(result);
        return responseBean;
    }

    public static <T> ResponseBean<T> fail(String reqId, int code, String message, T result) {
        ResponseBean<T> responseBean = new ResponseBean();
        responseBean.setCode(code);
        responseBean.setMessage(message);
        responseBean.setResult(result);
        responseBean.setReqId(reqId);
        return responseBean;
    }

    public static String formatDate(Date date) {
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return format.format(date);
    }

    public static String formatDatetime(Date date, TimeZone tz) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy'T'HH:mm:ss Z");
        df.setTimeZone(tz);
        String nowAsISO = df.format(date);
        return nowAsISO;
    }

    public static String formatTime(Date date, TimeZone tz) {
        DateFormat format = new SimpleDateFormat("HH:mm:ss Z");
        format.setTimeZone(tz);
        return format.format(date);
    }

    public static String formatDatetime(Date date, TimeZone tz, String format) {
        DateFormat df = new SimpleDateFormat(format);
        df.setTimeZone(tz);
        String nowAsISO = df.format(date);
        return nowAsISO;
    }
}

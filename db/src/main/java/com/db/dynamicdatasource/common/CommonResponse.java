package com.db.dynamicdatasource.common;


import com.db.dynamicdatasource.utils.JSONUtil;

/**
 * @Title :通用返回类型
 * @Description :
 * @Author : zhanglz
 * @Date : 2018/8/12
 */
public class CommonResponse {

    private int code;
    private String message;
    private Object data;

    public int getCode() {
        return code;
    }

    public CommonResponse setCode(ResponseCode responseCode) {
        this.code = responseCode.code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CommonResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public CommonResponse setData(Object data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return JSONUtil.toJSONString(this);
    }
}

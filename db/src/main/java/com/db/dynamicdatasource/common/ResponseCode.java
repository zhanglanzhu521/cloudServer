package com.db.dynamicdatasource.common;

/**
 * @Title :返回码
 * @Description :返回码
 * @Author : zhanglz
 * @Date : 2018/8/12
 */
public enum ResponseCode {
    SUCCESS(200),
    FAIL(400),
    UNAUTHORIZED(401),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500);

    public int code;

    ResponseCode(int code) {
        this.code = code;
    }
}

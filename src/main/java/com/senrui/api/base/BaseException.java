package com.senrui.api.base;

/**
 * @Author:ljl
 * @Date:2024/6/29
 * @VERSION:1.0
 */
public class BaseException extends RuntimeException {
    private Integer code;

    public BaseException(String message) {
        this(message, 500);
    }

    public BaseException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

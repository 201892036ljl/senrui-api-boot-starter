package com.senrui.api.entity;

import java.io.Serializable;

/**
 * @Author:ljl
 * @Date:2024/6/29
 * @VERSION:1.0
 */
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean success;

    private T data;

    private String message;

    private Integer code;

    public BaseResponse() {}

    public BaseResponse(T data) {
        this.data = data;
    }

    public BaseResponse(Boolean success, T data, String message, Integer code) {
        this.success = success;
        this.data = data;
        this.message = message;
        this.code = code;
    }

    public static<T> BaseResponse<T> success(T data) {
        return new BaseResponse<T>(true, data, "success", 200);
    }

    public static BaseResponse fail(String message) {
        return new BaseResponse(false, null, message, 500);
    }

    public static BaseResponse fail(String message, Integer code) {
        return new BaseResponse(false, null, message, code);
    }

    public BaseResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    public BaseResponse<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public BaseResponse<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    public BaseResponse<T> setSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    public Boolean getSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}

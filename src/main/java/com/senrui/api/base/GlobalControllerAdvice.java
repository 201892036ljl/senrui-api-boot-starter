package com.senrui.api.base;

import com.senrui.api.entity.BaseResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author:ljl
 * @Date:2024/6/29
 * @VERSION:1.0
 */
@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(BaseException.class)
    public BaseResponse baseExceptionHandler(BaseException e) {
        return BaseResponse.fail(e.getMessage(), e.getCode());
    }

    @ExceptionHandler(Exception.class)
    public BaseResponse exceptionHandler(Exception e) {
        e.printStackTrace();
        return BaseResponse.fail(e.getMessage(), 500);
    }
}

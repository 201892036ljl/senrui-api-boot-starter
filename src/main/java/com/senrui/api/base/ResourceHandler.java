package com.senrui.api.base;

import com.senrui.api.entity.BaseRequest;
import com.senrui.api.entity.BaseResponse;

import java.util.Map;

public interface ResourceHandler {

    public BaseResponse processGet(Map<String, Object> queryParams);

    public BaseResponse processPost(Map<String, Object> queriesParams, BaseRequest baseRequest);

}

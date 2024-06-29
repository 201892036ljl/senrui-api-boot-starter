package com.senrui.api.base;

import com.senrui.api.entity.BaseRequest;
import com.senrui.api.entity.BaseResponse;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author:ljl
 * @Date:2024/6/29
 * @VERSION:1.0
 */
public class AbstractResourceHandler implements ResourceHandler {

    private ConcurrentHashMap<String, Method> actionMap = new ConcurrentHashMap<>();

    @Override
    public BaseResponse processGet(Map<String, Object> queryParams) {
        return process(queryParams, null);
    }

    @Override
    public BaseResponse processPost(Map<String, Object> queryParams, BaseRequest baseRequest) {
        return process(queryParams, baseRequest);
    }

    public BaseResponse process(Map<String, Object> queryParams, BaseRequest baseRequest) {
        String action = (String) queryParams.get("action");
        if (!StringUtils.hasText(action)) {
            return BaseResponse.fail("action is empty");
        }
        Method method = actionMap.get(action);
        if (method != null) {
            return invokeMethod(method, queryParams, baseRequest);
        }
        for (Method declaredMethod : this.getClass().getDeclaredMethods()) {
            if (declaredMethod.getName().equals(action)) {
                actionMap.put(action, declaredMethod);
                return invokeMethod(declaredMethod, queryParams, baseRequest);
            }
        }
        return BaseResponse.fail("request failed!", 500);
    }

    private BaseResponse invokeMethod(Method method, Map<String, Object> queryParams, BaseRequest baseRequest) {
        try {
            if (baseRequest == null) {
                return (BaseResponse) method.invoke(this, queryParams);
            } else {
                return (BaseResponse) method.invoke(this, queryParams, baseRequest);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponse.fail(e.getMessage(), 500);
        }
    }


}

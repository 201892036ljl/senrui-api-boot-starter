package com.senrui.api.base;

import com.senrui.api.entity.BaseRequest;
import com.senrui.api.entity.BaseResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:ljl
 * @Date:2024/6/29
 * @VERSION:1.0
 */
public class ResourceProvider {
    private Map<String, ResourceHandler> resourceHandlerMap = new HashMap<String, ResourceHandler>();

    public Map<String, ResourceHandler> getResourceHandlerMap() {
        return resourceHandlerMap;
    }

    public BaseResponse handleBaseGetRequest(Map<String, Object> queryParams) {
        ResourceHandler resourceHandler = getResourceHandlerByResourceName(queryParams);
        return resourceHandler.processGet(queryParams);
    }

    public BaseResponse handleBasePostRequest(Map<String, Object> queryParams,
                                              BaseRequest baseRequest) {
        ResourceHandler resourceHandler = getResourceHandlerByResourceName(queryParams);
        return resourceHandler.processPost(queryParams, baseRequest);
    }

    private ResourceHandler getResourceHandlerByResourceName(Map<String, Object> queryParams) {
        String resourceName = (String) queryParams.get("resourceName");
        return resourceHandlerMap.get(resourceName);
    }

}

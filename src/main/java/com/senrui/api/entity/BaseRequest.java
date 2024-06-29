package com.senrui.api.entity;

import java.io.Serializable;
import java.util.Map;

/**
 * @Author:ljl
 * @Date:2024/6/29
 * @VERSION:1.0
 */
public class BaseRequest implements Serializable {

    private static final long serialVersionUID = -1L;

    private String requestId;

    private Map<String, Object> body;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }
}

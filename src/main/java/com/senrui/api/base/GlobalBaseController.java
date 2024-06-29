package com.senrui.api.base;

import com.senrui.api.entity.BaseRequest;
import com.senrui.api.entity.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author:ljl
 * @Date:2024/6/29
 * @VERSION:1.0
 */


@RestController
public class GlobalBaseController {

    @Autowired
    private ResourceProvider resourceProvider;

    @GetMapping("/api")
    public BaseResponse handleBaseGetRequest(@RequestParam Map<String, Object> queryParams) {
        return resourceProvider.handleBaseGetRequest(queryParams);
    }

    @PostMapping("/api")
    public BaseResponse handleBasePostRequest(@RequestParam Map<String, Object> queryParams,
                                              @RequestBody BaseRequest baseRequest) {
        return resourceProvider.handleBasePostRequest(queryParams, baseRequest);
    }
}

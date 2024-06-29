package com.senrui.api.base;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Author:ljl
 * @Date:2024/6/29
 * @VERSION:1.0
 */
public class HandlerInjectorBeanPostProcessor implements BeanPostProcessor {

    private ResourceProvider resourceProvider;

    public void setResourceProvider(ResourceProvider resourceProvider) {
        this.resourceProvider = resourceProvider;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        ApiService annotation = bean.getClass().getDeclaredAnnotation(ApiService.class);
        if (annotation != null && bean instanceof ResourceHandler) {
            ResourceHandler resourceHandler = (ResourceHandler) bean;
            resourceProvider.getResourceHandlerMap()
                    .put(resourceHandler.getClass().getAnnotation(ApiService.class).resourceName(),
                            resourceHandler);
        }
        return bean;
    }
}

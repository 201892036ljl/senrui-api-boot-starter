package com.senrui.autoconfigure;

import com.senrui.api.base.GlobalBaseController;
import com.senrui.api.base.HandlerInjectorBeanPostProcessor;
import com.senrui.api.base.ResourceProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;


@ConditionalOnProperty(
    prefix = "senrui.api",
    name = {"auto"},
    havingValue = "true",
    matchIfMissing = true
)
@Configuration
public class ApiAutoConfiguration {

    public ApiAutoConfiguration() {
    }

    @ConditionalOnProperty(
            prefix = "senrui.api.global",
            name = {"enable"},
            havingValue = "true",
            matchIfMissing = true
    )
    @Configuration
    @ComponentScan(basePackages = {"com.senrui.api.base"})
    public static class BaseControllerAutoConfiguration {

        @Bean
        public ResourceProvider resourceProvider() {
            return new ResourceProvider();
        }

        @Bean
        public HandlerInjectorBeanPostProcessor handlerInjectorBeanPostProcessor() {
            HandlerInjectorBeanPostProcessor postProcessor = new HandlerInjectorBeanPostProcessor();
            postProcessor.setResourceProvider(resourceProvider());
            return postProcessor;
        }

    }

}


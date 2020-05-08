package com.example.feignservice.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: demo
 * @description: feign 配置类
 * @author: HyJan
 * @create: 2020-05-07 16:28
 **/
@Configuration
public class FeignConfig {

    /**
     * 配置日志信息
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}

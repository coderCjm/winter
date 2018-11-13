package com.summer.config;

import base.autumn.feign.UserFallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sandog on 2018/11/13.
 */
@Configuration
public class FallbackConfig {

    @Bean
    public UserFallback UserFallback() {
        return new UserFallback();
    }

}

package com.summer.config;

import com.moon.SpringUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sandog on 2018/11/15.
 */
@Configuration
public class ServiceConf {

    @Bean
    public SpringUtil SpringUtil() {
        return new SpringUtil();
    }

}

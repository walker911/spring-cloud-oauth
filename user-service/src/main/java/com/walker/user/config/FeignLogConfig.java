package com.walker.user.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author walker
 * @date 2018/12/28
 */
@Configuration
public class FeignLogConfig {

    @Bean
    public Logger.Level level() {
        return Logger.Level.FULL;
    }
}

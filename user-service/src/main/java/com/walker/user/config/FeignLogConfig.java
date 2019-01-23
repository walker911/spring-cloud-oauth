package com.walker.user.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @author walker
 * @date 2018/12/28
 */
public class FeignLogConfig {

    @Bean
    public Logger.Level level() {
        return Logger.Level.FULL;
    }
}

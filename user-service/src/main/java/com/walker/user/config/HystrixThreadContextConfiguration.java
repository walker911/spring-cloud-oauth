package com.walker.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author walker
 * @date 2018/12/28
 */
@Configuration
public class HystrixThreadContextConfiguration {
    @Bean
    public AuthorizationConcurrencyStrategy authorizationConcurrencyStrategy() {
        return new AuthorizationConcurrencyStrategy();
    }
}

package com.walker.uaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author walker
 * @date 2018/12/20
 */
@EnableEurekaClient
@EnableResourceServer
@SpringBootApplication
public class UaaServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UaaServiceApplication.class, args);
    }
}

package com.walker.uaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author walker
 * @date 2018/12/20
 */
@EnableFeignClients
@EnableResourceServer
@EnableDiscoveryClient
@SpringBootApplication
public class UaaServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UaaServiceApplication.class, args);
    }
}

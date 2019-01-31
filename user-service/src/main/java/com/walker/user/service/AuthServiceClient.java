package com.walker.user.service;

import com.walker.user.config.FeignLogConfig;
import com.walker.user.model.Jwt;
import com.walker.user.service.impl.AuthServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author walker
 * @date 2018/12/21
 */
@FeignClient(value = "uaa-service", fallback = AuthServiceHystrix.class, configuration = FeignLogConfig.class)
public interface AuthServiceClient {

    /**
     * 获取 token
     *
     * @param type grant_type
     * @param username 用户名
     * @param password 密码
     * @return Jwt
     */
    @PostMapping(value = "/uaa/oauth/token")
    Jwt getToken(@RequestParam("grant_type") String type, @RequestParam("username") String username,
                 @RequestParam("password") String password);
}
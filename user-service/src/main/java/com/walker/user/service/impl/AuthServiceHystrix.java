package com.walker.user.service.impl;

import com.walker.user.model.Jwt;
import com.walker.user.service.AuthServiceClient;
import org.springframework.stereotype.Component;

/**
 * @author walker
 * @date 2018/12/21
 */
@Component
public class AuthServiceHystrix implements AuthServiceClient {
    @Override
    public Jwt getToken(String type, String username, String password) {
        return null;
    }
}

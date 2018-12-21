package com.walker.user.model;

import lombok.Data;

/**
 * @author walker
 * @date 2018/12/21
 */
@Data
public class Jwt {

    private String accessToken;

    private String tokenType;

    private int expiresIn;

    private String scope;

    private String jti;
}

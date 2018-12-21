package com.walker.user.dto;

import com.walker.user.model.Jwt;
import com.walker.user.model.User;
import lombok.Data;

/**
 * @author walker
 * @date 2018/12/21
 */
@Data
public class UserLoginDTO {

    private Jwt jwt;

    private User user;
}

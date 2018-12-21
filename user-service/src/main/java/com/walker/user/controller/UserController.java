package com.walker.user.controller;

import com.walker.user.dto.UserLoginDTO;
import com.walker.user.model.User;
import com.walker.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author walker
 * @date 2018/12/21
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(String username, String password) {
        return userService.save(username, password);
    }

    @PostMapping("/login")
    public UserLoginDTO login(String username, String password) {
        return userService.login(username, password);
    }
}

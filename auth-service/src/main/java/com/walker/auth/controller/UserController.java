package com.walker.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author walker
 * @date 2018/12/20
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping(value = "/current")
    public Principal getUser(Principal principal) {
        return principal;
    }
}

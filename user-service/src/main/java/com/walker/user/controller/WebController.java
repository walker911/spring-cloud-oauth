package com.walker.user.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author walker
 * @date 2018/12/23
 */
@RestController
public class WebController {

    @GetMapping("/foo")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getFoo() {
        return "I'm foo, " + UUID.randomUUID().toString();
    }
}

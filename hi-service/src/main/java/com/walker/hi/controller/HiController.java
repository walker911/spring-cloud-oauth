package com.walker.hi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author walker
 * @date 2018/12/21
 */
@Slf4j
@RestController
public class HiController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/hi")
    public String hi() {
        return "hi: " + "I'm from port: " + port;
    }

    @GetMapping("/hello")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public String hello() {
        return "hello";
    }

    @GetMapping("/getPrincipal")
    public OAuth2Authentication getPrincipal(OAuth2Authentication oAuth2Authentication, Principal principal,
                                             Authentication authentication) {
        log.info(oAuth2Authentication.getUserAuthentication().getAuthorities().toString());
        log.info(oAuth2Authentication.toString());
        log.info("principal.toString(): {}", principal.toString());
        log.info("principal.getName(): {}", principal.getName());
        log.info("authentication: {}", authentication.getAuthorities().toString());
        return oAuth2Authentication;
    }
}

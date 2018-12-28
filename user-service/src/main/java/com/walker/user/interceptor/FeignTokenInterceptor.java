package com.walker.user.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * Feign 统一拦截器
 * @author walker
 * @date 2018/12/28
 */
@Configuration
public class FeignTokenInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        String authorization = request.getHeader("Authorization");
        requestTemplate.header("Authorization", authorization);
    }
}

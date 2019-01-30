package com.walker.uaa.feign;

import com.walker.uaa.dto.UserDTO;
import com.walker.uaa.feign.fallback.UserServiceFallbackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author walker
 * @date 2019/1/30
 */
@FeignClient(value = "user-service", fallback = UserServiceFallbackImpl.class)
public interface UserService {
    /**
     * 根据用户名获取用户
     *
     * @param username 用户名
     * @return 用户信息
     */
    @GetMapping(value = "/user/findUserByUsername/{username}")
    UserDTO findUserByUsername(@PathVariable String username);
}

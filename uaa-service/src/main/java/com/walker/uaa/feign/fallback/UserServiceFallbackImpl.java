package com.walker.uaa.feign.fallback;

import com.walker.uaa.dto.UserDTO;
import com.walker.uaa.feign.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author walker
 * @date 2019/1/30
 */
@Slf4j
public class UserServiceFallbackImpl implements UserService {
    @Override
    public UserDTO findUserByUsername(String username) {
        log.error("调用 <{}> 异常，参数：{}", "findUserByUsername", username);
        return null;
    }
}

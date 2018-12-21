package com.walker.user.service;

import com.walker.user.dto.UserLoginDTO;
import com.walker.user.model.User;

/**
 * @author walker
 * @date 2018/12/21
 */
public interface UserService {
    /**
     * 保存
     * @param username
     * @param password
     * @return
     */
    User save(String username, String password);

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    UserLoginDTO login(String username, String password);
}

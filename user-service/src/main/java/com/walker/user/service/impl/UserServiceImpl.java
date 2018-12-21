package com.walker.user.service.impl;

import com.walker.user.dto.UserLoginDTO;
import com.walker.user.exception.UserLoginException;
import com.walker.user.model.Jwt;
import com.walker.user.model.User;
import com.walker.user.repository.UserRepository;
import com.walker.user.service.AuthServiceClient;
import com.walker.user.service.UserService;
import com.walker.user.util.BPwdEncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author walker
 * @date 2018/12/21
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthServiceClient authServiceClient;

    @Override
    public User save(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(BPwdEncoderUtil.encode(password));
        return userRepository.save(user);
    }

    @Override
    public UserLoginDTO login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UserLoginException("error username");
        }
        if (!BPwdEncoderUtil.matches(password, user.getPassword())) {
            throw new UserLoginException("error password");
        }

        Jwt jwt = authServiceClient.getToken("", "password", username, password);
        if (jwt == null) {
            throw new UserLoginException("error internal");
        }

        UserLoginDTO loginDTO = new UserLoginDTO();
        loginDTO.setJwt(jwt);
        loginDTO.setUser(user);
        return loginDTO;
    }
}

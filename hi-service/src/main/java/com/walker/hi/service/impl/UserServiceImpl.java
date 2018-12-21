package com.walker.hi.service.impl;

import com.walker.hi.model.User;
import com.walker.hi.repository.UserRepository;
import com.walker.hi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author walker
 * @date 2018/12/21
 */
@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        return userRepository.save(user);
    }


}

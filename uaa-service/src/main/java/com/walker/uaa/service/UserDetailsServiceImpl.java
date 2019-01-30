package com.walker.uaa.service;

import com.walker.uaa.feign.UserService;
import com.walker.uaa.model.Role;
import com.walker.uaa.model.User;
import com.walker.uaa.repository.RoleRepository;
import com.walker.uaa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author walker
 * @date 2018/12/20
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    private final UserService userService;

    @Autowired
    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("%s, 用户不存在", username));
        }
        List<Role> roles = roleRepository.findRolesByUserId(user.getId());
        user.setRoles(roles);
        return user;
    }
}

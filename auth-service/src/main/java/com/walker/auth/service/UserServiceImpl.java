package com.walker.auth.service;

import com.walker.auth.model.Role;
import com.walker.auth.model.User;
import com.walker.auth.repository.RoleRepository;
import com.walker.auth.repository.UserRepository;
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
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

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

package com.walker.uaa.repository;

import com.walker.uaa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author walker
 * @date 2018/12/20
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

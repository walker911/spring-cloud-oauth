package com.walker.hi.repository;

import com.walker.hi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author walker
 * @date 2018/12/21
 */
public interface UserRepository extends JpaRepository<User, Long> {
}

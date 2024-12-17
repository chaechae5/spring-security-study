package com.chae.security_study.repository;

import com.chae.security_study.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {

    Optional<Users> findUserByUsername(String u);
}

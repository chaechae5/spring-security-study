package com.chae.security_study.repository;

import com.chae.security_study.entity.Product;
import com.chae.security_study.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}

package com.springboot.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.blog.entity.User;


public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByEmail(String email);
}

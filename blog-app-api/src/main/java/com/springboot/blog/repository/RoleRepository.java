package com.springboot.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.blog.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}

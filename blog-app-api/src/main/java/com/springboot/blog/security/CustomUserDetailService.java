package com.springboot.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.springboot.blog.entity.User;
import com.springboot.blog.exception.ApiException;
import com.springboot.blog.repository.UserRepository;

@Component
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    User user =	this.userRepository.findByEmail(username).orElseThrow(
				() -> new ApiException("Username Or Password is Incorrect!!"));
		return user;
	}

}

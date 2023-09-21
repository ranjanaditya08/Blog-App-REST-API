package com.springboot.blog.service;

import com.springboot.blog.payload.JwtAuthRequest;
import com.springboot.blog.payload.JwtAuthResponse;
import com.springboot.blog.payload.UserDto;

public interface AuthService {

	UserDto signup(UserDto userDto);
	
	JwtAuthResponse login(JwtAuthRequest request);
}

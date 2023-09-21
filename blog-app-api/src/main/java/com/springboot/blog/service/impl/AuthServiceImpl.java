package com.springboot.blog.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.springboot.blog.payload.JwtAuthRequest;
import com.springboot.blog.payload.JwtAuthResponse;
import com.springboot.blog.payload.UserDto;
import com.springboot.blog.security.JwtTokenHelper;
import com.springboot.blog.service.AuthService;
import com.springboot.blog.service.UserService;


@Service
public class AuthServiceImpl implements AuthService{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	public UserDto signup(UserDto userDto) {	
		return this.userService.registerNewUser(userDto);
	}

	@Override
	public JwtAuthResponse login(JwtAuthRequest request) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
		String jwt = jwtTokenHelper.generateToken(userDetails);
		JwtAuthResponse response = new JwtAuthResponse();
		response.setToken(jwt);
		response.setUser(this.modelMapper.map(userDetails, UserDto.class));
		return response;
	}

}

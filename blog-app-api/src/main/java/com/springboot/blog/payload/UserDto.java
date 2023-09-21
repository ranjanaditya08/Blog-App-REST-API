package com.springboot.blog.payload;

import java.util.HashSet;
import java.util.Set;


import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private int id;
	
	@NotEmpty(message = "UserName is Empty")
	private String name;
	
	@Email(message = "Email address is not Valid !!")
	private String email;
	
	@NotEmpty
	@Size(min = 4,max = 16,message = "Password must be of min 4 chars and max 16 chars!!")
	private String password;
	
	@NotNull
	private String about;
	
	private Set<RoleDto> roles = new HashSet<>();
}

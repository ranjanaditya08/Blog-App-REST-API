package com.springboot.blog.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {

	private Integer commentId;
	
	private String content;
	
	private UserDto user;
	
}

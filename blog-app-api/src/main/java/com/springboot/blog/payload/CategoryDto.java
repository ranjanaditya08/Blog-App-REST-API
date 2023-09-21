package com.springboot.blog.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

	private int categoryId;
	
	@NotEmpty(message = "Title is Empty!!")
	@Size(min = 4,message = "title size must be greater than 4 char")
	private String categoryTitle;
	
	@NotNull
	private String categoryDescription;
}

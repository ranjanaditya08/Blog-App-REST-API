package com.springboot.blog.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4272016025061738188L;
	
	private String resourceName;
	private String fieldName;
	private int fieldValue;
	private String field;
	
	public ResourceNotFoundException(String resourceName, String fieldName, int fieldValue) {
		super(String.format("%s Not Found With %s : %s",resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public ResourceNotFoundException(String resourceName, String fieldName, String field) {
		super(String.format("%s Not Found With %s : %s",resourceName,fieldName,field));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.field = field;
	}
	
	
}

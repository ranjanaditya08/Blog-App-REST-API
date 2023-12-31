package com.springboot.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.blog.payload.ApiResponse;
import com.springboot.blog.payload.CategoryDto;
import com.springboot.blog.service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
		CategoryDto createdCategory = this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(createdCategory, HttpStatus.CREATED);
	}

	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable int categoryId) {
		CategoryDto categoryDto = this.categoryService.getcategoryById(categoryId);
		return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.OK);
	}

	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,
			@PathVariable int categoryId) {
		CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto, categoryId);
		return new ResponseEntity<CategoryDto>(updatedCategory, HttpStatus.OK);
	}

	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable int categoryId) {
		this.categoryService.deleteCategory(categoryId);
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setMessage("Category Deleted Successfully!!");
		apiResponse.setSuccess(true);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<CategoryDto>> getAllCategory() {
		List<CategoryDto> listOfCategory = this.categoryService.getAllCategory();
		return new ResponseEntity<List<CategoryDto>>(listOfCategory, HttpStatus.OK);
	}
}

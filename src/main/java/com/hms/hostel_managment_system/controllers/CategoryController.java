package com.hms.hostel_managment_system.controllers;

import java.util.List;

import javax.validation.Valid;

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

import com.hms.hostel_managment_system.payload.ApiResponse;
import com.hms.hostel_managment_system.payload.CategoryDto;
import com.hms.hostel_managment_system.services.CategoryService;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	//create
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto cateoDto)
	{
		CategoryDto createCategory= this.categoryService.createCategory(cateoDto);
		 return new ResponseEntity<CategoryDto>(createCategory, HttpStatus.CREATED);	 
		
	}
	
	//UPDATE
	
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer catId)
	{
		CategoryDto updatedCategory= this.categoryService.updateCategory(categoryDto, catId);
		 return new ResponseEntity<CategoryDto>(updatedCategory, HttpStatus.OK);	 
		
	}
	 
	//DELETE
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId)
	{
		 this.categoryService.deleteCategory(catId);
		 return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted successfully !!",true),HttpStatus.OK);	 	
	
	}
	
	//get
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId)
	{
	 CategoryDto categoryDto =this.categoryService.getCategory(catId);
	 return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.OK);
	}
	//get all
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getCategories() 
	{
	List<CategoryDto> categories= this.categoryService.getCategorys();
	return ResponseEntity.ok(categories);
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



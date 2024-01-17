package com.hms.hostel_managment_system.services;

import java.util.List;

import com.hms.hostel_managment_system.entities.Post;
import com.hms.hostel_managment_system.payload.PostDto;
import com.hms.hostel_managment_system.payload.PostResponse;

public interface PostService {
	
	//create
	
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	//update
	
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//delete
	
	void deletePost(Integer postId);
	
	//get all posts
	
	PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy );
	
	//get SINGLE POST
	
	PostDto getPostById(Integer postId);
	
	//get all post by Category
	
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	//get all post by user
	List<PostDto> getPostsByUser(Integer userId);
	
	//post search
	List<PostDto> searchPosts(String keyword);
	

	//Post updatePost(Integer postId);

	//Post updatePost(PostDto postDto, Integer postId);
	
	

}

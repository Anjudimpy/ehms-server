package com.hms.hostel_managment_system.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.hostel_managment_system.entities.Comment;
import com.hms.hostel_managment_system.payload.ApiResponse;
import com.hms.hostel_managment_system.payload.CategoryDto;
import com.hms.hostel_managment_system.payload.CommentDto;
import com.hms.hostel_managment_system.services.CommentService;

@RestController
@RequestMapping("/api/v1/")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/post/{postId}/comments")
	public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto comment, @PathVariable Integer postId )
	{
		CommentDto createComment=this.commentService.createComment(comment, postId);
	
		return new ResponseEntity<CommentDto>(createComment,HttpStatus.CREATED);
			
	}
	
	@DeleteMapping("/comments/{commentId}")
	public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId )
	{
	this.commentService.deleteComment(commentId);
	
		return new ResponseEntity<ApiResponse>(new ApiResponse("Comment deleted Successfully !!", true),HttpStatus.OK);
			
	}
	

}

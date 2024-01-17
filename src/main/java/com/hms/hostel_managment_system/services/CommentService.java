package com.hms.hostel_managment_system.services;

import com.hms.hostel_managment_system.payload.CommentDto;

public interface CommentService {
	
	CommentDto createComment(CommentDto commentDto, Integer postId);
	
	void deleteComment(Integer commentId);

}

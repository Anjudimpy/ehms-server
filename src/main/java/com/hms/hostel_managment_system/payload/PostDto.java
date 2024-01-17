package com.hms.hostel_managment_system.payload;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.hms.hostel_managment_system.entities.Category;
import com.hms.hostel_managment_system.entities.Comment;
import com.hms.hostel_managment_system.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
	
	private Integer postId;
	
	private String title;
	
	private String genders;
	
	private String casteCategory;
	
	private String parents;
	
	private String income;
	
	private String ans;
	
	private String content;
	
	private String  address;
	
	private String curentinstitude;
	
	private String lastinstitude;
	
	private String field1;
	
	private String field2;
	
	private String field3;
	
	private String imageName;
	
	private String imageName1;
	
	private Date addedDate;
	
	private String dateOfBirth;
	
	private String joinDate;
	
	private Integer age;
	
	private String subject;
	
	private Integer marks;
	
	private CategoryDto category;
	
	private UserDto user;
	
	private Set<CommentDto> comments=new HashSet<>();
	
	

}

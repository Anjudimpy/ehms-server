package com.hms.hostel_managment_system.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.hostel_managment_system.entities.Category;
import com.hms.hostel_managment_system.entities.Post;
import com.hms.hostel_managment_system.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{

	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	
	List<Post> findByTitleContaining(String title);
	
	
}

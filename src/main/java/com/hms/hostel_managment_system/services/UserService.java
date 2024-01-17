package com.hms.hostel_managment_system.services;
import com.hms.hostel_managment_system.entities.User;
import com.hms.hostel_managment_system.payload.UserDto;
import java.util.List;

public interface UserService {
  
	UserDto registerNewUser(UserDto user);
	
	UserDto createUser(UserDto user); 
	
	UserDto updateUser(UserDto user, Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllUsers();
	
	void deleteUser(Integer userId);
}

package com.hms.hostel_managment_system.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hms.hostel_managment_system.entities.User;
import com.hms.hostel_managment_system.exceptions.ResourceNotFoundException;
import com.hms.hostel_managment_system.repositories.UserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//loading user from database by 
		User user=this.userRepo.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("user","email"+username,0));
		
		return user;
	}

}

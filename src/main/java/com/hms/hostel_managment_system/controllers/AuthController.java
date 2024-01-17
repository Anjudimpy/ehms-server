package com.hms.hostel_managment_system.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.hostel_managment_system.entities.User;
import com.hms.hostel_managment_system.exceptions.ApiException;
import com.hms.hostel_managment_system.payload.JwtAuthRequest;
import com.hms.hostel_managment_system.payload.JwtAuthResponse;
import com.hms.hostel_managment_system.payload.UserDto;
import com.hms.hostel_managment_system.security.JwtTokenHelper;
import com.hms.hostel_managment_system.services.UserService;

@RestController
@RequestMapping("/api/v1/auth") 
public class AuthController {
	
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper mapper;
	
	

	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request)		
	{
		this.authenticate(request.getUsername(),request.getPassword());
	
		UserDetails userDetails=this.userDetailsService.loadUserByUsername(request.getUsername());
		
		String token=this.jwtTokenHelper.generateToken(userDetails);
		
		
		JwtAuthResponse response =new JwtAuthResponse();
		response.setToken(token);
		//this.mapper.map((User)userDetails, User.class);
		response.setUser(this.mapper.map((User)userDetails, UserDto.class));
		return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);
		
	}



	private void authenticate(String username, String password) {
		
		UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(username, password);
		
		try {
		this.authenticationManager.authenticate(authenticationToken);
		} catch(BadCredentialsException e)
		{
		  System.out.println("Invalid Details !1");
		  throw new ApiException("Invalid username or password !!");
		}
		
	
	}
	//register new user api
	
	@PostMapping("/register")
	public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto){
		
		UserDto registeredUser=this.userService.registerNewUser(userDto);
		return new ResponseEntity<UserDto>(registeredUser, HttpStatus.CREATED);
	}
	
}

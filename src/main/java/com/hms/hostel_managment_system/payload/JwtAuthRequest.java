package com.hms.hostel_managment_system.payload;

import lombok.Data;

@Data
public class JwtAuthRequest {
	
	private String username;
	
	private String password;
	
}

package com.hms.hostel_managment_system.payload;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private int id;
	
	@NotEmpty
    @Size(min=4, message="username must be of 4 characters !!")
	private String name;
	 
	@Email(message="Email address is not valid !!")
    @NotEmpty(message="Email is required!!")
	private String email;
	 
	 @NotEmpty
	 @Size(min=3, max=10, message="Password must be min of 3 chars and max of 10 chars !!") 
	private String password;
	 
	 @NotEmpty
	private String about;
	 
	 private Set<RoleDto> roles= new HashSet<>();

	 @JsonIgnore
	 public String getPassword() {
		 return this.password;
	 }
	 
	 @JsonProperty
	 public void setPassword(String password) {
		 
		 this.password=password;
	 }

}

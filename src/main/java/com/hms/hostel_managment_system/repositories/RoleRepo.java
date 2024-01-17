package com.hms.hostel_managment_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.hostel_managment_system.entities.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {
	

}

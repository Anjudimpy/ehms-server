package com.hms.hostel_managment_system.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hms.hostel_managment_system.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	Optional<User> findByEmail(String email);

}

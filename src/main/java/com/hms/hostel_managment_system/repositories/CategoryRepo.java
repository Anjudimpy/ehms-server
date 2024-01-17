package com.hms.hostel_managment_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.hostel_managment_system.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}

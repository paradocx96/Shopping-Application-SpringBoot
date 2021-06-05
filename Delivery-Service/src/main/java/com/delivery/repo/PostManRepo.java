package com.delivery.repo;

import com.delivery.model.PostMan;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostManRepo extends JpaRepository<PostMan, Long> {

	// Declare a function for get last order from database
	List<PostMan> findTopByOrderByIdDesc();
}

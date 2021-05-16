package com.delivery.repo;

import com.delivery.model.PostMan;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostManRepo extends JpaRepository<PostMan, Long> {
	
	List<PostMan> findTopByOrderByIdDesc();
}

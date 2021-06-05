package com.delivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.model.PostMan;
import com.delivery.repo.PostManRepo;

@Service
public class PostManService {
	
	// Declare a repository interface variable
	@Autowired
	PostManRepo postManRepo;

	// Implementation of add new Order to database
	public PostMan savePostMan(PostMan pm) {
		return postManRepo.save(pm);
	}
	
	// Implementation of get last Order data
	public List<PostMan> getLastOrder() {
		return postManRepo.findTopByOrderByIdDesc();
	}

}

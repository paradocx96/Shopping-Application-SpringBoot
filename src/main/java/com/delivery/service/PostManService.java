package com.delivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.model.PostMan;
import com.delivery.repo.PostManRepo;

@Service
public class PostManService {
	
	@Autowired
	PostManRepo postManRepo;

	public PostMan savePostMan(PostMan pm) {
		return postManRepo.save(pm);
	}
	
	public List<PostMan> getLastOrder() {
		return postManRepo.findTopByOrderByIdDesc();
	}

}

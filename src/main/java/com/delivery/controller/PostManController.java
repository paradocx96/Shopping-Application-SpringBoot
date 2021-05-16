package com.delivery.controller;

import com.delivery.model.PostMan;
import com.delivery.service.PostManService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
@RestController
@RequestMapping("/api/postman")
public class PostManController {

    @Autowired
    PostManService service;

    @PostMapping("/add")
    public PostMan createUpdatePostMan(@RequestBody PostMan pm) {
    	return service.savePostMan(pm);
    }

    @GetMapping("/last")
	public List<PostMan> getLastOrder() {
		return service.getLastOrder();
	}

}

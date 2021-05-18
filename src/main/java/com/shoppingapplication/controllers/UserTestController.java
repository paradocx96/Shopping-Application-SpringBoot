package com.shoppingapplication.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class UserTestController {
	
	@GetMapping("/all")
	public String allAccess() {
		return "Amarangi's part";
	}
	
	@GetMapping("/buyer")
	//@PreAuthorize("hasRole('BUYER')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/seller")
	//@PreAuthorize("hasRole('ROLE_SELLER')")
	public String adminAccess() {
		return "SELLER Board";
	}
}

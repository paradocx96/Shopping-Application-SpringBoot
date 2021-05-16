package com.delivery.controller;

import com.delivery.model.Address;
import com.delivery.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
@RestController
@RequestMapping("/api/address")
public class AddressController {

	@Autowired
	AddressService service;
	
	@PostMapping("/calculate")
	public double calculateDeliveryCost(@RequestBody Address address) {
		return service.calDeliveryCost(address);
	}

	@PostMapping("/add")
	public Address createUpdateAddress(@RequestBody Address address) {
		return service.saveAddress(address);
	}	

}

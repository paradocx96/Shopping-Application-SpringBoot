package com.delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.model.Address;
import com.delivery.repo.AddressRepo;

@Service
public class AddressService {
	
	@Autowired
	AddressRepo addressRepo;
	
	
	public Address saveAddress(Address address) {		
		return addressRepo.save(address);
	}

	
	public double calDeliveryCost(Address address) {
		String dist = address.getDistrict();
		double result = calculateDeliveryCharge(dist);
		return result;
	}
	
	
	public double calculateDeliveryCharge(String district) {
		
		double price = 100;
		
		if (district.equals("Ampara")) {
			return price + 350.00;
		} else if (district.equals("Anuradhapura")) {
			return price + 290.00;
		} else if (district.equals("Badulla")) {
			return price + 400.00;
		} else if (district.equals("Colombo")) {
			return price + 100.00;
		} else if (district.equals("Galle")) {
			return price + 200.00;
		} else if (district.equals("Gampaha")) {
			return price + 150.00;
		} else if (district.equals("Hambantota")) {
			return price + 250.00;
		} else if (district.equals("Jaffna")) {
			return price + 500.00;
		} else if (district.equals("Kalutara")) {
			return price + 180.00;
		} else if (district.equals("Kandy")) {
			return price + 220.00;
		} else if (district.equals("Kegalle")) {
			return price + 180.00;
		} else if (district.equals("Kilinochchi")) {
			return price + 420.00;
		} else if (district.equals("Kurunegala")) {
			return price + 210.00;
		} else if (district.equals("Mannar")) {
			return price + 450.00;
		} else if (district.equals("Matale")) {
			return price + 180.00;
		} else if (district.equals("Matara")) {
			return price + 280.00;
		} else if (district.equals("Moneragala")) {
			return price + 270.00;
		} else if (district.equals("Mullaitivu")) {
			return price + 470.00;
		} else if (district.equals("Nuwara Eliya")) {
			return price + 340.00;
		} else if (district.equals("Polonnaruwa")) {
			return price + 300.00;
		} else if (district.equals("Puttalam")) {
			return price + 410.00;
		} else if (district.equals("Ratnapura")) {
			return price + 210.00;
		} else if (district.equals("Trincomalee")) {
			return price + 340.00;
		} else if (district.equals("Vavuniya")) {
			return price + 390.00;
		} else {
			return price;
		}
		
	}

}

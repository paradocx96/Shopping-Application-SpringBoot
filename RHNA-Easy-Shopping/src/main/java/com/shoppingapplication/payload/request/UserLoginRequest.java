package com.shoppingapplication.payload.request;

import javax.validation.constraints.NotBlank;

//created for get frontEnd Login credentials
public class UserLoginRequest {
	
	@NotBlank
	private String username;

	@NotBlank
	private String password;
	
	public UserLoginRequest() {
		username = "";
		password = "";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

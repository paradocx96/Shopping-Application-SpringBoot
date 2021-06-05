package com.shoppingapplication.payload.response;

//Created for response to send messages
public class MessageResponse {
	
	private String message;
	
	public MessageResponse() {
		message = "";
	}

	public MessageResponse(String message) {
	    this.message = message;
	  }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

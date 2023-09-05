package com.springapp.vehicleservice.dto;

public class EmailRequestDTO {

	String emailId;

	public EmailRequestDTO() {
		super();
	}

	public EmailRequestDTO(String emailId) {
		super();
		this.emailId = emailId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}

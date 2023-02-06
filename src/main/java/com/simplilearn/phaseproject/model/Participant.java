package com.simplilearn.phaseproject.model;

public class Participant {
	
	// data properties of participant model
	private int partId;
	private int batchId;
	private String userName;
	private String phoneNumber;
	private String email;
	private String gender;
	
	
	// default constructor
	public Participant() {
		
	}


	// parameterized constructor
	public Participant(int partId, int batchId, String userName, String phoneNumber, String email, String gender) {
		super();
		this.partId = partId;
		this.batchId = batchId;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.gender = gender;
	}


	// getter & setter methods
	public int getPartId() {
		return partId;
	}


	public void setPartId(int partId) {
		this.partId = partId;
	}


	public int getBatchId() {
		return batchId;
	}


	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	// override to string
	@Override
	public String toString() {
		return "Participant [partId=" + partId + ", batchId=" + batchId + ", userName=" + userName + ", phoneNumber="
				+ phoneNumber + ", email=" + email + ", gender=" + gender + "]";
	}
	
	
	

}

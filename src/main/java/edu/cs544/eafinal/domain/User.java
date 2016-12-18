package edu.cs544.eafinal.domain;

public class User {
	private String id;
	private String firstName;
	private String lastName;
	private Address address;
	private UserCredential userCredential;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public UserCredential getUserCredential() {
		return userCredential;
	}
	public void setUserCredential(UserCredential userCredential) {
		this.userCredential = userCredential;
	}
	
}

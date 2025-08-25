package com.elsa.airlines;

public class Passenger {
	private String name;
	private String phoneNumber;
	private String email;
	private PassengerType passengerType;

	public Passenger() {
	}

	public Passenger(String name, String phoneNumber, String email, PassengerType passengerType) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.passengerType = passengerType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public PassengerType getPassengerType() {
		return passengerType;
	}

	public void setPassengerType(PassengerType passengerType) {
		this.passengerType = passengerType;
	}
}

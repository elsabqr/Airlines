package com.elsa.airlines;

public class Airline {
	private String name;
	private Flight[] flights;
	private int index = 0;

	public Airline(int flightCount) {
		this.flights = new Flight[flightCount];
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Flight[] getFlights() {
		return flights;
	}

	public void addFlight(Flight flight) {
		if(index>=this.flights.length) 
			return; 
		this.flights[index++] = flight;
	}
}

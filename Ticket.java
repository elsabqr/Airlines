package com.elsa.airlines;

public class Ticket {

	private Flight flight;
	private TravelClass travelClass;
	private double baggage;
	private Passenger passenger;
	private int seatNumber;
	private String password;
	private TicketStatus ticketStatus;

	public Ticket() {
	}
	

	public Ticket(Flight flight, TravelClass travelClass, double baggage, Passenger passenger, int seatNumber, String password, TicketStatus ticketStatus ) {
		super();
		this.flight = flight;
		this.travelClass = travelClass;
		this.baggage = baggage;
		this.passenger = passenger;
		this.seatNumber = seatNumber;
		this.password = password;
		this.ticketStatus=ticketStatus;
	}


	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public TravelClass getTravelClass() {
		return travelClass;
	}

	public void setTravelClass(TravelClass travelClass) {
		this.travelClass = travelClass;
	}

	public double getBaggage() {
		return baggage;
	}

	public void setBaggage(double baggage) {
		this.baggage = baggage;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public TicketStatus getTicketStatus() {
		return ticketStatus;
	}


	public void setTicketStatus(TicketStatus ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
}

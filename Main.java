package com.elsa.airlines;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;

public class Main {
	public static Airline[] airlines = new Airline[3];
	public static Ticket[] tickets = new Ticket[100];
	public static int ticketCount = 0;

	static {
		Airline turkishAirlines = new Airline(2);
		Airline emirates = new Airline(2);
		Airline qatarAirways = new Airline(2);
		airlines[0] = turkishAirlines;
		airlines[1] = emirates;
		airlines[2] = qatarAirways;

		turkishAirlines.setName("Turkish Airlines");
		turkishAirlines.addFlight(new Flight(1, "Prishtina International Airport", "Istanbul Airport",
				LocalDateTime.of(2023, 5, 13, 12, 45), LocalDateTime.of(2023, 5, 13, 16, 45), 23));
		turkishAirlines.addFlight(new Flight(5, "Istanbul Airport", "Prishtina International Airport",
				LocalDateTime.of(2023, 5, 18, 12, 45), LocalDateTime.of(2023, 5, 18, 16, 45), 6));

		emirates.setName("Emirates");
		Flight[] emiratesFlights = new Flight[2];
		emirates.addFlight(new Flight(2, "Prishtina International Airport", "Dubai Airport",
				LocalDateTime.of(2023, 6, 5, 12, 45), LocalDateTime.of(2023, 6, 5, 16, 45), 4));
		emirates.addFlight(new Flight(6, "Dubai Airport", "Prishtina International Airport",
				LocalDateTime.of(2023, 6, 18, 12, 45), LocalDateTime.of(2023, 6, 18, 16, 45), 6));

		qatarAirways.setName("Qatar Airways");
		Flight[] qatarAirwaysFlights = new Flight[2];
		qatarAirways.addFlight(new Flight(3, "Prishtina International Airport", "Doha Airport",
				LocalDateTime.of(2023, 4, 23, 12, 45), LocalDateTime.of(2023, 4, 23, 16, 45), 9));
		qatarAirways.addFlight(new Flight(7, "Doha Airport", "Prishtina International Airport",
				LocalDateTime.of(2023, 4, 29, 12, 45), LocalDateTime.of(2023, 4, 29, 16, 45), 9));
	}

	public static void main(String[] args) {
		System.out.println("--- Welcome To Elsa's Booking System ---\n");
		System.out.println("Our airlines: ");
		for (int i = 0; i < airlines.length; i++) {
			Airline airline = airlines[i];
			System.out.println("\n- " + airline.getName());
			System.out.println("Flights: ");
			for (int j = 0; j < airline.getFlights().length; j++) {
				Flight flight = airline.getFlights()[j];
				System.out.println("- #" + flight.getId() + " " + flight.getOrigin() + " - " + flight.getDestination()
						+ " " + flight.getAvailableSeats() + " " + flight.getDepartureTime() + " - "
						+ flight.getArrivalTime());
			}
		}
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("\nWhat do you want to do? (1.Book a Flight, 2.Cancel a Flight, 3.Exit ): ");
			int selectedOption = Integer.parseInt(scanner.nextLine());
			if (selectedOption == 1) {
				bookAFlight(scanner);
			} else if (selectedOption == 2) {
				cancelAFlight(scanner);
			} else if (selectedOption == 3) {
				break;
			}

		}
		scanner.close();
		System.out.println("Thank you! Have a nice day!");

	}

	public static void bookAFlight(Scanner scanner) {
		System.out.println("\nBook a flight: ");
		System.out.print("Name: ");
		String passengerName = scanner.nextLine();
		System.out.print("Phone Number: ");
		String passengerPhoneNumber = scanner.nextLine();
		System.out.print("Email: ");
		String passengerEmail = scanner.nextLine();
		System.out.print("Passenger Type (ADULT, CHILD, INFANT): ");
		PassengerType passengerType = PassengerType.valueOf(scanner.nextLine());
		Passenger passenger = new Passenger(passengerName, passengerPhoneNumber, passengerEmail, passengerType);
		System.out.print("Flight: ");
		int flightId = Integer.parseInt(scanner.nextLine());
		System.out.print("Travel Class (FIRST_CLASS, BUSSINES_CLASS, ECONOMY_CLASS): ");
		TravelClass travelClass = TravelClass.valueOf(scanner.nextLine());
		System.out.print("Baggage: ");
		double baggage = Double.parseDouble(scanner.nextLine());
		System.out.print("Seat Number: ");
		int seatNumber = Integer.parseInt(scanner.nextLine());
		String password = UUID.randomUUID().toString();
		Ticket ticket = new Ticket(findFlight(flightId), travelClass, baggage, passenger, seatNumber, password,
				TicketStatus.ACTIVE);
		tickets[ticketCount] = ticket;
		ticketCount++;
		System.out.println("Ticket created successfully");
		System.out.println("Your temporary password is this: " + password);

	}

	public static Flight findFlight(int id) {
		for (int i = 0; i < airlines.length; i++) {
			Airline airline = airlines[i];
			for (int j = 0; j < airline.getFlights().length; j++) {
				Flight flight = airline.getFlights()[j];
				if (flight.getId() == id) {
					return flight;
				}

			}
		}
		throw new RuntimeException("Flight not found"); //duhet me hjek , bohet veq kur ndodh diqka e papritur
	}

	public static void cancelAFlight(Scanner scanner) {
		System.out.print("Enter Ticket password: ");
		String ticketPassword = scanner.nextLine();
		Ticket ticket = findTicket(ticketPassword);
		ticket.setTicketStatus(TicketStatus.CANCELLED);
		System.out.println("Ticket was cancelled successfully");
	}

	public static Ticket findTicket(String password) {
		for (int i = 0; i < ticketCount; i++) {
			if (tickets[i].getPassword().equals(password)) {
				return tickets[i];
			}
		}
		throw new RuntimeException("Ticket not found"); 
	}

}
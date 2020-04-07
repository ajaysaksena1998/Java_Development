package com.Ajay.flightCheckin.Integration.DTO;

import java.sql.Timestamp;
import java.util.Date;

public class Flights{

	private long id;
	
	private String flightNumber;
	
	private String operatingAirlines;
	
	private String departureCity;

	private String arrival_city;
	
	private Date date_of_departure;
	
	private Timestamp estimated_departure_time;
	
	public Flights() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Flights(long id, String flightNumber, String operatingAirlines, String departureCity, String arrival_city,
			Date date_of_departure, Timestamp estimated_departure_time) {
		super();
		this.id = id;
		this.flightNumber = flightNumber;
		this.operatingAirlines = operatingAirlines;
		this.departureCity = departureCity;
		this.arrival_city = arrival_city;
		this.date_of_departure = date_of_departure;
		this.estimated_departure_time = estimated_departure_time;
	}

	@Override
	public String toString() {
		return "Flights [id=" + id + ", flightNumber=" + flightNumber + ", operatingAirlines=" + operatingAirlines
				+ ", departureCity=" + departureCity + ", arrival_city=" + arrival_city + ", date_of_departure="
				+ date_of_departure + ", estimated_departure_time=" + estimated_departure_time + "]";
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getOperatingAirlines() {
		return operatingAirlines;
	}

	public void setOperatingAirlines(String operatingAirlines) {
		this.operatingAirlines = operatingAirlines;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrival_city() {
		return arrival_city;
	}

	public void setArrival_city(String arrival_city) {
		this.arrival_city = arrival_city;
	}

	public Date getDate_of_departure() {
		return date_of_departure;
	}

	public void setDate_of_departure(Date date_of_departure) {
		this.date_of_departure = date_of_departure;
	}

	public Timestamp getEstimated_departure_time() {
		return estimated_departure_time;
	}

	public void setEstimated_departure_time(Timestamp estimated_departure_time) {
		this.estimated_departure_time = estimated_departure_time;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}

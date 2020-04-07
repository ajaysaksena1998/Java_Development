package com.Ajay.flightReservation.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservations extends SuperClass {

	@Column(name = "CHECKED_IN")
	private Boolean checkedIn;

	@Column(name = "NUMBER_OF_BAGS")
	private int number_of_bags;

	@OneToOne
	private Passengers passenger;

	@OneToOne
	private Flights flight;

	public Reservations() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Boolean getCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(Boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	public int getNumber_of_bags() {
		return number_of_bags;
	}

	public void setNumber_of_bags(int number_of_bags) {
		this.number_of_bags = number_of_bags;
	}

	@Override
	public String toString() {
		return "Reservations [checkedIn=" + checkedIn + ", number_of_bags=" + number_of_bags + ", passenger="
				+ passenger + ", flight=" + flight + "]";
	}

	public Reservations(Boolean checkedIn, int number_of_bags, Passengers passenger, Flights flight) {
		super();
		this.checkedIn = checkedIn;
		this.number_of_bags = number_of_bags;
		this.passenger = passenger;
		this.flight = flight;
	}

	public Passengers getPassenger() {
		return passenger;
	}

	public void setPassenger(Passengers passenger) {
		this.passenger = passenger;
	}

	public Flights getFlight() {
		return flight;
	}

	public void setFlight(Flights flight) {
		this.flight = flight;
	}

}

package com.Ajay.flightCheckin.Integration.DTO;

public class Reservations{
	
	private long id;

	private Boolean checkedIn;

	private int number_of_bags;

	private Passengers passenger;

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

	public Reservations(long id, Boolean checkedIn, int number_of_bags, Passengers passenger, Flights flight) {
		super();
		this.setId(id);
		this.checkedIn = checkedIn;
		this.number_of_bags = number_of_bags;
		this.passenger = passenger;
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "Reservations [id=" + getId() + ", checkedIn=" + checkedIn + ", number_of_bags=" + number_of_bags
				+ ", passenger=" + passenger + ", flight=" + flight + "]";
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}

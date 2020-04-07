package com.Ajay.flightCheckin.Integration.DTO;

public class ReservationUpdateRequest {

	private long id;
	private Boolean checkedIn;
	private int number_of_bags;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "ReservationUpdateRequest [id=" + id + ", checkedIn=" + checkedIn + ", number_of_bags=" + number_of_bags
				+ "]";
	}
	public ReservationUpdateRequest(long id, Boolean checkedIn, int number_of_bags) {
		super();
		this.id = id;
		this.checkedIn = checkedIn;
		this.number_of_bags = number_of_bags;
	}
	public ReservationUpdateRequest() {
		// TODO Auto-generated constructor stub
	}
	public void setNumber_of_bags(int number_of_bags) {
		this.number_of_bags = number_of_bags;
	}
	
}

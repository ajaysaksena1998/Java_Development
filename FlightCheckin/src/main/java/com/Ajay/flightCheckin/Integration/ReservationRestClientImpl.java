package com.Ajay.flightCheckin.Integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.Ajay.flightCheckin.Integration.DTO.ReservationUpdateRequest;
import com.Ajay.flightCheckin.Integration.DTO.Reservations;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {

	private static final String RESERVATION_REST_URL = "http://localhost:8067/FlightRegistration/reservations/";

	@Override
	public Reservations findReservation(Long id) {

		RestTemplate restTemplate = new RestTemplate();
		Reservations reservation = restTemplate.getForObject(RESERVATION_REST_URL + id, Reservations.class);
		return reservation;
	}

	@Override
	public Reservations updateReservation(ReservationUpdateRequest request) {
		RestTemplate restTemplate = new RestTemplate();
		Reservations reservation = restTemplate.postForObject(RESERVATION_REST_URL, request, Reservations.class);
		return reservation;
	}

}

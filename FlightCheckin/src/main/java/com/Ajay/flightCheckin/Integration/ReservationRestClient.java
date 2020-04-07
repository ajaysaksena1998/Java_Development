package com.Ajay.flightCheckin.Integration;

import com.Ajay.flightCheckin.Integration.DTO.ReservationUpdateRequest;
import com.Ajay.flightCheckin.Integration.DTO.Reservations;

public interface ReservationRestClient {

	public Reservations findReservation(Long id);

	public Reservations updateReservation(ReservationUpdateRequest request);
}

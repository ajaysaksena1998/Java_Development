package com.Ajay.flightReservation.services;

import com.Ajay.flightReservation.DTO.ReservationRequest;
import com.Ajay.flightReservation.models.Reservations;

public interface ReservationService {

	public Reservations bookFlight(ReservationRequest request);
}

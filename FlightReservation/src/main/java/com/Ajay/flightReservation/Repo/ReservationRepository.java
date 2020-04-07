package com.Ajay.flightReservation.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Ajay.flightReservation.models.Reservations;

public interface ReservationRepository extends JpaRepository<Reservations, Long> {

}

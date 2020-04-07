package com.Ajay.flightReservation.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Ajay.flightReservation.models.Passengers;

public interface PassengerRepository extends JpaRepository<Passengers, Long> {

}

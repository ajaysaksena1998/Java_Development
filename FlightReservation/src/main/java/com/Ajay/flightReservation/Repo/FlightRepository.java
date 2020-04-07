package com.Ajay.flightReservation.Repo;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.Ajay.flightReservation.models.Flights;

public interface FlightRepository extends JpaRepository<Flights, Long> {

	@Query("from Flights where departureCity=:departureCity and arrival_city=:arrival_city and date_of_departure=:date_of_departure")
	List<Flights> findFlights(@Param("departureCity") String from, @Param("arrival_city") String to,
			@Param("date_of_departure") Date departureDate);

}

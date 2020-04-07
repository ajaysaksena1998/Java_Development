package com.Ajay.flightReservation.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Ajay.flightReservation.DTO.ReservationUpdateRequest;
import com.Ajay.flightReservation.Repo.ReservationRepository;
import com.Ajay.flightReservation.models.Reservations;

@RestController
@CrossOrigin
public class ReservationRestController {

	@Autowired
	ReservationRepository reservationRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);
	
	@RequestMapping("/reservations/{id}")
	public Reservations getReservation(@PathVariable("id") long id) {
		LOGGER.info("Rest API called");
		LOGGER.info("Inside getReservation() for Id "+id);
		Reservations reserve = reservationRepository.findById(id).get();
		return reserve;
	}
	
	@RequestMapping("/reservations")
	public Reservations updateReservation(@RequestBody ReservationUpdateRequest request) {
		
		LOGGER.info("Inside updateReservation() for "+request);
		Reservations reserve = reservationRepository.findById(request.getId()).get();
		reserve.setCheckedIn(request.getCheckedIn());
		reserve.setNumber_of_bags(request.getNumber_of_bags());
		reservationRepository.save(reserve);
		return reserve;
	}
}

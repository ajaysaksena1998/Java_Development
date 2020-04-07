package com.Ajay.flightReservation.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.Ajay.flightReservation.DTO.ReservationRequest;
import com.Ajay.flightReservation.Repo.FlightRepository;
import com.Ajay.flightReservation.models.Flights;
import com.Ajay.flightReservation.models.Reservations;
import com.Ajay.flightReservation.services.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	FlightRepository flightRepo;
	
	@Autowired
	ReservationService reservationService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		LOGGER.info("Inside showCompleteReservation() method");
		Flights flight = flightRepo.findById(flightId).get();
		modelMap.addAttribute("flight", flight);
		LOGGER.info("Booking Reservation for the flight "+flight);
		return "showReservation";
	}
	
	@RequestMapping(value= "/completeReservation", method = RequestMethod.POST)
	public String completeReservation(ReservationRequest reservation, ModelMap modelMap) {
		LOGGER.info("Inside completeReservation() method");
		Reservations reserve = reservationService.bookFlight(reservation);
		modelMap.addAttribute("msg","Reservation created successfully at Id "+reserve.getId());
		LOGGER.info("Reservation successfully confirmed at ID "+reserve.getId());
		return "reservationConfirmation";
	}
}

package com.Ajay.flightReservation.Controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.Ajay.flightReservation.Repo.FlightRepository;
import com.Ajay.flightReservation.models.Flights;

@Controller
public class FlightController {

	@Autowired
	FlightRepository flightRepo;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);
	
	@RequestMapping(value= "/findFlights", method = RequestMethod.POST)
	public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to, 
		@RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate,
		ModelMap modelMap) {
		LOGGER.info("Inside findFlights() method");
		List<Flights> flights = flightRepo.findFlights(from,to,departureDate);
		modelMap.addAttribute("flights",flights);
		LOGGER.info("Flights found are "+flights);
		return "displayFlights";
	}
	
	@RequestMapping("/admin/showAddFlight")
	public String showAddFlight() {
		return "addFlight";
	}
	
}

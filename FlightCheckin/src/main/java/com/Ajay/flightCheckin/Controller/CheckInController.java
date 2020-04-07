package com.Ajay.flightCheckin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Ajay.flightCheckin.Integration.ReservationRestClient;
import com.Ajay.flightCheckin.Integration.DTO.ReservationUpdateRequest;
import com.Ajay.flightCheckin.Integration.DTO.Reservations;

@Controller
public class CheckInController {

	@Autowired
	ReservationRestClient restClient;

	@RequestMapping("/showCheckIn")
	public String showStartCheckIn() {
		return "showStartCheckIn";
	}

	@RequestMapping("/startCheckIn")
	public String startCheckIn(@RequestParam("reservationId") Long reservationId, ModelMap modelMap) {
		Reservations reservation = restClient.findReservation(reservationId);
		modelMap.addAttribute("reservation", reservation);
		return "displayReservation";
	}

	@RequestMapping("/completeCheckIn")
	public String completeCheckIn(@RequestParam("reservationId") Long reservationId,
			@RequestParam("number_of_bags") int NumberOfBags) {
		ReservationUpdateRequest reservationUpdateRequest = new ReservationUpdateRequest();
		reservationUpdateRequest.setId(reservationId);
		reservationUpdateRequest.setCheckedIn(true);
		reservationUpdateRequest.setNumber_of_bags(NumberOfBags);
		restClient.updateReservation(reservationUpdateRequest);
		return "ConfirmCheckIn";
	}
}

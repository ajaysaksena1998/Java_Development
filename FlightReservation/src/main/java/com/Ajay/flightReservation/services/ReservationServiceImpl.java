package com.Ajay.flightReservation.services;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Ajay.flightReservation.DTO.ReservationRequest;
import com.Ajay.flightReservation.Repo.FlightRepository;
import com.Ajay.flightReservation.Repo.PassengerRepository;
import com.Ajay.flightReservation.Repo.ReservationRepository;
import com.Ajay.flightReservation.models.Flights;
import com.Ajay.flightReservation.models.Passengers;
import com.Ajay.flightReservation.models.Reservations;
import com.Ajay.flightReservation.util.EmailUtil;
import com.Ajay.flightReservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Value("${com.Ajay.flightReservation.ItinaryDirectory}")
	private String ITINARY_DIR;

	@Autowired
	FlightRepository flightRepo;

	@Autowired
	PassengerRepository passRepo;

	@Autowired
	ReservationRepository reservationRepo;

	@Autowired
	EmailUtil emailUtil;

	@Autowired
	PDFGenerator pdfGenerator;

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

	
	@Override
	@Transactional
	public Reservations bookFlight(ReservationRequest request) {

		LOGGER.info("Inside bookFlight() method");

		// Make Payment
		Long FlightId = request.getFlightId();
		LOGGER.info("Fetching the Flight with id " + FlightId);
		Flights flight = flightRepo.findById(FlightId).get();

		Passengers passenger = new Passengers();
		passenger.setFirstName(request.getFirstName());
		passenger.setLastName(request.getLastName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());

		LOGGER.info("Saving the passenger " + passenger);
		Passengers savedPassenger = passRepo.save(passenger);

		Reservations reservation = new Reservations();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);

		LOGGER.info("Saving the Reservation " + reservation);
		Reservations savedReservation = reservationRepo.save(reservation);

		String filepath = ITINARY_DIR + savedReservation.getId() + ".pdf";
		LOGGER.info("Generating the Flight Itinary Report");
		pdfGenerator.generateItinary(savedReservation, filepath);
		LOGGER.info("Emailing the Flight Itinary Report");
		emailUtil.SendItinary(passenger.getEmail(), filepath);

		return savedReservation;
	}
}

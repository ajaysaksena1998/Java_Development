package com.Ajay.flightReservation.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.Ajay.flightReservation.models.Reservations;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class PDFGenerator {

	private static Logger LOGGER = LoggerFactory.getLogger(PDFGenerator.class);
	
	public void generateItinary(Reservations reservation, String filepath) {

		LOGGER.info("Inside generateItinary() method");
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(filepath));
			document.open();
			document.add(generateTable(reservation));
			document.close();
		} catch (FileNotFoundException | DocumentException e) {
			LOGGER.error("Exception in generateItinary() method: "+e);
		}
	}

	private PdfPTable generateTable(Reservations reservation) {
		
		LOGGER.info("Inside generateTable() method");
		PdfPTable table = new PdfPTable(2);
		PdfPCell cell;
		cell = new PdfPCell(new Phrase("Flight Itinary"));
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Flight Details"));
		cell.setColspan(2);
		table.addCell(cell);

		table.addCell("Airlines");
		table.addCell(reservation.getFlight().getOperatingAirlines());

		table.addCell("Flight Number");
		table.addCell(reservation.getFlight().getFlightNumber());

		table.addCell("Departure City");
		table.addCell(reservation.getFlight().getDepartureCity());

		table.addCell("Arrival City");
		table.addCell(reservation.getFlight().getArrival_city());

		table.addCell("Date Of Departure");
		table.addCell(reservation.getFlight().getDate_of_departure().toString());

		table.addCell("Estimated Departure Time");
		table.addCell(reservation.getFlight().getEstimated_departure_time().toString());

		cell = new PdfPCell(new Phrase("Passenger Details"));
		cell.setColspan(2);
		table.addCell(cell);

		table.addCell("First Name");
		table.addCell(reservation.getPassenger().getFirstName());

		table.addCell("Last Name");
		table.addCell(reservation.getPassenger().getLastName());

		table.addCell("Email");
		table.addCell(reservation.getPassenger().getEmail());

		table.addCell("Contact Number");
		table.addCell(reservation.getPassenger().getPhone());

		return table;
	}

}

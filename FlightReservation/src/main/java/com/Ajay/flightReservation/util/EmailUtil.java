package com.Ajay.flightReservation.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

	@Value("${com.Ajay.flightReservation.Email.body}")
	private String EMAIL_TEXT;

	@Value("${com.Ajay.flightReservation.Email.subject}")
	private String EMAIL_SUBJECT;

	@Autowired
	JavaMailSender sender;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);
	
	public void SendItinary(String toAdress, String filepath) {
		
		LOGGER.info("Inside SendItinary() method");
		MimeMessage message = sender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(toAdress);
			helper.setSubject(EMAIL_SUBJECT);
			helper.setText(EMAIL_TEXT);
			helper.addAttachment("Itinary", new File(filepath));
			sender.send(message);
		} catch (MessagingException e) {
			LOGGER.error("Exception in sendItinary() method: "+e);
		}

	}
}

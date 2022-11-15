package com.addressBook.addressBook.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderService {

	@Autowired
	private JavaMailSender mailsender;
	
	public void sendEmail(String toEmail, String subject, String body ) {
	SimpleMailMessage message=new SimpleMailMessage();
	
	message.setFrom("nikhiljainsgrl283@gmail.com");
	message.setTo(toEmail);
	message.setText(body);
	message.setSubject(subject);
	mailsender.send(message);
	
	System.out.println("Mail sent to the User...!");
		
	}
}
package com.revature.banking_application.email;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import com.revature.banking_application.entities.BankCustomers;

@Component
public class EmailServiceImpl {
	private JavaMailSender mailSender;

	public EmailServiceImpl(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
 
	public void sendMessage(BankCustomers customer) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(customer.getEmail()));
				mimeMessage.setFrom("noreply@bankaccountapp.com");
				mimeMessage.setText("Thank you for applying to our Bank. \n Your username is " 
				+ customer.getUser().getUserID() + ". \n Your password is " 
				+ customer.getUser().getPassword() + ". \n Please login and change your password. \n Have a nice day");
				
			}
		};
		try {
			mailSender.send(preparator);
		}catch(MailException ex) {
			ex.printStackTrace();
		}
	}
}

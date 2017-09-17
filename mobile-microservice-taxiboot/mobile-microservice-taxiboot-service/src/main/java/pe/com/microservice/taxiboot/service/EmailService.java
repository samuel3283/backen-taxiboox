package pe.com.microservice.taxiboot.service;

import pe.com.microservice.taxiboot.model.Mail;

public interface EmailService {

	void sendMail(Mail mail) throws Exception;
	 
}

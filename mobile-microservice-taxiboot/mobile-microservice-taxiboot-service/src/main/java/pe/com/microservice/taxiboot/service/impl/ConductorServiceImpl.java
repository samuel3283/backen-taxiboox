package pe.com.microservice.taxiboot.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import pe.com.microservice.taxiboot.dao.ConductorRepository;
import pe.com.microservice.taxiboot.model.Conductor;
import pe.com.microservice.taxiboot.model.Mail;
import pe.com.microservice.taxiboot.service.ConductorService;
import pe.com.microservice.taxiboot.service.EmailService;

@Service
public class ConductorServiceImpl implements ConductorService {

	private final Logger logger = LoggerFactory
			.getLogger(ConductorServiceImpl.class);
	
	@Autowired
	private ConductorRepository conductorRepository;
	
	@Autowired 
	private EmailService emailService;
	
	@Override
	public 	void insertConductor(Conductor conductor) throws Exception {
		conductor.setEstado(new Integer(1));
		conductorRepository.insertConductor(conductor);		
		
		Mail mail = new Mail();
		mail.setTo(conductor.getEmail());
		mail.setSubject(conductor.getNombre()+", Bienvenido a TaxiBoox");		
		//mail.setCc("samuel3283@gmail.com");
		
		Map<String, Object> contents = new HashMap<>();
		contents.put("nombreOperacion", "Registro de Conductor");
		contents.put("nombreCliente", conductor.getNombre());
		
		mail.setContents(contents);
		try {
		logger.info("sendMmail");		
		emailService.sendMail(mail);
		} catch(Exception e) {
			logger.info("Error sendMail:::"+e.getMessage());
		}
	}
	
	@Override
	public 	void validaConductor(Conductor conductor) throws Exception {
		
		Conductor bean = conductorRepository.getConductor(conductor);
		
		if(bean==null)
			throw new Exception("Error not found");
		
		logger.info("getConductor:"+bean.toString());
		
	}

	@Override
	public	void deleteConductor(Conductor conductor) throws Exception {
		conductorRepository.deleteConductor(conductor);
	}

	@Override
	public	Conductor getConductor(Conductor conductor) throws Exception {
		return conductorRepository.getConductor(conductor);
	}
	
	@Override
	public	Conductor getConductorByPhone(Conductor conductor) throws Exception {
		return conductorRepository.getConductorByPhone(conductor);
	}
	
}

package pe.com.microservice.taxiboot.service.impl;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.microservice.taxiboot.dao.ConductorRepository;
import pe.com.microservice.taxiboot.dao.EquipoRepository;
import pe.com.microservice.taxiboot.model.Conductor;
import pe.com.microservice.taxiboot.model.Equipo;
import pe.com.microservice.taxiboot.service.EquipoService;
import pe.com.microservice.taxiboot.service.util.PeticionPost;
import pe.com.microservice.taxiboot.service.util.Util;

@Service
public class EquipoServiceImpl implements EquipoService {

	private final Logger logger = LoggerFactory
			.getLogger(EquipoServiceImpl.class);
	
	@Autowired
	private EquipoRepository equipoRepository;

	@Autowired
	private ConductorRepository conductorRepository;

	@Override
	public Equipo getEquipoxPhone(Equipo equipo)  throws Exception {

		return equipoRepository.getEquipoxPhone(equipo);
	}

	@Override
	public Conductor getConductorByPhone(Equipo equipo)  throws Exception {
		Conductor conductor = new Conductor();
		conductor.setTelefono(equipo.getTelefono());
		return conductorRepository.getConductorByPhone(conductor);
	}

	
	@Override
	public String ingresarEquipo(Equipo equipo)  throws Exception {

		int numeroAleatorio = (int) (Math.random()*999998+1);		
		String sms = Util.completar(numeroAleatorio);
		equipo.setSegExpira(120);
		equipo.setSms(sms);
		logger.info("ingresar:"+equipo.toString());
		Equipo bean = equipoRepository.getEquipo(equipo);
		
		if(bean==null) {
			logger.info("insertar:");
			equipoRepository.insertEquipo(equipo);
		} else {
			logger.info("update:"+bean.toString());
			equipoRepository.updateEquipo(equipo);
		}		
		//throw new Exception("Error not found");
		
		enviarSMS(equipo);
		return sms;
	}

	@Override
	public void validaEquipo(Equipo equipo)  throws Exception {

		Equipo bean = equipoRepository.getEquipoxSms(equipo);	
		
		if(bean==null)
			throw new Exception("Error not found");

		logger.info("Existe equipo con sms validado.");
		/*
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = format.parse(bean.getFecModifica()); // mysql datetime format		
		long ultimaConexion = date.getTime();

		long inactiveTimeout = 60;
		long now = System.currentTimeMillis();
		
		if ((now - ultimaConexion) >= inactiveTimeout) {			
			logger.info("Tiempo de validación de sms expiradao");			
			throw new Exception("Error validation sms expired");
		} 		
		*/
		equipoRepository.updateValidaEquipo(equipo);

	}

	@Override
	public String reenviarEquipo(Equipo equipo)  throws Exception {

		Equipo bean = equipoRepository.getEquipoxTelefono(equipo);	
		
		if(bean==null)
			throw new Exception("Error not found");
		
		int numeroAleatorio = (int) (Math.random()*999998+1);		
		String sms = Util.completar(numeroAleatorio);
		equipo.setSms(sms);
		
		equipoRepository.updateNewSmsEquipo(equipo);

		enviarSMS(equipo);

		return sms;
	}

	
	@Override
	public void insertEquipo(Equipo equipo)  throws Exception {
		equipoRepository.insertEquipo(equipo);
	}
	
	@Override
	public void deleteEquipo(Equipo equipo)  throws Exception {
		equipoRepository.deleteEquipo(equipo);
	}
	
	
	public void enviarSMS(Equipo equipo) throws Exception {
		 String sms = equipo.getSms();
		
		 String url ="http://servicio.smsmasivos.com.ar/enviar_sms_bloque.asp";
		 String user="SAMUEL3283";
		 String password="SAMUEL3283782";
		 
		 String identificador=sms;
		 String numero=equipo.getTelefono();
		 
		 String mensaje="Bienvenido a TaxiBoox ingresa con "+sms+"";
		 String bloque = "bloque=XXX,982571568,Su codigo generado es 654321.";
		 bloque = "bloque="+identificador+","+numero+","+mensaje;
		 PeticionPost post = new PeticionPost (url);
		 post.add("usuario", user);
		 post.add("clave", password);
		 post.add("bloque", bloque);
		 //post.add("destino", "982571568");
		 //post.add("texto", "El mensaje generado es 123456");
		 String respuesta = post.getRespueta();
		 logger.info("RESPUESTA ==> ENVIO:"+bloque+"==>RESPUESTA"+respuesta);

	}

}

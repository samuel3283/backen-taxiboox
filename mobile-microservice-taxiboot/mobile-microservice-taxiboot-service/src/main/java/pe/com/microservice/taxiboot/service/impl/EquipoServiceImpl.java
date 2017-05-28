package pe.com.microservice.taxiboot.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.microservice.taxiboot.dao.EquipoRepository;
import pe.com.microservice.taxiboot.model.Equipo;
import pe.com.microservice.taxiboot.service.EquipoService;

@Service
public class EquipoServiceImpl implements EquipoService {

	private final Logger logger = LoggerFactory
			.getLogger(EquipoServiceImpl.class);
	
	@Autowired
	private EquipoRepository equipoRepository;

	@Override
	public String ingresarEquipo(Equipo equipo)  throws Exception {

		int numeroAleatorio = (int) (Math.random()*999998+1);		
		String sms = completar(numeroAleatorio);
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
		return sms;
	}


	@Override
	public void validaEquipo(Equipo equipo)  throws Exception {
		logger.info("validaEquipo");	
		Equipo bean = equipoRepository.getEquipoxSms(equipo);	
		
		logger.info("validamos");	
		if(bean==null)
			throw new Exception("Error not found");

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = format.parse(bean.getFecModifica()); // mysql datetime format		
		long ultimaConexion = date.getTime();

		long inactiveTimeout = 60000;
		long now = System.currentTimeMillis();
		logger.info("==>now:"+now+"==>ultimaConexion:"+ultimaConexion+"==>inactiveTimeout:"+inactiveTimeout);			
		/*
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
		String sms = completar(numeroAleatorio);
		equipo.setSms(sms);
		
		equipoRepository.updateNewSmsEquipo(equipo);
		
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

	public String completar(int numero) {
		
		String valor = String.valueOf(numero);
		if(valor.length()==1)	valor = "00000".concat(valor);
		else if(valor.length()==2)	valor = "0000".concat(valor);
		else if(valor.length()==3)	valor = "000".concat(valor);
		else if(valor.length()==4)	valor = "00".concat(valor);
		else if(valor.length()==5)	valor = "0".concat(valor);
		return valor;
	}
	
}

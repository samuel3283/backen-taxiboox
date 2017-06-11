package pe.com.microservice.taxiboot.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.microservice.taxiboot.dao.ConductorRepository;
import pe.com.microservice.taxiboot.dao.SessionRepository;
import pe.com.microservice.taxiboot.model.Conductor;
import pe.com.microservice.taxiboot.model.Equipo;
import pe.com.microservice.taxiboot.model.Session;
import pe.com.microservice.taxiboot.service.SessionService;
import pe.com.microservice.taxiboot.service.util.StringEncrypt;
import pe.com.microservice.taxiboot.service.util.Util;

@Service
public class SessionServiceImpl implements SessionService {

	private final Logger logger = LoggerFactory
			.getLogger(SessionServiceImpl.class);
	
	@Autowired
	private ConductorRepository conductorRepository;

	@Autowired
	private SessionRepository sessionRepository;
	
	@Override
	public Session validaSession(Conductor conductor) throws Exception {
		
		conductor.setEstado(new Integer(1));
		Conductor bean = conductorRepository.getConductor(conductor);
		
		if(bean==null)
			throw new Exception("Error Conductor not found");
				
		Session session = convertConductorToSession(bean);		
		sessionRepository.insertSession(session);
		
		Session cuenta = sessionRepository.getSessionByToken(session);
		if(cuenta==null)
			throw new Exception("Error Cuenta not found");
		
		logger.info("geSession:"+cuenta.toString());
		
		return cuenta;
	}
	
	
	@Override
	public Session getSessionByToken(String token) throws Exception {
		Session session = new Session();
		session.setToken(token);
		logger.info("getSessionByToken.."+token);
		Session bean = sessionRepository.getSessionByToken(session);
		if(bean==null)
			throw new Exception("Error Session not found");
		
		return bean;
	}
	
	@Override
	public void deleteSession(String token) throws Exception {		
		
		Session session = new Session();
		session.setToken(token);
		logger.info("getSessionByToken.."+token);
		/*
		Session bean = sessionRepository.getSessionByToken(session);
		if(bean==null)
			throw new Exception("Error Session not found");
		*/
		sessionRepository.deleteSession(session);
	}
	
	public Session convertConductorToSession(Conductor bean) throws Exception {
		
		java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
        String fechaHora = sdf.format(dt);
        
		String cadena = bean.getTelefono().concat("-").concat(bean.getNumDoc()).concat("-").concat(fechaHora);
		String token = StringEncrypt.encrypt(cadena);
		
		Session session = new Session();
		session.setDevice(bean.getDevice());
		session.setDeviceType(bean.getDeviceType());
		session.setNombre(bean.getNombre());
		session.setApellido(bean.getApellido());
		session.setEmail(bean.getEmail()); 
		session.setTipoDoc(bean.getTipoDoc());
		session.setNumDoc(bean.getNumDoc());
		session.setPais(bean.getPais());
		session.setTelefono(bean.getTelefono());
		session.setEstado(bean.getEstado());
		session.setToken(token);
		session.setEstadoAtencion(bean.getEstadoAtencion());
		session.setEstadoViaje(bean.getEstadoViaje());
		
		//if(session.getEstadoAtencion().equals("O"))
		//session.setEstadoViaje(bean.getEstadoViaje());
		
		return session;
	}
	
	@Override
	public void updEstViajeSession(Session session) throws Exception {		
		
		logger.info("updEstViajeSession.."+session.getToken());
		sessionRepository.updateEstadoViajeSession(session);

		Session bean = sessionRepository.getSessionByToken(session);
		if(bean==null)
			throw new Exception("Error Session not found");
		
		Conductor conductor = new Conductor();
		conductor.setEmail(bean.getEmail());
		conductor.setEstadoViaje(session.getEstadoViaje());
		conductorRepository.updEstViajeConductor(conductor);
	

	}

	@Override
	public void updateDatosSession(Session session) throws Exception {		
		
		logger.info("updateDatosSession.."+session.getToken());
		
		Session bean = sessionRepository.getSessionByToken(session);
		if(bean==null)
			throw new Exception("Error Session not found");
		
		logger.info("obtenido session:::"+bean.toString());			        

		Conductor conductor = new Conductor();
		conductor.setEmail(session.getEmail());
		conductor.setNombre(session.getNombre());
		conductor.setApellido(session.getApellido());
		String email = bean.getEmail();
		
		conductorRepository.upddateConductor(conductor, email);
	
		logger.info("obtenido request:::"+session.toString());			        
		sessionRepository.updateDatosSession(session);

	}

	
	@Override
	public String generaCodeEmail(Conductor conductor)  throws Exception {
		
		int numeroAleatorio = (int) (Math.random()*999998+1);		
		String sms = Util.completar(numeroAleatorio);
		
		//Enviar Email a conductor==>sendMail()
		
		conductorRepository.upddateOlvidoConductor(conductor, sms);
		
		return sms;
	}

	@Override
	public void validaCodeEmail(Conductor conductor)  throws Exception {
		
		if(conductor.getEmail()==null){
			throw new Exception("Error not found");
		}
		
		List<Conductor> lista = conductorRepository.validaCodeEmail(conductor);
		
    	if(lista==null || lista.size() <=0)
    		throw new Exception("Error not found");

	}

	
	@Override
	public void upddateClaveConductor(Conductor conductor)  throws Exception {
	
		if(conductor.getEmail()==null || conductor.getEmail().isEmpty())
			throw new Exception("Error datos invallidos");
		
		if(conductor.getPassword()==null || conductor.getPassword().isEmpty() || conductor.getPassword().length()<4)
			throw new Exception("Error datos invallidos");

		Conductor beanConductor = conductorRepository.getConductorByEmail(conductor);
		
		if(beanConductor==null)
			throw new Exception("Error not found");
		
		conductorRepository.upddateClaveConductor(conductor);
		
	}

}

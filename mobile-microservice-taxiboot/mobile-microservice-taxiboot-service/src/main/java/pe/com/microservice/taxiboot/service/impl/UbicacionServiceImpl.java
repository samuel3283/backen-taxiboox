package pe.com.microservice.taxiboot.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.microservice.taxiboot.dao.ConductorRepository;
import pe.com.microservice.taxiboot.dao.SessionRepository;
import pe.com.microservice.taxiboot.dao.UbicacionRepository;
import pe.com.microservice.taxiboot.model.Conductor;
import pe.com.microservice.taxiboot.model.Session;
import pe.com.microservice.taxiboot.model.Ubicacion;
import pe.com.microservice.taxiboot.service.ConductorService;
import pe.com.microservice.taxiboot.service.UbicacionService;

@Service
public class UbicacionServiceImpl implements UbicacionService {

	private final Logger logger = LoggerFactory
			.getLogger(UbicacionServiceImpl.class);
	
	@Autowired
	private UbicacionRepository ubicacionRepository;

	@Autowired
	private SessionRepository sessionRepository;

	@Autowired
	private ConductorRepository conductorRepository;

	@Override
	public void insertUbicacion(Ubicacion ubicacion,Session session) throws Exception {

		Session bean = sessionRepository.getSessionByToken(session);
		if(bean==null)
			throw new Exception("Error Session not found");
		
		logger.info("obtenido session:::"+bean.toString());			   
		
		Conductor conductor =  new Conductor();
		conductor.setEmail(bean.getEmail());
		Conductor beanConductor = conductorRepository.getConductorByEmail(conductor);
		
		ubicacion.setCodigoConductor(beanConductor.getCodigo());
		logger.info("obtenido ubicacion:::"+ubicacion.toString());			   
		ubicacionRepository.insertUbicacion(ubicacion);
	}
	

}

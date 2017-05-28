package pe.com.microservice.taxiboot.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.microservice.taxiboot.dao.ConductorRepository;
import pe.com.microservice.taxiboot.model.Conductor;
import pe.com.microservice.taxiboot.service.ConductorService;

@Service
public class ConductorServiceImpl implements ConductorService {

	private final Logger logger = LoggerFactory
			.getLogger(ConductorServiceImpl.class);
	
	@Autowired
	private ConductorRepository conductorRepository;

	@Override
	public 	void insertConductor(Conductor conductor) throws Exception {
		conductor.setEstado(new Integer(1));
		conductorRepository.insertConductor(conductor);
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

	
}

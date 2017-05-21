package pe.com.microservice.taxiboot.service;

import pe.com.microservice.taxiboot.model.Conductor;

public interface ConductorService {

	void insertConductor(Conductor conductor) throws Exception;
	void validaConductor(Conductor conductor) throws Exception;

}

package pe.com.microservice.taxiboot.service;

import pe.com.microservice.taxiboot.model.Conductor;

public interface ConductorService {

	void insertConductor(Conductor conductor) throws Exception;
	void validaConductor(Conductor conductor) throws Exception;
	void deleteConductor(Conductor conductor) throws Exception;
	Conductor getConductor(Conductor conductor) throws Exception;
	Conductor getConductorByPhone(Conductor conductor) throws Exception;
	 
}

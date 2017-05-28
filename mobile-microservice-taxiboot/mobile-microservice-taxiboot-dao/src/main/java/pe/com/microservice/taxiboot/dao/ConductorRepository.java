package pe.com.microservice.taxiboot.dao;

import pe.com.microservice.taxiboot.model.Conductor;
import pe.com.microservice.taxiboot.model.Equipo;

public interface ConductorRepository {

	void insertConductor(Conductor conductor) throws Exception;
	Conductor getConductor(Conductor conductor) throws Exception;
	void deleteConductor(Conductor conductor) throws Exception;
	
}

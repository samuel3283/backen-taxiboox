package pe.com.microservice.taxiboot.dao;

import java.util.List;

import pe.com.microservice.taxiboot.model.Conductor;
import pe.com.microservice.taxiboot.model.Equipo;

public interface ConductorRepository {

	void insertConductor(Conductor conductor) throws Exception;
	Conductor getConductor(Conductor conductor) throws Exception;
	void deleteConductor(Conductor conductor) throws Exception;
	void updEstAtencionConductor(Conductor conductor) throws Exception;
	void updEstViajeConductor(Conductor conductor) throws Exception;
	void upddateConductor(Conductor conductor, String email) throws Exception;
	Conductor getConductorByEmail(Conductor conductor) throws Exception;
	Conductor getConductorByPhone(Conductor conductor) throws Exception;
	void upddateOlvidoConductor(Conductor conductor, String sms) throws Exception;
	public List <Conductor> validaCodeEmail(Conductor conductor)  throws Exception;
	public void upddateClaveConductor(Conductor conductor) throws Exception;
	
}

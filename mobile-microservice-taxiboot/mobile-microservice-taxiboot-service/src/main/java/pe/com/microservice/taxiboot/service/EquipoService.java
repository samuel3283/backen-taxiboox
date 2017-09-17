package pe.com.microservice.taxiboot.service;

import pe.com.microservice.taxiboot.model.Conductor;
import pe.com.microservice.taxiboot.model.Equipo;

public interface EquipoService {
	
	Equipo getEquipoxPhone(Equipo equipo)  throws Exception;
	String ingresarEquipo(Equipo equipo)  throws Exception;
	void validaEquipo(Equipo equipo)  throws Exception;
	void insertEquipo(Equipo equipo)  throws Exception;
	void deleteEquipo(Equipo equipo)  throws Exception;
	String reenviarEquipo(Equipo equipo)  throws Exception;
	Conductor getConductorByPhone(Equipo equipo)  throws Exception;
	 
}

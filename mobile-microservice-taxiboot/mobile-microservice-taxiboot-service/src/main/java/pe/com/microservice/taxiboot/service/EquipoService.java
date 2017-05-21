package pe.com.microservice.taxiboot.service;

import pe.com.microservice.taxiboot.model.Equipo;

public interface EquipoService {

	String ingresarEquipo(Equipo equipo)  throws Exception;
	void validaEquipo(Equipo equipo)  throws Exception;
	void insertEquipo(Equipo equipo)  throws Exception;
	String reenviarEquipo(Equipo equipo)  throws Exception;
	
}

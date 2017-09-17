package pe.com.microservice.taxiboot.dao;

import pe.com.microservice.taxiboot.model.Equipo;

public interface EquipoRepository {

	void insertEquipo(Equipo equipo) throws Exception;
	void updateEquipo(Equipo equipo) throws Exception;
	Equipo getEquipo(Equipo equipo) throws Exception;
	Equipo getEquipoxSms(Equipo equipo) throws Exception;
	Equipo getEquipoxTelefono(Equipo equipo) throws Exception;
	Equipo getEquipoxPhone(Equipo equipo) throws Exception;
	void updateValidaEquipo(Equipo equipo) throws Exception;
	void updateNewSmsEquipo(Equipo equipo) throws Exception;
	void deleteEquipo(Equipo equipo) throws Exception;
	
}

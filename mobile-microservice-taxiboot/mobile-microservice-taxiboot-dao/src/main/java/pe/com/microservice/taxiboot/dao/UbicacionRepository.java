package pe.com.microservice.taxiboot.dao;

import pe.com.microservice.taxiboot.model.Ubicacion;

public interface UbicacionRepository {

	void insertUbicacion(Ubicacion ubicacion) throws Exception;
	
}

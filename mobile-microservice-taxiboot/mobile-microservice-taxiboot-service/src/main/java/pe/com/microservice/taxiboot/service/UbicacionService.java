package pe.com.microservice.taxiboot.service;

import pe.com.microservice.taxiboot.model.Session;
import pe.com.microservice.taxiboot.model.Ubicacion;

public interface UbicacionService {

	void insertUbicacion(Ubicacion ubicacion, Session session) throws Exception;

}

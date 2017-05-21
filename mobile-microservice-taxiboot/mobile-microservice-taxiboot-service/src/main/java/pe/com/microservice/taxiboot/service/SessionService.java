package pe.com.microservice.taxiboot.service;

import pe.com.microservice.taxiboot.model.Conductor;
import pe.com.microservice.taxiboot.model.Session;

public interface SessionService {

	Session validaSession(Conductor conductor) throws Exception;
	Session getSessionByToken(String token) throws Exception;
	void deleteSession(String token) throws Exception;
	
}

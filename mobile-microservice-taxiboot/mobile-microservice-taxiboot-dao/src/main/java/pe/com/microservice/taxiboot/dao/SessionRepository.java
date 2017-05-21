package pe.com.microservice.taxiboot.dao;

import pe.com.microservice.taxiboot.model.Session;

public interface SessionRepository {

	void insertSession(Session session) throws Exception;
	Session getSessionByToken(Session session) throws Exception;
	void deleteSession(Session session) throws Exception;
	
}

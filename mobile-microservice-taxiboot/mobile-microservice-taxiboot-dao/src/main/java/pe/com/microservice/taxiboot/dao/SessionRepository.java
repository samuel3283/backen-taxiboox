package pe.com.microservice.taxiboot.dao;

import pe.com.microservice.taxiboot.model.Session;

public interface SessionRepository {

	void insertSession(Session session) throws Exception;
	Session getSessionByToken(Session session) throws Exception;
	void deleteSession(Session session) throws Exception;
	void updateEstadoAtencionSession(Session session) throws Exception;
	void updateEstadoViajeSession(Session session) throws Exception;
	void updateDatosSession(Session session) throws Exception;
	void deleteSessionByEmail(Session session) throws Exception;
	void deleteSessionOtherById(Session session) throws Exception;
	
}

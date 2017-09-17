package pe.com.microservice.taxiboot.dao;

import java.util.List;

import pe.com.microservice.taxiboot.model.Conductor;
import pe.com.microservice.taxiboot.model.Equipo;
import pe.com.microservice.taxiboot.model.Parametro;
import pe.com.microservice.taxiboot.model.Servicio;

public interface ParametroRepository {

	List<Parametro> listParametro(String tipo) throws Exception;
	Parametro getParametro(String tipo) throws Exception;

}

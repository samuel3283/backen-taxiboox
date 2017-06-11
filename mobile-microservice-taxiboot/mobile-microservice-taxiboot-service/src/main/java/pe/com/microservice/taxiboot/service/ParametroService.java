package pe.com.microservice.taxiboot.service;

import java.util.List;

import pe.com.microservice.taxiboot.model.Parametro;

public interface ParametroService {

	public List<Parametro> listParametro(String tipo) throws Exception;
	 
	
}

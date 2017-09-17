package pe.com.microservice.taxiboot.service;

import java.util.List;
import java.util.Map;

import pe.com.microservice.taxiboot.model.Parametro;

public interface ParametroService {

	List<Parametro> listParametro(String tipo) throws Exception;
	Map<String, List<Parametro>> listAll() throws Exception;
	
}

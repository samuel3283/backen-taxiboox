package pe.com.microservice.taxiboot.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.microservice.taxiboot.dao.ParametroRepository;
import pe.com.microservice.taxiboot.model.Parametro;
import pe.com.microservice.taxiboot.service.ParametroService;

@Service
public class ParametroServiceImpl implements ParametroService {

	private final Logger logger = LoggerFactory
			.getLogger(ParametroServiceImpl.class);
	
	@Autowired
	private ParametroRepository parametroRepository;
	
	@Override
	public List<Parametro> listParametro(String tipo) throws Exception {
		
		return parametroRepository.listParametro(tipo);
	}

	public Map<String, List<Parametro>> listAll() throws Exception {
		
		Map<String, List<Parametro>> map = new HashMap<String, List<Parametro>>();
		
		List<Parametro> listaEConductor = new ArrayList<Parametro>();
		listaEConductor.addAll(listParametro("ESTCONDUCTOR"));
		
		List<Parametro> listaEServicio= new ArrayList<Parametro>();
		listaEServicio.addAll(listParametro("ESTSERVICIO"));

		List<Parametro> listaValServicio= new ArrayList<Parametro>();
		listaValServicio.addAll(listParametro("VALSERVICIO"));

		map.put("EstadoConductor", listaEConductor);
		map.put("EstadoServicio", listaEServicio);
		map.put("ValoracionServicio", listaValServicio);
		
		return map;
	}
}

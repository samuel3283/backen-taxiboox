package pe.com.microservice.taxiboot.service.impl;

import java.util.List;

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
	
}

package pe.com.microservice.taxiboot.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.microservice.taxiboot.dao.ServicioRepository;
import pe.com.microservice.taxiboot.model.Paginado;
import pe.com.microservice.taxiboot.model.Servicio;
import pe.com.microservice.taxiboot.service.ServicioService;

@Service
public class ServicioServiceImpl implements ServicioService {

	private final Logger logger = LoggerFactory
			.getLogger(ServicioServiceImpl.class);
	
	@Autowired
	private ServicioRepository servicioRepository;
	
	@Override
	public 	Servicio getServicio(Servicio servicio) throws Exception {
		
		return servicioRepository.getServicio(servicio);
	}
	
	@Override
	public List<Servicio> listServicio(Servicio servicio) throws Exception {
		
		return servicioRepository.listServicio(servicio);
	}

	@Override
	public List<Servicio> listServicio(Paginado paginado) throws Exception {
		
		return servicioRepository.listServicioPaginado(paginado);
	}

}

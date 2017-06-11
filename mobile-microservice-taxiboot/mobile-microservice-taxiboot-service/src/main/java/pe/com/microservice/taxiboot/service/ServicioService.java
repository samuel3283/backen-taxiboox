package pe.com.microservice.taxiboot.service;

import java.util.List;

import pe.com.microservice.taxiboot.model.Paginado;
import pe.com.microservice.taxiboot.model.Servicio;

public interface ServicioService {

	Servicio getServicio(Servicio servicio) throws Exception;
	List<Servicio> listServicio(Servicio servicio) throws Exception ;
	List<Servicio> listServicio(Paginado paginado) throws Exception;	 
	
}

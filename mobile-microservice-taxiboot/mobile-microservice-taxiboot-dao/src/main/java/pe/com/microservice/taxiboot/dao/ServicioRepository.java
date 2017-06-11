package pe.com.microservice.taxiboot.dao;

import java.util.List;

import pe.com.microservice.taxiboot.model.Conductor;
import pe.com.microservice.taxiboot.model.Equipo;
import pe.com.microservice.taxiboot.model.Paginado;
import pe.com.microservice.taxiboot.model.Servicio;

public interface ServicioRepository {

	Servicio getServicio(Servicio servicio) throws Exception ;
	List<Servicio> listServicio(Servicio servicio) throws Exception;
	List<Servicio> listServicioPaginado(Paginado paginado) throws Exception;
	
}

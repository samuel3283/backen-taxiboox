package pe.com.microservice.taxiboot.dao.impl;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import pe.com.microservice.taxiboot.dao.ConductorRepository;
import pe.com.microservice.taxiboot.dao.EquipoRepository;
import pe.com.microservice.taxiboot.dao.ServicioRepository;
import pe.com.microservice.taxiboot.dao.mapper.ConductorMapper;
import pe.com.microservice.taxiboot.dao.mapper.EquipoMapper;
import pe.com.microservice.taxiboot.dao.mapper.ServicioMapper;
import pe.com.microservice.taxiboot.model.Conductor;
import pe.com.microservice.taxiboot.model.Equipo;
import pe.com.microservice.taxiboot.model.Paginado;
import pe.com.microservice.taxiboot.model.Servicio;

@SuppressWarnings("all")
@Repository
public class ServicioRepositoryImpl implements ServicioRepository {

	private final Logger logger = LoggerFactory.getLogger(ServicioRepositoryImpl.class);

	@Autowired
	@Resource(name = "jdbcTemplateMySql")
	private JdbcTemplate jdbcTemplate;


	@Override
	public Servicio getServicio(Servicio servicio) throws Exception {
		List <Servicio> lista = null;
		Servicio bean = null;
		StringBuilder sql_find_user = new StringBuilder();
		sql_find_user.append("SELECT S.CODIGO, S.DIRORIGEN, S.LATORI, S.LNGORI, S.DIRDESTINO, "); 
		sql_find_user.append("S.LATDES,S.LNGDES,S.PLACAVEHICULO, S.CODPASAJERO,S.CODCONDUCTOR, ");
		sql_find_user.append("DATE_FORMAT(S.FEC_REGISTRO,'%d/%m/%Y %H:%i:%s') FEC_REGISTRO, ");
		sql_find_user.append("S.ESTSERVICIO, P.NOMBRE, P.APELLIDO, P.TELEFONO, P.FOTO AS FOTO, ");
		sql_find_user.append("S.VALORACION, S.PRECIO ");
		sql_find_user.append("FROM tbl_servicios S, tbl_pasajero P ");
		sql_find_user.append("WHERE S.CODPASAJERO=P.CODIGO ");
		sql_find_user.append("AND S.ESTSERVICIO='P' "); 

		logger.info("data"+sql_find_user);
  		
  		Object[] params = new Object[] {
  		//conductor.getEmail(), conductor.getPassword(), conductor.getEstado()
		};
		
    	//lista = (List <Servicio> )jdbcTemplate.query(sql_find_user.toString(),params, new ServicioMapper());        	
  		lista = (List <Servicio> )jdbcTemplate.query(sql_find_user.toString(), new ServicioMapper()); 
		logger.info("size.::"+lista.size());
    	if(lista!=null && lista.size()>0){
    		bean = new Servicio();
    		bean = lista.get(0);
    	}

		return bean;	
	}


	@Override
	public List<Servicio> listServicio(Servicio servicio) throws Exception {
		List <Servicio> lista = null;
		Servicio bean = null;
		StringBuilder sql_find_user = new StringBuilder();
		sql_find_user.append("SELECT S.CODIGO, S.DIRORIGEN, S.LATORI, S.LNGORI, S.DIRDESTINO, "); 
		sql_find_user.append("S.LATDES,S.LNGDES,S.PLACAVEHICULO, S.CODPASAJERO,S.CODCONDUCTOR, ");
		sql_find_user.append("DATE_FORMAT(S.FEC_REGISTRO,'%d/%m/%Y %H:%i:%s') FEC_REGISTRO, ");
		sql_find_user.append("S.ESTSERVICIO, P.NOMBRE, P.APELLIDO, P.TELEFONO, P.FOTO AS FOTO, ");
		sql_find_user.append("S.VALORACION, S.PRECIO ");
		sql_find_user.append("FROM tbl_servicios S, tbl_pasajero P ");
		sql_find_user.append("WHERE S.CODPASAJERO=P.CODIGO ");
		sql_find_user.append("AND S.ESTSERVICIO!='P' "); 
		
		logger.info("data"+sql_find_user);
  		
  		Object[] params = new Object[] {
  		//conductor.getEmail(), conductor.getPassword(), conductor.getEstado()
		};
		
    	//lista = (List <Servicio> )jdbcTemplate.query(sql_find_user.toString(),params, new ServicioMapper());        	
  		lista = (List <Servicio> )jdbcTemplate.query(sql_find_user.toString(), new ServicioMapper()); 
		logger.info("size.::"+lista.size());
    	

		return lista;	
	}

	
	@Override
	public List<Servicio> listServicioPaginado(Paginado paginado) throws Exception {
		List <Servicio> lista = null;
		Servicio bean = null;
		
		//select * from tbl_parametros limit 6,2   pag,rango
		
		int rango =  Integer.valueOf(paginado.getRango());
		int pagina = Integer.valueOf(paginado.getPagina());
		pagina = pagina - 1;
		pagina = pagina * rango;
		
		StringBuilder sql_find_user = new StringBuilder();
		sql_find_user.append("SELECT S.CODIGO, S.DIRORIGEN, S.LATORI, S.LNGORI, S.DIRDESTINO, "); 
		sql_find_user.append("S.LATDES,S.LNGDES,S.PLACAVEHICULO, S.CODPASAJERO,S.CODCONDUCTOR, ");
		sql_find_user.append("DATE_FORMAT(S.FEC_REGISTRO,'%d/%m/%Y %H:%i:%s') FEC_REGISTRO, ");
		sql_find_user.append("S.ESTSERVICIO, P.NOMBRE, P.APELLIDO, P.TELEFONO, P.FOTO AS FOTO, ");
		sql_find_user.append("S.VALORACION, S.PRECIO ");
		sql_find_user.append("FROM tbl_servicios S, tbl_pasajero P ");
		sql_find_user.append("WHERE S.CODPASAJERO=P.CODIGO ");
		sql_find_user.append("AND S.ESTSERVICIO!='P' "); 		
		sql_find_user.append("limit ?,?"); 
		
		logger.info("data"+sql_find_user);
  		
  		Object[] params = new Object[] {
  		//conductor.getEmail(), conductor.getPassword(), conductor.getEstado()
  		pagina,rango		
		};
		
    	lista = (List <Servicio> )jdbcTemplate.query(sql_find_user.toString(),params, new ServicioMapper());        	
  		logger.info("size.::"+lista.size());
    	

		return lista;	
	}

}

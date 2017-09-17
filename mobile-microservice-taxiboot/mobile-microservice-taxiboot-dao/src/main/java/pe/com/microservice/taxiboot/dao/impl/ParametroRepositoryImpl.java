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
import pe.com.microservice.taxiboot.dao.ParametroRepository;
import pe.com.microservice.taxiboot.dao.ServicioRepository;
import pe.com.microservice.taxiboot.dao.mapper.ConductorMapper;
import pe.com.microservice.taxiboot.dao.mapper.EquipoMapper;
import pe.com.microservice.taxiboot.dao.mapper.ParametroMapper;
import pe.com.microservice.taxiboot.dao.mapper.ServicioMapper;
import pe.com.microservice.taxiboot.model.Conductor;
import pe.com.microservice.taxiboot.model.Equipo;
import pe.com.microservice.taxiboot.model.Parametro;
import pe.com.microservice.taxiboot.model.Servicio;

@SuppressWarnings("all")
@Repository
public class ParametroRepositoryImpl implements ParametroRepository {

	private final Logger logger = LoggerFactory.getLogger(ParametroRepositoryImpl.class);

	@Autowired
	@Resource(name = "jdbcTemplateMySql")
	private JdbcTemplate jdbcTemplate;



	@Override
	public List<Parametro> listParametro(String tipo) throws Exception {
		List <Parametro> lista = null;

		StringBuilder sql_find_user = new StringBuilder();
		sql_find_user.append("select cod,val,val_abre from tbl_parametros ");
		sql_find_user.append("where tipo=? and estado=1 order by codigo ");
		
		logger.info("data"+sql_find_user);
  		
  		Object[] params = new Object[] { tipo };
		
    	lista = (List <Parametro> )jdbcTemplate.query(sql_find_user.toString(),params, new ParametroMapper());        	
  		logger.info("size.::"+lista.size());
    	

		return lista;	
	}

	@Override
	public Parametro getParametro(String tipo) throws Exception {
		List<Parametro> lista = null;
		Parametro bean = null;
		
		StringBuilder sql_find_user = new StringBuilder();
		sql_find_user.append("select cod,val,val_abre from tbl_parametros ");
		sql_find_user.append("where tipo=? and estado=1 ");
		
		logger.info("data"+sql_find_user);
  		
  		Object[] params = new Object[] { tipo };
		
    	lista = (List <Parametro> )jdbcTemplate.query(sql_find_user.toString(),params, new ParametroMapper());        	
  		logger.info("size.::"+lista.size());

  		if(lista!=null && lista.size()>0){
    		bean = new Parametro();
    		bean = lista.get(0);
    	}
  		
		return bean;	
	}

}

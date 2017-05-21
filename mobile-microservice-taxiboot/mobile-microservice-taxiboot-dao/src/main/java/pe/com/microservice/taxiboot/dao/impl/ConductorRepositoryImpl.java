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
import pe.com.microservice.taxiboot.dao.mapper.ConductorMapper;
import pe.com.microservice.taxiboot.dao.mapper.EquipoMapper;
import pe.com.microservice.taxiboot.model.Conductor;
import pe.com.microservice.taxiboot.model.Equipo;

@SuppressWarnings("all")
@Repository
public class ConductorRepositoryImpl implements ConductorRepository {

	private final Logger logger = LoggerFactory.getLogger(ConductorRepositoryImpl.class);

	@Autowired
	@Resource(name = "jdbcTemplateMySql")
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insertConductor(Conductor conductor) throws Exception {
	
		StringBuilder sql_insert_user = new StringBuilder();
		sql_insert_user.append("INSERT INTO TBL_CONDUCTOR ");
		sql_insert_user.append("(DEVICE,DEVICETYPE,NOMBRE,APELLIDO,EMAIL,PASSWORD,TIPDOC,NUMDOC, ");
		sql_insert_user.append("PAIS,TELEFONO,FEC_REGISTRO,ESTADO) ");
		sql_insert_user.append("VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ");
		logger.info("insertCon");
		
		java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaHora = sdf.format(dt);
                
		Object[] params = new Object[] {
		conductor.getDevice(), conductor.getDeviceType(), conductor.getNombre(), conductor.getApellido(),
		conductor.getEmail(), conductor.getPassword(), conductor.getTipoDoc(), conductor.getNumDoc(),
		Integer.parseInt(conductor.getPais()), conductor.getTelefono(),
		fechaHora, conductor.getEstado()
		};
		jdbcTemplate.update(sql_insert_user.toString(), params);
		logger.info("fin insCon");
				
	}


	@Override
	public Conductor getConductor(Conductor conductor) throws Exception {
		List <Conductor> lista = null;
		Conductor bean = null;
		StringBuilder sql_find_user = new StringBuilder();
		sql_find_user.append("SELECT CODIGO, DEVICE, DEVICETYPE, NOMBRE, APELLIDO, EMAIL, ");
		sql_find_user.append("TIPDOC, NUMDOC, PAIS, TELEFONO, ESTADO, "); 
		sql_find_user.append("DATE_FORMAT(FEC_REGISTRO,'%d/%m/%Y %H:%i:%s') FEC_REG  ");
  		sql_find_user.append("FROM TBL_CONDUCTOR WHERE EMAIL=? AND PASSWORD=? AND ESTADO=? ");

  		Object[] params = new Object[] {
  		conductor.getEmail(), conductor.getPassword(), conductor.getEstado()
		};
    	lista = (List <Conductor> )jdbcTemplate.query(sql_find_user.toString(),params, new ConductorMapper());        	
    	if(lista!=null && lista.size()>0){
    		bean = new Conductor();
    		bean = lista.get(0);
    	}

		return bean;	
	}


}

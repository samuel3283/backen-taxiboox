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
import pe.com.microservice.taxiboot.dao.UbicacionRepository;
import pe.com.microservice.taxiboot.dao.mapper.ConductorMapper;
import pe.com.microservice.taxiboot.dao.mapper.EquipoMapper;
import pe.com.microservice.taxiboot.model.Conductor;
import pe.com.microservice.taxiboot.model.Equipo;
import pe.com.microservice.taxiboot.model.Ubicacion;

@SuppressWarnings("all")
@Repository
public class UbicacionRepositoryImpl implements UbicacionRepository {

	private final Logger logger = LoggerFactory.getLogger(UbicacionRepositoryImpl.class);

	@Autowired
	@Resource(name = "jdbcTemplateMySql")
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insertUbicacion(Ubicacion ubicacion) throws Exception {
	
		StringBuilder sql_insert_user = new StringBuilder();
		sql_insert_user.append("INSERT INTO tbl_ubicaciones ");
		sql_insert_user.append("(LATITUD,LONGITUD,ALTURA,VELOCIDAD,APROXIMACION, ");
		sql_insert_user.append("CODCONDUCTOR,PLACAVEHICULO,FEC_REGISTRO) ");
		sql_insert_user.append("VALUES (?,?,?,?,?,?,?,?) ");
		logger.info("insertUbicacion");
		
		java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaHora = sdf.format(dt);
                
		Object[] params = new Object[] {
				ubicacion.getLatitud(), ubicacion.getLongitud(), ubicacion.getAltura(), ubicacion.getVelocidad(),
				ubicacion.getAproximacion(),ubicacion.getCodigoConductor(),ubicacion.getPlaca(), fechaHora
		};
		jdbcTemplate.update(sql_insert_user.toString(), params);
		logger.info("fin insertUbicacion");
				
	}

}

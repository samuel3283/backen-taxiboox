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
import pe.com.microservice.taxiboot.dao.EquipoRepository;
import pe.com.microservice.taxiboot.dao.mapper.EquipoMapper;
import pe.com.microservice.taxiboot.model.Equipo;

@SuppressWarnings("all")
@Repository
public class EquipoRepositoryImpl implements EquipoRepository {

	private final Logger logger = LoggerFactory.getLogger(EquipoRepositoryImpl.class);

	@Autowired
	@Resource(name = "jdbcTemplateMySql")
	private JdbcTemplate jdbcTemplate;

	private SimpleJdbcCall insertEquipo;
	private SimpleJdbcCall updateEquipo;
	private SimpleJdbcCall getEquipo;
	
	private String SP_INSERT_EQUIPO="insertEquipo";

	private String COLUMN_DEVICE="pDEVICE";
	private String COLUMN_DEVICETYPE="pDEVICETYPE";
	private String COLUMN_TELEFONO="pTELEFONO";
	private String COLUMN_SMS="pSMS";
	private String COLUMN_ESTADO="pESTADO";       	//int 
	private String COLUMN_SEG_EXPIRA="pSEG_EXPIRA"; //int

	/*
	@PostConstruct
	public void setUp() {

		this.insertEquipo = new SimpleJdbcCall(jdbcTemplate).withProcedureName(SP_INSERT_EQUIPO);
		this.insertEquipo.declareParameters(
				new SqlParameter(COLUMN_DEVICE, Types.VARCHAR),
				new SqlParameter(COLUMN_DEVICETYPE, Types.VARCHAR),
				new SqlParameter(COLUMN_TELEFONO, Types.VARCHAR),
				new SqlParameter(COLUMN_SMS, Types.VARCHAR),
				new SqlParameter(COLUMN_ESTADO, Types.INTEGER),
				new SqlParameter(COLUMN_SEG_EXPIRA, Types.INTEGER)
				);
	}
	 */
	
	@Override
	public void insertEquipo(Equipo equipo) throws Exception {
	
		StringBuilder sql_insert_user = new StringBuilder();
		sql_insert_user.append("INSERT INTO tbl_equipo ");
		sql_insert_user.append("(DEVICE,DEVICETYPE,PAIS,TELEFONO,SMS,ESTADO,FEC_EXPIRA,FEC_REGISTRO,FEC_MODIFICA) ");
		sql_insert_user.append("VALUES (?,?,?,?,?,?,?,?,?) ");
		logger.info("insert");
		
		java.util.Date date1 = new Date();
		java.sql.Date fechaActual = new java.sql.Date(date1.getTime());
		
		java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaHora = sdf.format(dt);
        
        int intervalo = 90;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1); 
        calendar.add(Calendar.SECOND, intervalo); 
        
        java.text.SimpleDateFormat sdf2 = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaIntervalo = sdf.format(calendar.getTime());
        
		Object[] params = new Object[] {
		equipo.getDevice(), equipo.getDeviceType(), Integer.parseInt(equipo.getPais()), equipo.getTelefono(),
		equipo.getSms(), equipo.getEstado(), fechaIntervalo, fechaHora, fechaHora
		//pSMS,vESTADO,NOW() + INTERVAL pSEG_EXPIRA SECOND, now()
		//new Timestamp(userSession.getTokenExpirationDate()), userSession.getPinBlock(),
		};
		logger.info("ini ins  ==>:fechaIntervalo"+fechaIntervalo+"==>fechaHora:"+fechaHora);
		jdbcTemplate.update(sql_insert_user.toString(), params);
		logger.info("fin ins");
				
		/*
		Map<String, Object> params = new HashMap<>();
		params.put(COLUMN_DEVICE, equipo.getDevice());
		params.put(COLUMN_DEVICETYPE, equipo.getDeviceType());
		params.put(COLUMN_TELEFONO, equipo.getTelefono());
		params.put(COLUMN_SMS, equipo.getSms());
		params.put(COLUMN_ESTADO, equipo.getEstado());
		params.put(COLUMN_SEG_EXPIRA, equipo.getSegExpira());
		insertEquipo.compile();
		insertEquipo.execute(params);
		*/
	}

	
	
	@Override
	public void updateEquipo(Equipo equipo) throws Exception {
	
		StringBuilder sql_insert_user = new StringBuilder();
		sql_insert_user.append("UPDATE tbl_equipo ");
		sql_insert_user.append("SET PAIS=?, TELEFONO=?, SMS=?, FEC_EXPIRA=?, FEC_MODIFICA=? ");
		sql_insert_user.append("WHERE DEVICE=? AND DEVICETYPE=? AND TELEFONO=? AND ESTADO=? ");
	
		java.util.Date date1 = new Date();
		java.sql.Date fechaActual = new java.sql.Date(date1.getTime());
		
		java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaHora = sdf.format(dt);
        
        int intervalo = 60;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1); 
        calendar.add(Calendar.SECOND, intervalo); 
        
        java.text.SimpleDateFormat sdf2 = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaIntervalo = sdf.format(calendar.getTime());

        Object[] params = new Object[] {
		Integer.parseInt(equipo.getPais()), equipo.getTelefono(), equipo.getSms(), fechaIntervalo, fechaHora, 
		equipo.getDevice(), equipo.getDeviceType(), equipo.getTelefono(),  equipo.getEstado()
		};
		jdbcTemplate.update(sql_insert_user.toString(), params);
				
	}

	
	@Override
	public Equipo getEquipo(Equipo equipo) throws Exception {
		List <Equipo> lista = null;
		Equipo bean = null;
		StringBuilder sql_find_user = new StringBuilder();
		sql_find_user.append("SELECT CODIGO, DEVICE, DEVICETYPE, PAIS, TELEFONO, SMS, ESTADO, "); 
		//sql_find_user.append("FEC_EXPIRA, FEC_REGISTRO, FEC_MODIFICA  ");
		sql_find_user.append("DATE_FORMAT(FEC_EXPIRA,'%d/%m/%Y %H:%i:%s') FEC_EXP, ");
		sql_find_user.append("DATE_FORMAT(FEC_REGISTRO,'%d/%m/%Y %H:%i:%s') FEC_REG, ");
		sql_find_user.append("DATE_FORMAT(FEC_MODIFICA,'%d/%m/%Y %H:%i:%s') FEC_MOD ");
  		sql_find_user.append("FROM tbl_equipo WHERE DEVICE=? AND DEVICETYPE=? AND TELEFONO=? AND ESTADO=? ");
		
  		
		Object[] params = new Object[] {
		equipo.getDevice(), equipo.getDeviceType(), equipo.getTelefono(), equipo.getEstado()
		};
    	lista = (List <Equipo>) jdbcTemplate.query(sql_find_user.toString(),params, new EquipoMapper());        	
    	if(lista!=null && lista.size()>0){
    		bean = new Equipo();
    		bean = lista.get(0);
    	}

		return bean;	
	}

	@Override
	public Equipo getEquipoxSms(Equipo equipo) throws Exception {
		List <Equipo> lista = null;
		Equipo bean = null;
		StringBuilder sql_find_user = new StringBuilder();
		sql_find_user.append("SELECT CODIGO, DEVICE, DEVICETYPE, PAIS, TELEFONO, SMS, ESTADO, "); 
		sql_find_user.append("DATE_FORMAT(FEC_EXPIRA,'%d/%m/%Y %H:%i:%s') FEC_EXP, ");
		sql_find_user.append("DATE_FORMAT(FEC_REGISTRO,'%d/%m/%Y %H:%i:%s') FEC_REG, ");
		sql_find_user.append("DATE_FORMAT(FEC_MODIFICA,'%d/%m/%Y %H:%i:%s') FEC_MOD ");
  		sql_find_user.append("FROM tbl_equipo WHERE DEVICE=? AND DEVICETYPE=? AND TELEFONO=? AND SMS=? AND ESTADO=? ");
		
		Object[] params = new Object[] {
		equipo.getDevice(), equipo.getDeviceType(), equipo.getTelefono(), equipo.getSms(), equipo.getEstado()
		};
    	lista = (List <Equipo> )jdbcTemplate.query(sql_find_user.toString(),params, new EquipoMapper());        	
    	if(lista!=null && lista.size()>0){
    		bean = new Equipo();
    		bean = lista.get(0);
    	}

		return bean;	
	}

	@Override
	public Equipo getEquipoxTelefono(Equipo equipo) throws Exception {
		List <Equipo> lista = null;
		Equipo bean = null;
		StringBuilder sql_find_user = new StringBuilder();
		sql_find_user.append("SELECT CODIGO, DEVICE, DEVICETYPE, PAIS, TELEFONO, SMS, ESTADO, "); 
		sql_find_user.append("DATE_FORMAT(FEC_EXPIRA,'%d/%m/%Y %H:%i:%s') FEC_EXP, ");
		sql_find_user.append("DATE_FORMAT(FEC_REGISTRO,'%d/%m/%Y %H:%i:%s') FEC_REG, ");
		sql_find_user.append("DATE_FORMAT(FEC_MODIFICA,'%d/%m/%Y %H:%i:%s') FEC_MOD ");
  		sql_find_user.append("FROM tbl_equipo WHERE DEVICE=? AND DEVICETYPE=? AND PAIS=? AND TELEFONO=? AND ESTADO=? ");
		
		Object[] params = new Object[] {
		equipo.getDevice(), equipo.getDeviceType(), equipo.getPais(), equipo.getTelefono(), equipo.getEstado()
		};
    	lista = (List <Equipo> )jdbcTemplate.query(sql_find_user.toString(),params, new EquipoMapper());        	
    	if(lista!=null && lista.size()>0){
    		bean = new Equipo();
    		bean = lista.get(0);
    	}

		return bean;	
	}
	
	@Override
	public void updateValidaEquipo(Equipo equipo) throws Exception {
		
		StringBuilder sql_insert_user = new StringBuilder();
		sql_insert_user.append("UPDATE tbl_equipo ");
		sql_insert_user.append("SET ESTADO=?, FEC_MODIFICA=? ");
		sql_insert_user.append("WHERE DEVICE=? AND DEVICETYPE=? AND TELEFONO=? AND ESTADO=? ");
	
		java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaHora = sdf.format(dt);
        
        Object[] params = new Object[] {
		Integer.parseInt("1"), fechaHora,
		equipo.getDevice(), equipo.getDeviceType(), equipo.getTelefono(),  equipo.getEstado()
		};
		jdbcTemplate.update(sql_insert_user.toString(), params);
				
	}

	
	@Override
	public void updateNewSmsEquipo(Equipo equipo) throws Exception {
		
		StringBuilder sql_insert_user = new StringBuilder();
		sql_insert_user.append("UPDATE tbl_equipo ");
		sql_insert_user.append("SET SMS=?, FEC_MODIFICA=? ");
		sql_insert_user.append("WHERE DEVICE=? AND DEVICETYPE=? AND TELEFONO=? AND ESTADO=? ");
	
		java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaHora = sdf.format(dt);
        
        Object[] params = new Object[] {
        equipo.getSms(), fechaHora,
		equipo.getDevice(), equipo.getDeviceType(), equipo.getTelefono(),  equipo.getEstado()
		};
		jdbcTemplate.update(sql_insert_user.toString(), params);
				
	}

	@Override
	public void deleteEquipo(Equipo equipo) throws Exception {
		
		StringBuilder sql_insert_user = new StringBuilder();
		sql_insert_user.append("DELETE FROM tbl_equipo WHERE DEVICE=? AND DEVICETYPE=? AND TELEFONO=? ");
		
		java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaHora = sdf.format(dt);
        
        Object[] params = new Object[] {
		equipo.getDevice(), equipo.getDeviceType(), equipo.getTelefono()
		};
		jdbcTemplate.update(sql_insert_user.toString(), params);
				
	}

}

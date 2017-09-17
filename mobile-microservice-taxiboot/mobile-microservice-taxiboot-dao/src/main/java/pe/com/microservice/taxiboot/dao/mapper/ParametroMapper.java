package pe.com.microservice.taxiboot.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import pe.com.microservice.taxiboot.model.Conductor;
import pe.com.microservice.taxiboot.model.Parametro;



public class ParametroMapper implements RowMapper<Parametro> {

	public Parametro mapRow(ResultSet rs, int rowNum) throws SQLException {
		Parametro bean = new Parametro();
		try{
			bean.setCodigo(rs.getString(1));
			bean.setDescripcion(rs.getString(2));
			bean.setDescripcionAbreviada(rs.getString(3));
			
		} catch (Exception e) {
			e.printStackTrace();
		}				
          return bean;    
	}

}

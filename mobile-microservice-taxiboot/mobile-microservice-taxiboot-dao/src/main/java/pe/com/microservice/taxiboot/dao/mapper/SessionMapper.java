package pe.com.microservice.taxiboot.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import pe.com.microservice.taxiboot.model.Conductor;
import pe.com.microservice.taxiboot.model.Session;



public class SessionMapper implements RowMapper<Session> {

	public Session mapRow(ResultSet rs, int rowNum) throws SQLException {
		Session bean = new Session();
		try{
			bean.setCodigo(rs.getInt(1));
			bean.setDevice(rs.getString(2));
			bean.setDeviceType(rs.getString(3));
			bean.setToken(rs.getString(4));
			
			bean.setNombre(rs.getString(5));
			bean.setApellido(rs.getString(6));
			bean.setEmail(rs.getString(7));
			bean.setTipoDoc(rs.getString(8));
			bean.setNumDoc(rs.getString(9));

			bean.setPais(rs.getString(10));
			bean.setTelefono(rs.getString(11));
			bean.setEstado(rs.getInt(12));
						
			bean.setFecExpira(rs.getString(13));
			bean.setFecRegistro(rs.getString(14));
			bean.setFecModifica(rs.getString(15));

		} catch (Exception e) {
			e.printStackTrace();
		}				
          return bean;    
	}

}

package pe.com.microservice.taxiboot.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import pe.com.microservice.taxiboot.model.Conductor;



public class ConductorMapper implements RowMapper<Conductor> {

	public Conductor mapRow(ResultSet rs, int rowNum) throws SQLException {
		Conductor bean = new Conductor();
		try{
			bean.setCodigo(rs.getInt(1));
			bean.setIdConductor(rs.getInt(1));
			bean.setDevice(rs.getString(2));
			bean.setDeviceType(rs.getString(3));
			
			bean.setNombre(rs.getString(4));
			bean.setApellido(rs.getString(5));
			bean.setEmail(rs.getString(6));
			bean.setTipoDoc(rs.getString(7));
			bean.setNumDoc(rs.getString(8));
						
			bean.setPais(rs.getString(9));
			bean.setTelefono(rs.getString(10));
			bean.setEstado(rs.getInt(11));
			bean.setFecRegistro(rs.getString(12));			
			bean.setEstadoAtencion(rs.getString(13));			
			bean.setEstadoViaje(rs.getString(14));			

		} catch (Exception e) {
			e.printStackTrace();
		}				
          return bean;    
	}

}

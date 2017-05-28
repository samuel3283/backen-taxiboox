package pe.com.microservice.taxiboot.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import pe.com.microservice.taxiboot.model.Equipo;


public class EquipoMapper implements RowMapper<Equipo> {

	public Equipo mapRow(ResultSet rs, int rowNum) throws SQLException {
		Equipo bean = new Equipo();
		try{
			bean.setCodigo(rs.getInt(1));
			bean.setDevice(rs.getString(2));
			bean.setDeviceType(rs.getString(3));
			bean.setPais(rs.getString(4));
			bean.setTelefono(rs.getString(5));
			bean.setSms(rs.getString(6));
			bean.setEstado(rs.getInt(7));
			bean.setFecExpira(rs.getString(8));
			bean.setFecRegistro(rs.getString(9));
			bean.setFecModifica(rs.getString(10));
			
		} catch (Exception e) {
			e.printStackTrace();
		}				
          return bean;    
	}

}

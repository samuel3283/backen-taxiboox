package pe.com.microservice.taxiboot.dao.mapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import pe.com.microservice.taxiboot.core.util.Util;
import pe.com.microservice.taxiboot.model.Pasajero;
import pe.com.microservice.taxiboot.model.Servicio;


public class ServicioMapper implements RowMapper<Servicio> {

	public Servicio mapRow(ResultSet rs, int rowNum) throws SQLException {
		Servicio bean = new Servicio();
		try{
			bean.setCodigo(rs.getInt(1));
			bean.setDireccionOrigen(rs.getString(2));
			bean.setLatitudOrigen(rs.getString(3));
			bean.setLongitudOrigen(rs.getString(4));
			bean.setDireccionDestino(rs.getString(5));
			bean.setLatitudDestino(rs.getString(6));
			bean.setLongitudDestino(rs.getString(7));
			bean.setPlacaVehiculo(rs.getString(8));
			
			bean.setCodigoPasajero(rs.getInt(9));
			
			bean.setFecRegistro(rs.getString(11));
			bean.setEstadoServicio(rs.getString(12));

			bean.setValoracion(rs.getString(17));
			try {
			BigDecimal precio = new BigDecimal(rs.getString(18));
			bean.setPrecio(String.valueOf(precio.setScale(2)));
			} catch(Exception e) {
				bean.setPrecio("0.00");				
			}
			
			Pasajero p = new Pasajero();
			p.setNombre(rs.getString(13));
			p.setApellido(rs.getString(14));
			p.setTelefono(rs.getString(15));
			p.setFoto(rs.getString(16));

			bean.setPasajero(p);
			
			bean.setComentario(rs.getString(19));
			bean.setFecServicio(rs.getString(20));
			try {
				String fecha = Util.getDateToFormat(bean.getFecServicio(), Util.PATTERN_DD_MM_YY_HH_MI_SS, Util.PATTERN_DD_MM_YY_HH_MI_A);
				bean.setFecServicioFormateada(fecha);
			} catch (Exception e) {
				bean.setFecServicioFormateada(null);
				System.out.println("Error convert."+e.getMessage());
			}				
			
		} catch (Exception e) {
			e.printStackTrace();
		}				
          return bean;    
	}

}

package pe.com.microservice.taxiboot.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Servicio {

	@JsonInclude(Include.NON_NULL)
	private Integer codigo;
	@JsonInclude(Include.NON_NULL)
	private String direccionOrigen;
	@JsonInclude(Include.NON_NULL)
	private String latitudOrigen;
	@JsonInclude(Include.NON_NULL)
	private String longitudOrigen;
	@JsonInclude(Include.NON_NULL)
	private String direccionDestino;
	@JsonInclude(Include.NON_NULL)
	private String latitudDestino;
	@JsonInclude(Include.NON_NULL)
	private String longitudDestino;
	@JsonInclude(Include.NON_NULL)
	private String placaVehiculo;
	@JsonInclude(Include.NON_NULL)
	@JsonIgnore
	private Integer codigoConductor;
	@JsonInclude(Include.NON_NULL)
	@JsonIgnore
	private Integer codigoPasajero;
	@JsonInclude(Include.NON_NULL)
	private String fecRegistro;
	@JsonInclude(Include.NON_NULL)
	private String fecServicio;
	@JsonInclude(Include.NON_NULL)
	private String fecServicioFormateada;
	
	@JsonIgnore
	private String fecModifica;
	@JsonInclude(Include.NON_NULL)
	private String estadoServicio;
	@JsonInclude(Include.NON_NULL)
	private Pasajero pasajero;
	
	@JsonInclude(Include.NON_NULL)
	private String precio;
	@JsonInclude(Include.NON_NULL)
	private String valoracion;
	@JsonInclude(Include.NON_NULL)
	private String comentario;

	
	public Servicio() {
		this.pasajero = new Pasajero();
		this.codigo = new Integer(0);
		this.codigoConductor = new Integer(0);
		this.codigoPasajero = new Integer(0);
		this.precio = "0.00";
	}
	
	
	public String getPrecio() {
		return precio;
	}


	public void setPrecio(String precio) {
		this.precio = precio;
	}


	public String getValoracion() {
		return valoracion;
	}


	public void setValoracion(String valoracion) {
		this.valoracion = valoracion;
	}


	public Pasajero getPasajero() {
		return pasajero;
	}


	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}


	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDireccionOrigen() {
		return direccionOrigen;
	}

	public void setDireccionOrigen(String direccionOrigen) {
		this.direccionOrigen = direccionOrigen;
	}

	public String getLatitudOrigen() {
		return latitudOrigen;
	}

	public void setLatitudOrigen(String latitudOrigen) {
		this.latitudOrigen = latitudOrigen;
	}

	public String getLongitudOrigen() {
		return longitudOrigen;
	}

	public void setLongitudOrigen(String longitudOrigen) {
		this.longitudOrigen = longitudOrigen;
	}

	public String getDireccionDestino() {
		return direccionDestino;
	}

	public void setDireccionDestino(String direccionDestino) {
		this.direccionDestino = direccionDestino;
	}

	public String getLatitudDestino() {
		return latitudDestino;
	}

	public void setLatitudDestino(String latitudDestino) {
		this.latitudDestino = latitudDestino;
	}

	public String getLongitudDestino() {
		return longitudDestino;
	}

	public void setLongitudDestino(String longitudDestino) {
		this.longitudDestino = longitudDestino;
	}

	public String getPlacaVehiculo() {
		return placaVehiculo;
	}

	public void setPlacaVehiculo(String placaVehiculo) {
		this.placaVehiculo = placaVehiculo;
	}

	public Integer getCodigoConductor() {
		return codigoConductor;
	}

	public void setCodigoConductor(Integer codigoConductor) {
		this.codigoConductor = codigoConductor;
	}

	public Integer getCodigoPasajero() {
		return codigoPasajero;
	}

	public void setCodigoPasajero(Integer codigoPasajero) {
		this.codigoPasajero = codigoPasajero;
	}

	public String getFecRegistro() {
		return fecRegistro;
	}

	public void setFecRegistro(String fecRegistro) {
		this.fecRegistro = fecRegistro;
	}

	public String getFecModifica() {
		return fecModifica;
	}

	public void setFecModifica(String fecModifica) {
		this.fecModifica = fecModifica;
	}

	public String getEstadoServicio() {
		return estadoServicio;
	}

	public void setEstadoServicio(String estadoServicio) {
		this.estadoServicio = estadoServicio;
	}

	
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}


	public String getFecServicio() {
		return fecServicio;
	}


	public void setFecServicio(String fecServicio) {
		this.fecServicio = fecServicio;
	}


	public String getFecServicioFormateada() {
		return fecServicioFormateada;
	}


	public void setFecServicioFormateada(String fecServicioFormateada) {
		this.fecServicioFormateada = fecServicioFormateada;
	}


	@Override
	public String toString() {
		return "Servicio [codigo=" + codigo + ", direccionOrigen=" + direccionOrigen + ", latitudOrigen="
				+ latitudOrigen + ", longitudOrigen=" + longitudOrigen + ", direccionDestino=" + direccionDestino
				+ ", latitudDestino=" + latitudDestino + ", longitudDestino=" + longitudDestino + ", placaVehiculo="
				+ placaVehiculo + ", codigoConductor=" + codigoConductor + ", codigoPasajero=" + codigoPasajero
				+ ", fecRegistro=" + fecRegistro + ", fecModifica=" + fecModifica + ", estadoServicio=" + estadoServicio
				+ ", pasajero=" + pasajero + ", precio=" + precio + ", valoracion=" + valoracion + ", comentario="
				+ comentario + "]";
	}

	
	
	
}

package pe.com.microservice.taxiboot.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Ubicacion {

	@JsonInclude(Include.NON_NULL)
	private Integer codigo;

	private String latitud;
	private String longitud;
	private String altura;
	private String velocidad;
	private String aproximacion;

	private Integer codigoConductor;
	private String placa;
	private String fecRegistro;
	@JsonIgnore
	private String fecModifica;

	
	public Ubicacion() {
		this.codigo = new Integer(0);
	}


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getLatitud() {
		return latitud;
	}


	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}


	public String getLongitud() {
		return longitud;
	}


	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}


	public String getAltura() {
		return altura;
	}


	public void setAltura(String altura) {
		this.altura = altura;
	}


	public String getVelocidad() {
		return velocidad;
	}


	public void setVelocidad(String velocidad) {
		this.velocidad = velocidad;
	}


	public String getAproximacion() {
		return aproximacion;
	}


	public void setAproximacion(String aproximacion) {
		this.aproximacion = aproximacion;
	}


	public Integer getCodigoConductor() {
		return codigoConductor;
	}


	public void setCodigoConductor(Integer codigoConductor) {
		this.codigoConductor = codigoConductor;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
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


	@Override
	public String toString() {
		return "Ubicacion [codigo=" + codigo + ", latitud=" + latitud + ", longitud=" + longitud + ", altura=" + altura
				+ ", velocidad=" + velocidad + ", aproximacion=" + aproximacion + ", codigoConductor=" + codigoConductor
				+ ", placa=" + placa + ", fecRegistro=" + fecRegistro + ", fecModifica=" + fecModifica + "]";
	}
	
	
}

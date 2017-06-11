package pe.com.microservice.taxiboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Pasajero {

	@JsonInclude(Include.NON_NULL)
	@JsonIgnore
	private Integer codigo;
	@JsonInclude(Include.NON_NULL)
	@JsonIgnore
	private String device;
	@JsonInclude(Include.NON_NULL)
	@JsonIgnore
	private String deviceType;
	
	@JsonInclude(Include.NON_NULL)
	private String nombre;
	@JsonInclude(Include.NON_NULL)
	private String apellido;
	@JsonInclude(Include.NON_NULL)
	private String email;
	@JsonInclude(Include.NON_NULL)
	@JsonIgnore
	private String password;

	@JsonInclude(Include.NON_NULL)
	@JsonIgnore
	private String tipoDoc;
	@JsonInclude(Include.NON_NULL)
	@JsonIgnore
	private String numDoc;
	@JsonInclude(Include.NON_NULL)
	@JsonIgnore
	private String pais;
	@JsonInclude(Include.NON_NULL)
	@JsonIgnore
	private String telefono;
	
	@JsonInclude(Include.NON_NULL)
	private String foto;
	@JsonInclude(Include.NON_NULL)
	@JsonIgnore
	private Integer estado;
	
	public Pasajero() {
		this.codigo = new Integer(0);
		this.estado = new Integer(0);
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getNumDoc() {
		return numDoc;
	}

	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	
	
}

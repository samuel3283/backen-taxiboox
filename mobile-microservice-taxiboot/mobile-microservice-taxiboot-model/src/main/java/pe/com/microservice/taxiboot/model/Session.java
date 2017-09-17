package pe.com.microservice.taxiboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Session {

	private Integer codigo;
	private Integer idConductor;
	private String device;
	private String deviceType;
	private String token;
	
	private String nombre;
	private String apellido;
	private String email;

	private String tipoDoc;
	private String numDoc;

	private String pais;
	private String telefono;
	
	private Integer estado;
	@JsonIgnore
	private String fecExpira;
	private String fecRegistro;
	@JsonIgnore
	private String fecModifica;

	@JsonIgnore
	private String estadoAtencion;
	private String estadoViaje;

	private String fechaCarga;

	public Session() {
		this.codigo = new Integer(0);
		this.estado = new Integer(0);
		this.estadoAtencion = "D";
	}

	public Session(String token) {
		this.token = token;
	}
	/**
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the device
	 */
	public String getDevice() {
		return device;
	}

	/**
	 * @param device the device to set
	 */
	public void setDevice(String device) {
		this.device = device;
	}

	/**
	 * @return the deviceType
	 */
	public String getDeviceType() {
		return deviceType;
	}

	/**
	 * @param deviceType the deviceType to set
	 */
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the tipoDoc
	 */
	public String getTipoDoc() {
		return tipoDoc;
	}

	/**
	 * @param tipoDoc the tipoDoc to set
	 */
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	/**
	 * @return the numDoc
	 */
	public String getNumDoc() {
		return numDoc;
	}

	/**
	 * @param numDoc the numDoc to set
	 */
	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}

	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the estado
	 */
	public Integer getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	/**
	 * @return the fecExpira
	 */
	public String getFecExpira() {
		return fecExpira;
	}

	/**
	 * @param fecExpira the fecExpira to set
	 */
	public void setFecExpira(String fecExpira) {
		this.fecExpira = fecExpira;
	}

	/**
	 * @return the fecRegistro
	 */
	public String getFecRegistro() {
		return fecRegistro;
	}

	/**
	 * @param fecRegistro the fecRegistro to set
	 */
	public void setFecRegistro(String fecRegistro) {
		this.fecRegistro = fecRegistro;
	}

	/**
	 * @return the fecModifica
	 */
	public String getFecModifica() {
		return fecModifica;
	}

	/**
	 * @param fecModifica the fecModifica to set
	 */
	public void setFecModifica(String fecModifica) {
		this.fecModifica = fecModifica;
	}
	

	public String getEstadoAtencion() {
		return estadoAtencion;
	}

	public void setEstadoAtencion(String estadoAtencion) {
		this.estadoAtencion = estadoAtencion;
	}

	public String getEstadoViaje() {
		return estadoViaje;
	}

	public void setEstadoViaje(String estadoViaje) {
		this.estadoViaje = estadoViaje;
	}

	
	public String getFechaCarga() {
		return fechaCarga;
	}

	public void setFechaCarga(String fechaCarga) {
		this.fechaCarga = fechaCarga;
	}

	public Integer getIdConductor() {
		return idConductor;
	}

	public void setIdConductor(Integer idConductor) {
		this.idConductor = idConductor;
	}

	@Override
	public String toString() {
		return "Session [codigo=" + codigo + ", device=" + device + ", deviceType=" + deviceType + ", token=" + token
				+ ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", tipoDoc=" + tipoDoc
				+ ", numDoc=" + numDoc + ", pais=" + pais + ", telefono=" + telefono + ", estado=" + estado
				+ ", fecExpira=" + fecExpira + ", fecRegistro=" + fecRegistro + ", fecModifica=" + fecModifica
				+ ", estadoAtencion=" + estadoAtencion + ", estadoViaje=" + estadoViaje + ", fechaCarga=" + fechaCarga
				+ "]";
	}


	
}

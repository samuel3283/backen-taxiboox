package pe.com.microservice.taxiboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Conductor {

	private Integer codigo;
	private String device;
	private String deviceType;
	
	private String nombre;
	private String apellido;
	private String email;
	@JsonInclude(Include.NON_NULL)
	private String password;
	@JsonInclude(Include.NON_NULL)
	private Integer idConductor;

	private String tipoDoc;
	private String numDoc;

	private String pais;
	private String telefono;
	
	@JsonIgnore
	private Integer estado;
	@JsonIgnore
	private String fecExpira;
	private String fecRegistro;
	@JsonIgnore
	private Integer segExpira;
	@JsonInclude(Include.NON_NULL)
	private String estadoAtencion;
	@JsonInclude(Include.NON_NULL)
	private String estadoViaje;
	@JsonInclude(Include.NON_NULL)
	private String olvido;

	public Conductor() {
		this.codigo = new Integer(0);
		this.estado = new Integer(0);
		this.segExpira = new Integer(0);
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
	 * @return the deviceTye
	 */
	public String getDeviceType() {
		return deviceType;
	}
	/**
	 * @param deviceTye the deviceTye to set
	 */
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
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
	 * @return the segExpira
	 */
	public Integer getSegExpira() {
		return segExpira;
	}
	/**
	 * @param segExpira the segExpira to set
	 */
	public void setSegExpira(Integer segExpira) {
		this.segExpira = segExpira;
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	

	public String getOlvido() {
		return olvido;
	}

	public void setOlvido(String olvido) {
		this.olvido = olvido;
	}

	public Integer getIdConductor() {
		return idConductor;
	}

	public void setIdConductor(Integer idConductor) {
		this.idConductor = idConductor;
	}

	@Override
	public String toString() {
		return "Conductor [codigo=" + codigo + ", device=" + device + ", deviceType=" + deviceType + ", nombre="
				+ nombre + ", apellido=" + apellido + ", email=" + email + ", password=" + password + ", idConductor="
				+ idConductor + ", tipoDoc=" + tipoDoc + ", numDoc=" + numDoc + ", pais=" + pais + ", telefono="
				+ telefono + ", estado=" + estado + ", fecExpira=" + fecExpira + ", fecRegistro=" + fecRegistro
				+ ", segExpira=" + segExpira + ", estadoAtencion=" + estadoAtencion + ", estadoViaje=" + estadoViaje
				+ ", olvido=" + olvido + "]";
	}
	

	
}

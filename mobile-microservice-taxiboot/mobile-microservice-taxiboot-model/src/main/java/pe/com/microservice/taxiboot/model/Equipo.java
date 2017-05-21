package pe.com.microservice.taxiboot.model;

public class Equipo {

	private Integer codigo;
	private String device;
	private String deviceType;
	private String pais;
	private String telefono;
	private String sms;
	private Integer estado;
	private String fecExpira;
	private String fecRegistro;
	private String fecModifica;
	private Integer segExpira;
	
	public Equipo() {
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
	 * @return the sms
	 */
	public String getSms() {
		return sms;
	}
	/**
	 * @param sms the sms to set
	 */
	public void setSms(String sms) {
		this.sms = sms;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Equipo [codigo=" + codigo + ", device=" + device + ", deviceType=" + deviceType + ", pais=" + pais
				+ ", telefono=" + telefono + ", sms=" + sms + ", estado=" + estado + ", fecExpira=" + fecExpira
				+ ", fecRegistro=" + fecRegistro + ", fecModifica=" + fecModifica + ", segExpira=" + segExpira + "]";
	}

	
	
}

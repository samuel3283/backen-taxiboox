package pe.com.microservice.taxiboot.model;

public class HeaderRq {
	private String token;
	private String deviceType;
	private String device;
	
	
	public HeaderRq(String token, String deviceType, String device) {
		super();
		this.token = token;
		this.deviceType = deviceType;
		this.device = device;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HeaderRq [token=" + token + ", deviceType=" + deviceType + ", device=" + device + "]";
	}
	

	
}

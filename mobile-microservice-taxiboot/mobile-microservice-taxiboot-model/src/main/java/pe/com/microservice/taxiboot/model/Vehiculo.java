package pe.com.microservice.taxiboot.model;

public class Vehiculo {

	private Integer codigo;
	private String placa;
	private String brevete;
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getBrevete() {
		return brevete;
	}
	public void setBrevete(String brevete) {
		this.brevete = brevete;
	}
	@Override
	public String toString() {
		return "Vehiculo [codigo=" + codigo + ", placa=" + placa + ", brevete="
				+ brevete + "]";
	}
	
	
}

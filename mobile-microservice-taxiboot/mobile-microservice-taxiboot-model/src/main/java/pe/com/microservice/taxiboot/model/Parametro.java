package pe.com.microservice.taxiboot.model;

public class Parametro {

	private String codigo;
	private String descripcion;
	private String descripcionAbreviada;
	
	
	public Parametro() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Parametro(String codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDescripcionAbreviada() {
		return descripcionAbreviada;
	}
	public void setDescripcionAbreviada(String descripcionAbreviada) {
		this.descripcionAbreviada = descripcionAbreviada;
	}

	
	
}

package pe.com.microservice.taxiboot.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


/**
 * Clase encargada de mostrar los Json de Respuesta
 * 
 * @author Snavarro
 * @since 15/09/2016
 */

public class Response {
	
	@JsonIgnore
	private String codigo;
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("resultado")
	private String valor;

	@JsonInclude(Include.NON_NULL)
	private Equipo equipo;
	@JsonInclude(Include.NON_NULL)
	private Conductor conductor;
	@JsonInclude(Include.NON_NULL)
	private Vehiculo vehiculo;

	@JsonInclude(Include.NON_NULL)
	@JsonProperty("code")
	private RespuestaSms code;
	
	
	/**
	 * Constructor generico
	 */
	public Response() {
		
		super();
	}

	/**
	 * Constructor que recibe el codigo y valor
	 * @param codigo
	 * @param valor
	 */
	public Response(String codigo, String valor) {
		super();
		this.codigo = codigo;
		this.valor = valor;
	}

	/**
	 * Constructor que recibe el valor
 	 * @param valor
	 */
	public Response(String valor) {
		super();
		this.valor = valor;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public RespuestaSms getCode() {
		return code;
	}

	public void setCode(RespuestaSms code) {
		this.code = code;
	}


	
	
}

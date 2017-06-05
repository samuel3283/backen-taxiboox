package pe.com.microservice.taxiboot.model;

public class BeanRequest {

	private Equipo equipo;
	private Conductor conductor;
	private Vehiculo vehiculo;

	public BeanRequest() {
		super();
	}
	public Conductor getConductor() {
		return conductor;
	}
	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	@Override
	public String toString() {
		return "BeanRequest [conductor=" + conductor.toString() + ", equipo=" + equipo.toString()
				+ ", vehiculo=" + vehiculo.toString() + "]";
	}

	
}

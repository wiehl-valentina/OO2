package patrones._AlquilerDeAutomoviles;

import java.time.LocalDate;

public class Reserva {
	
	private AutoEnAlquiler vehiculo;
	private int cantidadDias;
	private LocalDate fecha;
	private Usuario conductor;
	
	public Reserva(AutoEnAlquiler vehiculo, int cantidadDias, LocalDate fecha, Usuario conductor) {
		super();
		this.vehiculo = vehiculo;
		this.cantidadDias = cantidadDias;
		this.fecha = fecha;
		this.conductor = conductor;
	}

	public AutoEnAlquiler getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(AutoEnAlquiler vehiculo) {
		this.vehiculo = vehiculo;
	}

	public int getCantidadDias() {
		return cantidadDias;
	}

	public void setCantidadDias(int cantidadDias) {
		this.cantidadDias = cantidadDias;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Usuario getConductor() {
		return conductor;
	}

	public double montoAPagar() {
		return this.cantidadDias*vehiculo.getPrecioPorDia();
	}
	
	public double montoAReembolsar(LocalDate fechaCancelacion) {
		return this.vehiculo.calcularReembolso(this, fechaCancelacion);
	}
	
}

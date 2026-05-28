package patrones._ArmadoDePCs;

import java.time.LocalDate;

public class Presupuesto {
	
	private String cliente;
	private LocalDate fecha;
	private Computadora equipo;
	
	public Presupuesto(String cliente, Computadora equipo) {
		this.cliente = cliente;
		this.equipo = equipo;
		this.fecha = LocalDate.now();
	}
	
	public String getCliente() {
		return cliente;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public Computadora getEquipo() {
		return equipo;
	}

	public double getMontoFinal() {
		return this.equipo.calcularPrecio();
	}

}

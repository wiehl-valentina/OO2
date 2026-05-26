package patrones._AlquilerDeAutomoviles;

import java.time.LocalDate;

public class AutoEnAlquiler {
	
	private double precioPorDia;
	private int cantidadPlazas;
	private String marca;
	private PoliticaCancelacion politicaCancelacion;
		
	public AutoEnAlquiler(double precioPorDia, int cantidadPlazas, String marca, PoliticaCancelacion politica) {
		super();
		this.precioPorDia = precioPorDia;
		this.cantidadPlazas = cantidadPlazas;
		this.marca = marca;
		this.politicaCancelacion = politica;
	}
	
	public double getPrecioPorDia() {
		return precioPorDia;
	}
	
	public void setPrecioPorDia(double precioPorDia) {
		this.precioPorDia = precioPorDia;
	}
	
	public int getCantidadPlazas() {
		return cantidadPlazas;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public PoliticaCancelacion getPoliticaCancelacion() {
		return politicaCancelacion;
	}

	public void setPoliticaCancelacion(PoliticaCancelacion politicaCancelacion) {
		this.politicaCancelacion = politicaCancelacion;
	}

	public double calcularReembolso(Reserva reserva, LocalDate fechaCancelacion) {
		return this.politicaCancelacion.calcularReembolso(reserva, fechaCancelacion);
	}
	
}

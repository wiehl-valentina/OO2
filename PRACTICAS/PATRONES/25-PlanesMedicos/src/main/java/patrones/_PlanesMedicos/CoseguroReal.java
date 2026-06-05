package patrones._PlanesMedicos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CoseguroReal implements Coseguro {
	
	private String nombre;
	private LocalDate fechaIngreso;
	private int descuento;
	private double montoCoberturaViajes;

	@Override
	public double getDescuento() {
		return this.descuento / 100.0;
	}

	@Override
	public int getAntiguedad() {
		return (int) ChronoUnit.YEARS.between(fechaIngreso, LocalDate.now());
	}

	@Override
	public double getMontoCoberturaViajes() {
		return this.montoCoberturaViajes;
	}

	public String getNombre() {
		return nombre;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public void setMontoCoberturaViajes(double montoCoberturaViajes) {
		this.montoCoberturaViajes = montoCoberturaViajes;
	}
	
}

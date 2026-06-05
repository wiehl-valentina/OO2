package patrones._PrestamosPrendarios;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Alquiler extends Prenda {
	
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private double costoMensual;
	
	public Alquiler(LocalDate fechaInicio, LocalDate fechaFin, double costoMensual) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.costoMensual = costoMensual;
	}
	
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public double getCostoMensual() {
		return costoMensual;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public void setCostoMensual(double costoMensual) {
		this.costoMensual = costoMensual;
	}

	@Override
	public double getCoeficienteLiquidez() {
		return 0.9;
	}

	@Override
	public double calcularValor() {
		return this.calcularMesesFaltantes() * this.costoMensual;
	}
	
	private int calcularMesesFaltantes() {
		return (int)ChronoUnit.MONTHS.between(fechaInicio, fechaFin);
	}

}

package patrones._PlanesMedicos;

import java.time.LocalDate;

public abstract class PlanMedico {
	
	protected double montoFijo;
	protected LocalDate fechaContratacion;
	protected double cargoPorIntegranteFamiliar;
	
	public PlanMedico(double montoFijo, LocalDate fechaContratacion, double cargoPorIntegranteFamiliar) {
		super();
		this.montoFijo = montoFijo;
		this.fechaContratacion = fechaContratacion;
		this.cargoPorIntegranteFamiliar = cargoPorIntegranteFamiliar;
	}

	public double getMontoFijo() {
		return montoFijo;
	}
	
	public void setMontoFijo(double montoFijo) {
		this.montoFijo = montoFijo;
	}
	
	public LocalDate getFechaContratacion() {
		return fechaContratacion;
	}
	
	public void setFechaContratacion(LocalDate fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}
	
	public double montoACobrar(double salario, int familiaresACargo, Coseguro coseguro) {
		return this.calcularMontoFijo(coseguro) + this.calcularCargaFamiliar(familiaresACargo, salario, coseguro)
				+ this.calcularCoberturaViajera(salario, coseguro) + this.calcularSeguroInternacion();
	}
	
	public abstract double calcularMontoFijo(Coseguro coseguro);
	
	public abstract double calcularCargaFamiliar(int familiaresACargo, double salario, Coseguro coseguro);
	
	public abstract double calcularCoberturaViajera(double salario, Coseguro coseguro);
	
	public abstract double calcularSeguroInternacion();
	
}

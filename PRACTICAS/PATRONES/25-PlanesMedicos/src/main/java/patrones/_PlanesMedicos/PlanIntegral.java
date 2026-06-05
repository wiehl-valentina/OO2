package patrones._PlanesMedicos;

import java.time.LocalDate;

public class PlanIntegral extends PlanMedico {

	public PlanIntegral(LocalDate fechaContratacion, double cargoPorIntegranteFamiliar) {
		super(22000, fechaContratacion, cargoPorIntegranteFamiliar);
	}

	@Override
	public double calcularMontoFijo(Coseguro coseguro) {
		return this.montoFijo;
	}

	@Override
	public double calcularCargaFamiliar(int familiaresACargo, double salario, Coseguro coseguro) {
		return (this.cargoPorIntegranteFamiliar * familiaresACargo) + (salario * 0.01); 
	}

	@Override
	public double calcularCoberturaViajera(double salario, Coseguro coseguro) {
		return Math.max(0, (salario * 0.03 - 10000 * coseguro.getAntiguedad()));
	}

	@Override
	public double calcularSeguroInternacion() {
		return this.montoFijo * 0.05; 
	}

}

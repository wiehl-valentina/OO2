package patrones._PlanesMedicos;

import java.time.LocalDate;

public class PlanPremium extends PlanMedico {
	
	public PlanPremium(LocalDate fechaContratacion, double cargoPorIntegranteFamiliar) {
		super(33000, fechaContratacion, cargoPorIntegranteFamiliar);
	}

	@Override
	public double calcularMontoFijo(Coseguro coseguro) {
		return this.montoFijo - coseguro.getDescuento();
	}

	@Override
	public double calcularCargaFamiliar(int familiaresACargo, double salario, Coseguro coseguro) {
		if (familiaresACargo > 4)
			return 2800 * (familiaresACargo - 4);
		return 0;
	}

	@Override
	public double calcularCoberturaViajera(double salario, Coseguro coseguro) {
		return (salario * 0.01) - coseguro.getMontoCoberturaViajes();
	}

	@Override
	public double calcularSeguroInternacion() {
		return this.montoFijo * 0.05;
	}

}

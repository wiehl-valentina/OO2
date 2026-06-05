package patrones._PlanesMedicos;

import java.time.LocalDate;

public class PlanObligatorio extends PlanMedico {
	
	public PlanObligatorio(LocalDate fechaContratacion, double cargoPorIntegranteFamiliar) {
		super(15000, fechaContratacion, cargoPorIntegranteFamiliar);
	}

	@Override
	public double calcularMontoFijo(Coseguro coseguro) {
		return this.montoFijo;
	}

	@Override
	public double calcularCargaFamiliar(int familiaresACargo, double salario, Coseguro coseguro) {
		return this.cargoPorIntegranteFamiliar - (this.cargoPorIntegranteFamiliar * coseguro.getDescuento())
				* familiaresACargo;
	}

	@Override
	public double calcularCoberturaViajera(double salario, Coseguro coseguro) {
		return (salario * 0.01) - coseguro.getMontoCoberturaViajes(); 
	}

	@Override
	public double calcularSeguroInternacion() {
		return 0;
	}

}

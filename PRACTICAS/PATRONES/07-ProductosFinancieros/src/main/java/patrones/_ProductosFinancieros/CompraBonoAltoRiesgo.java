package patrones._ProductosFinancieros;

public class CompraBonoAltoRiesgo extends ProductoFinanciero {

	private int parking;
	
	public CompraBonoAltoRiesgo(int parking) {
		this.parking = parking; 
	}
	
	public double retornoInversion(double montoInicial) {
		return montoInicial * (1 + Math.random() * 0.70);
	}
	
}

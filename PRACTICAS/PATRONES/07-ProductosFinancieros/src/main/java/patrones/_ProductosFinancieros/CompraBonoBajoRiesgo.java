package patrones._ProductosFinancieros;

public class CompraBonoBajoRiesgo extends ProductoFinanciero {

	private int parking;
	
	public CompraBonoBajoRiesgo(int parking) {
		this.parking = parking;
	}
	
	public double retornoInversion(double montoInicial) {
		return montoInicial * (1 + Math.random() * 0.10);
	}
	
}

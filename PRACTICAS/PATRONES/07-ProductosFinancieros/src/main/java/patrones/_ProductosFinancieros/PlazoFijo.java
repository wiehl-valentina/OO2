package patrones._ProductosFinancieros;

public class PlazoFijo extends ProductoFinanciero {
	
	private int cantidadDias;
	private double interes; 
	
	public PlazoFijo(int cantidadDias, double interes) {
		this.cantidadDias = cantidadDias;
		this.interes = interes;
	}
	
	public double retornoInversion(double montoInicial) {
		double tasaDiaria = this.interes/100.0;
		return montoInicial * Math.pow(1 + tasaDiaria, this.cantidadDias);
	}

} 

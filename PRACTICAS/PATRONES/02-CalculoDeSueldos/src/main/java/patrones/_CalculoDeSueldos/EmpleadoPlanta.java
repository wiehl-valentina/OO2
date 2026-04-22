package patrones._CalculoDeSueldos;

public class EmpleadoPlanta extends EmpleadoConCargasFamiliares {
	
	private int añosDeAntiguedad;
	
	public EmpleadoPlanta(int cantidadHijos, boolean estaCasado, int añosDeAntiguedad) {
		super(cantidadHijos, estaCasado);
		this.añosDeAntiguedad = añosDeAntiguedad;
	}

	public int getAñosDeAntiguedad() {
		return añosDeAntiguedad;
	}

	public void setAñosDeAntiguedad(int añosDeAntiguedad) {
		this.añosDeAntiguedad = añosDeAntiguedad;
	}

	public double calcularSueldoBasico() {
		return 50000; 
	}
	
	public double calcularExtras() {
		return calcularExtraPorHijos() + calcularExtraPorAntiguedad(); 
	}
	
	private double calcularExtraPorAntiguedad() {
		return 2000 * añosDeAntiguedad; 
	}
	
}

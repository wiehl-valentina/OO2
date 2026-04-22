package patrones._CalculoDeSueldos;

public class EmpleadoTemporario extends EmpleadoConCargasFamiliares {
	
	private int cantidadHorasTrabajadas;  

	public EmpleadoTemporario(int cantidadHijos, boolean estaCasado, int cantidadHorasTrabajadas) {
		super(cantidadHijos, estaCasado);
		this.cantidadHorasTrabajadas = cantidadHorasTrabajadas;
	}

	public int getCantidadHorasTrabajadas() {
		return cantidadHorasTrabajadas;
	}

	public void setCantidadHorasTrabajadas(int cantidadHorasTrabajadas) {
		this.cantidadHorasTrabajadas = cantidadHorasTrabajadas;
	}

	public double calcularSueldoBasico() {
		return 20000 + (cantidadHorasTrabajadas * 300); 
	}
	
	public double calcularExtras() {
		return calcularExtraPorHijos(); 
	}
	
}

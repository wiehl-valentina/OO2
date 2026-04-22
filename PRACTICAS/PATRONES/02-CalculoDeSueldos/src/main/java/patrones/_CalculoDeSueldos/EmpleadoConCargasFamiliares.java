package patrones._CalculoDeSueldos;

public abstract class EmpleadoConCargasFamiliares extends Empleado {
	
	protected int cantidadHijos; 
	protected boolean estaCasado; 
	
	public EmpleadoConCargasFamiliares(int cantidadHijos, boolean estaCasado) {
		super();
		this.cantidadHijos = cantidadHijos;
		this.estaCasado = estaCasado;
	}

	public int getCantidadHijos() {
		return cantidadHijos;
	}

	public void setCantidadHijos(int cantidadHijos) {
		this.cantidadHijos = cantidadHijos;
	}

	public boolean estaCasado() {
		return estaCasado;
	}

	public void setEstaCasado(boolean estaCasado) {
		this.estaCasado = estaCasado;
	}

	protected double calcularExtraPorHijos() {
		return 2000 * cantidadHijos; 
	}
	
	public double calcularSueldoAdicional() {
		return estaCasado ? 5000 + calcularExtras() : calcularExtras(); 
	}
	
	public abstract double calcularSueldoBasico(); 
	public abstract double calcularExtras(); 
	
}

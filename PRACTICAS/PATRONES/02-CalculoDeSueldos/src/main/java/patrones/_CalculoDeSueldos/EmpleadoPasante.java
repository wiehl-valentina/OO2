package patrones._CalculoDeSueldos;

public class EmpleadoPasante extends Empleado {

	private int cantidadExamenesRendidos; 
	
	public EmpleadoPasante(int cantidadExamenesRendidos) {
		this.cantidadExamenesRendidos = cantidadExamenesRendidos;
	}

	public int getCantidadExamenesRendidos() {
		return cantidadExamenesRendidos;
	}

	public void setCantidadExamenesRendidos(int cantidadExamenesRendidos) {
		this.cantidadExamenesRendidos = cantidadExamenesRendidos;
	}

	public double calcularSueldoBasico() {
		return 20000; 
	}
	
	public double calcularSueldoAdicional() {
		return 2000 * cantidadExamenesRendidos; 
	}
	
}

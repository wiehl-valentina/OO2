package patrones._CalculoDeSueldos;

public abstract class Empleado {
	
	public double sueldo() {
		return calcularSueldoBasico() + calcularSueldoAdicional() - calcularDescuento(); 
	}
	
	public abstract double calcularSueldoBasico(); 
	public abstract double calcularSueldoAdicional(); 
	
	public double calcularDescuento() {
		return calcularSueldoBasico() * 0.13 + calcularSueldoAdicional() * 0.05;
	}

}

package patrones._Calculadora;

public class OperacionDivision implements EstrategiaOperacion {
	
	public double resolver(double a, double b) {
		if (b == 0)
			throw new IllegalArgumentException("División por cero");
		return a/b;
	}

}

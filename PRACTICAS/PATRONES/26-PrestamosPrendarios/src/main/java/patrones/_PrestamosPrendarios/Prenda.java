package patrones._PrestamosPrendarios;

public abstract class Prenda {
	
	public double calcularValorPrendario() {
		return this.getCoeficienteLiquidez() * this.calcularValor();
	}
	
	public abstract double getCoeficienteLiquidez();
	
	public abstract double calcularValor();

}

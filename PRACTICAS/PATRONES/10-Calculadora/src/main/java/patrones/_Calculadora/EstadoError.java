package patrones._Calculadora;

public class EstadoError extends EstadoCalculadora {
	
	protected Calculadora calculadora;
	
	public EstadoError(Calculadora calculadora) {
		super(calculadora);
	}
	
	@Override
	public void setValor(double valor) {}
	
	@Override 
	public String getResultado() {
		return "Error";
	}

}

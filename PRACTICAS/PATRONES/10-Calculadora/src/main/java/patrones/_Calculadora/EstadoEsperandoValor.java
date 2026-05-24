package patrones._Calculadora;

public class EstadoEsperandoValor extends EstadoCalculadora {

	protected Calculadora calculadora;
	
	public EstadoEsperandoValor(Calculadora calculadora) {
		super(calculadora);
	}
	
	@Override
	public void setValor(double valor) {
		try {
			calculadora.setResultadoAcumulado(calculadora.getOperacion().resolver(calculadora.getResultadoAcumulado(), valor));
			calculadora.setEstado(new EstadoInicial(calculadora));			
		} catch (IllegalArgumentException e) {
			calculadora.setEstado(new EstadoError(calculadora));
		}
	}

}

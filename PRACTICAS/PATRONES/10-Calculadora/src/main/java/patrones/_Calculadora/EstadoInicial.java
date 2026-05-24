package patrones._Calculadora;

public class EstadoInicial extends EstadoCalculadora {
	
	public EstadoInicial(Calculadora calculadora) {
		super(calculadora);
	}
	
	@Override
	public void setValor(double valor) {
		calculadora.setResultadoAcumulado(valor);
	}
	
	@Override
	public void mas() {
		iniciarOperacion(new OperacionSuma());
		
	}
	
	@Override
	public void menos() {
		iniciarOperacion(new OperacionResta());
		
	}
	
	@Override
	public void por() {
		iniciarOperacion(new OperacionMultiplicacion());
		
	}
	
	@Override
	public void dividido() {
		iniciarOperacion(new OperacionDivision());
		
	}
	
	private void iniciarOperacion(EstrategiaOperacion operacion) {
		calculadora.setOperacion(operacion);
		calculadora.setEstado(new EstadoEsperandoValor(calculadora));
	}
	
	

}

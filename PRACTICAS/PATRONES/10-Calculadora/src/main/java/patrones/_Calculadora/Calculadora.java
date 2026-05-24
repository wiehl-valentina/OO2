package patrones._Calculadora;

public class Calculadora {
	
	private EstadoCalculadora estado;
	private EstrategiaOperacion operacion;
	private double resultadoAcumulado;
	
	public Calculadora() {
		this.resultadoAcumulado = 0;
		this.estado = new EstadoInicial(this);
	}

	public void setEstado(EstadoCalculadora estado) {
		this.estado = estado;
	}

	public EstrategiaOperacion getOperacion() {
		return operacion;
	}

	public void setOperacion(EstrategiaOperacion operacion) {
		this.operacion = operacion;
	}

	public double getResultadoAcumulado() {
		return resultadoAcumulado;
	}

	public void setResultadoAcumulado(double resultadoAcumulado) {
		this.resultadoAcumulado = resultadoAcumulado;
	}

	public void borrar() {
		estado.borrar();
	}
	
	public void setValor(double valor) {
		estado.setValor(valor);
	}
	
	public void mas() {
		estado.mas();
	}
	
	public void menos() {
		estado.menos();
	}
	
	public void por() {
		estado.por();
	}
	
	public void dividido() {
		estado.dividido();
	}
	
	public String getResultado() {
		return estado.getResultado();
	}
	
	

}

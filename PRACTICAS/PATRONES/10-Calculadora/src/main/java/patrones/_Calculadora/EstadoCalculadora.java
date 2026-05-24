package patrones._Calculadora;

public abstract class EstadoCalculadora {

	protected Calculadora calculadora;
	
	public EstadoCalculadora(Calculadora c) {
		this.calculadora = c;
	}
	
	public abstract void setValor(double valor);
	
	public void mas() { 
		calculadora.setEstado(new EstadoError(calculadora)); 
	}
	
    public void menos() { 
    	calculadora.setEstado(new EstadoError(calculadora)); 
    }
    
    public void por() { 
    	calculadora.setEstado(new EstadoError(calculadora)); 
    }
    
    public void dividido() { 
    	calculadora.setEstado(new EstadoError(calculadora)); 
    }
    
    public void borrar() {
    	calculadora.setResultadoAcumulado(0);
    	calculadora.setEstado(new EstadoInicial(calculadora));
    }
    
    public String getResultado() {
		return String.valueOf(calculadora.getResultadoAcumulado());
	}
	
}

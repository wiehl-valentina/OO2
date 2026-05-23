package patrones._SubteWay;

public class Sandwich {
	
	private Pan pan;
	private Principal principal;
	private Aderezo aderezo;
	private Adicional adicional;
	
	public void setPan(Pan pan) {
		this.pan = pan;
	}

	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}

	public void setAderezo(Aderezo aderezo) {
		this.aderezo = aderezo;
	}

	public void setAdicional(Adicional adicional) {
		this.adicional = adicional;
	}
	
	public double calcularPrecio() {
		double total = pan.getPrecio() + principal.getPrecio(); 
		if (aderezo != null) total+= aderezo.getPrecio(); 
		if (adicional != null) total+= adicional.getPrecio(); 
		
		return total; 
	}
	
}

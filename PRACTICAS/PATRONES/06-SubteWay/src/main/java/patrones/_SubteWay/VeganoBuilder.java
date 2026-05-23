package patrones._SubteWay;

public class VeganoBuilder {
	
	private Sandwich sandwich; 
	
	public VeganoBuilder() {
		this.sandwich = new Sandwich(); 
	}
	
	public void setPan() {
		sandwich.setPan(Pan.INTEGRAL);
	}
	
	public void setAderezo() {
		sandwich.setAderezo(Aderezo.CRIOLLA);
	}
	
	public void setPrincipal() {
		sandwich.setPrincipal(Principal.GIRGOLAS);
	}
	
	public void setAdicional() {
		sandwich.setAdicional(null);
	}
	
	public Sandwich getSandwich() {
		return this.sandwich; 
	}

}

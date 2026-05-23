package patrones._SubteWay;

public class SinTACCBuilder {
	
	private Sandwich sandwich; 
	
	public SinTACCBuilder() {
		this.sandwich = new Sandwich(); 
	}
	
	public void setPan() {
		sandwich.setPan(Pan.CHIPA);
	}
	
	public void setAderezo() {
		sandwich.setAderezo(Aderezo.TARTARA);
	}
	
	public void setPrincipal() {
		sandwich.setPrincipal(Principal.POLLO);
	}
	
	public void setAdicional() {
		sandwich.setAdicional(Adicional.VERDURAS);
	}
	
	public Sandwich getSandwich() {
		return this.sandwich;
	}

}

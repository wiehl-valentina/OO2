package patrones._SubteWay;

public class VegetarianoBuilder {
	
	private Sandwich sandwich;
	
	public VegetarianoBuilder() {
		this.sandwich = new Sandwich(); 
	}
	
	public void setPan() {
		sandwich.setPan(Pan.SEMILLAS);
	}
	
	public void setAderezo() {
		sandwich.setAderezo(null);
	}
	
	public void setPrincipal() {
		sandwich.setPrincipal(Principal.PROVOLETA);
	}
	
	public void setAdicional() {
		sandwich.setAdicional(Adicional.BERENJENAS);
	}
	
	public Sandwich getSandwich() {
		return this.sandwich; 
	}

}

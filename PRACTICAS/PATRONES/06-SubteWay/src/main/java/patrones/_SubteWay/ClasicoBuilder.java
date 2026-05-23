package patrones._SubteWay;

public class ClasicoBuilder implements SandwichBuilder {
	
	private Sandwich sandwich;
	
	public ClasicoBuilder() {
		this.sandwich = new Sandwich(); 
	}
	
	public void buildPan() {
		sandwich.setPan(Pan.BRIOCHE);
	}
	
	public void buildAderezo() {
		sandwich.setAderezo(Aderezo.MAYONESA);
	}
	
	public void buildPrincipal() {
		sandwich.setPrincipal(Principal.TERNERA);
	}
	
	public void buildAdicional() {
		sandwich.setAdicional(Adicional.TOMATE);
	}
	
	public Sandwich getSandwich() {
		return this.sandwich;
	}

}

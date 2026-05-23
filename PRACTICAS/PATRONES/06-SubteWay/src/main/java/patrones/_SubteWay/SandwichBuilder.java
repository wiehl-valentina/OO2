package patrones._SubteWay;

public interface SandwichBuilder {
	
	public void buildPan();
	public void buildAderezo();
	public void buildPrincipal();
	public void buildAdicional();
	public Sandwich getSandwich(); 
	
}

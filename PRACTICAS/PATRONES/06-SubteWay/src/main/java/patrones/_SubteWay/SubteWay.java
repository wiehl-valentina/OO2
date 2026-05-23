package patrones._SubteWay;

public class SubteWay {
	
	public Sandwich prepararSandwich(SandwichBuilder builder) {
		builder.buildPan();
		builder.buildAderezo();
		builder.buildPrincipal();
		builder.buildAdicional();
		
		return builder.getSandwich(); 
	}

}

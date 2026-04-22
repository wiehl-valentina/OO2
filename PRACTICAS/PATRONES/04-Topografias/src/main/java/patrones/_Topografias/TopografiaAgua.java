package patrones._Topografias;

public class TopografiaAgua implements Topografia {

	public double calcularProporcionAgua() {
		return 1; 
	}
	
	public boolean esIgual(Topografia topografia) {
		return topografia.esAgua(); 
	}
	
	public boolean esAgua() {
		return true; 
	}
	
	public boolean esTierra() {
		return false; 
	}
	
	public boolean esPantano() {
		return false; 
	}
	
	public boolean esIgualAMixta(TopografiaMixta topografia) {
		return false;  
	}

}

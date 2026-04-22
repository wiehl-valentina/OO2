package patrones._Topografias;

public class TopografiaTierra implements Topografia {
	
	public double calcularProporcionAgua() {
		return 0; 
	}
	
	public boolean esIgual(Topografia topografia) {
		return topografia.esTierra();  
	}
	
	public boolean esAgua() {
		return false; 
	}
	
	public boolean esTierra() {
		return true; 
	}
	
	public boolean esPantano() {
		return false; 
	}
	
	public boolean esIgualAMixta(TopografiaMixta topografia) {
		return false;  
	}
	
}

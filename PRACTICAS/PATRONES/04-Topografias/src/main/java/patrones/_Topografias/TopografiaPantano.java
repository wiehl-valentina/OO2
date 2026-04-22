package patrones._Topografias;

public class TopografiaPantano implements Topografia {

	public double calcularProporcionAgua() {
		return 0.7; 
	}
	
	public boolean esIgual(Topografia topografia) {
		return topografia.esPantano(); 
	}
	
	public boolean esPantano() {
		return true; 
	}
	
	public boolean esTierra() {
		return false;
	}
	
	public boolean esAgua() {
		return false; 
	}
	
	public boolean esIgualAMixta(TopografiaMixta topografia) {
		return false;
	}
	
}

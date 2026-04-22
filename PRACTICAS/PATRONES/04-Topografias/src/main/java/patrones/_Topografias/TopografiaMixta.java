package patrones._Topografias;

import java.util.List;

public class TopografiaMixta implements Topografia {
	
	private List<Topografia> topografias; 
	
	public List<Topografia> getTopografias() {
		return topografias;
	}
	
	public void agregarTopografia(Topografia topografia) {
		if (this.topografias.size() <= 4)
			this.topografias.add(topografia); 
		else
			System.out.println("Error: la tipografía ya contiene sus 4 partes correspondientes asignadas");
	}

	public double calcularProporcionAgua() {
		return this.topografias.stream()
		.mapToDouble(topografia -> topografia.calcularProporcionAgua()).sum() / 4; 
	}
	
	public boolean esIgual(Topografia topografia) {
		return topografia.esIgualAMixta(this); 
	}
	
	public boolean esAgua() {
		return false; 
	}
	
	public boolean esTierra () {
		return false; 
	}
	
	public boolean esPantano() {
		return false; 
	}
	
	public boolean esIgualAMixta(TopografiaMixta topografia) {
		return this.topografias.equals(topografia.getTopografias()); 
	}

}

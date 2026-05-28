   package patrones._ArmadoDePCs;

import java.util.List;

public class Computadora {
	
	private List<Componente> componentes;
	
	public void addComponente(Componente componente) {
		this.componentes.add(componente);
	}
	
	public double calcularConsumo() {
		return this.componentes.stream()
		.mapToDouble(componente -> componente.getConsumo())
		.sum();
	}
	
	public double calcularPrecio() {
		return this.componentes.stream()
		.mapToDouble(componente -> componente.getPrecio())
		.sum() * 1.21; 
	}
	
}

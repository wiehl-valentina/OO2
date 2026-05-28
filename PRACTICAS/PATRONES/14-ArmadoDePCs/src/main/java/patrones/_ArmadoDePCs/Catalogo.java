package patrones._ArmadoDePCs;

import java.util.List;

public class Catalogo {
	
	private List<Componente> componentes;
	
	public Componente getComponente(String descripcion) {
		return this.componentes.stream()
		.filter(componente -> componente.getDescripcion().contains(descripcion))
		.findAny().orElse(null);
	}
	
	public void addComponente(Componente componente) {
		this.componentes.add(componente);
	}
	
	public void deleteComponente(Componente componente) {
		this.componentes.remove(componente);
	}

}

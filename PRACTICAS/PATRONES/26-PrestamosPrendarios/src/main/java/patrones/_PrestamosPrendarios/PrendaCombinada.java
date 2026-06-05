package patrones._PrestamosPrendarios;

import java.util.List;

public class PrendaCombinada extends Prenda {
	
	private List<Prenda> componentes;
	
	public PrendaCombinada() {}

	public PrendaCombinada(List<Prenda> componentes) {
		super();
		this.componentes = componentes;
	}
	
	public List<Prenda> getComponentes() {
		return componentes;
	}

	public void setComponentes(List<Prenda> componentes) {
		this.componentes = componentes;
	}
	
	public void addComponente(Prenda componente) {
		this.componentes.add(componente);
	}
	
	public void deleteComponente(Prenda componente) {
		this.componentes.remove(componente);
	}

	@Override
	public double getCoeficienteLiquidez() {
		return 0.5;
	}

	@Override
	public double calcularValor() {
		return this.componentes.stream()
			.mapToDouble(comp -> comp.calcularValor())
			.sum();
	}

}

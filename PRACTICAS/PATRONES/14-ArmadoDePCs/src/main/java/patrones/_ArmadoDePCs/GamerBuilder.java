package patrones._ArmadoDePCs;

public class GamerBuilder extends ComputadoraBuilder {
	
	public GamerBuilder(Catalogo catalogo) {
		super(catalogo);
	}

	@Override
	public void buildProcesador() {
		computadora.addComponente(catalogo.getComponente("Procesador Gamer"));
		computadora.addComponente(catalogo.getComponente("Pad térmico"));
		computadora.addComponente(catalogo.getComponente("Cooler"));
	}

	@Override
	public void buildRAM() {
		computadora.addComponente(catalogo.getComponente("32GB"));
		computadora.addComponente(catalogo.getComponente("32GB"));
	}

	@Override
	public void buildDisco() {
		computadora.addComponente(catalogo.getComponente("SSD 500 GB"));
		computadora.addComponente(catalogo.getComponente("SSD 1 TB"));
	}

	@Override
	public void buildTarjetaGrafica() {
		computadora.addComponente(catalogo.getComponente("RTX 4090"));
	}

	@Override
	public void buildGabinete() {
		computadora.addComponente(catalogo.getComponente("Gabinete Estándar"));
		
		double fuenteRequerida = this.computadora.calcularConsumo() * 1.5;
		computadora.addComponente(catalogo.getComponente("fuente " + fuenteRequerida + " w"));
	}

}

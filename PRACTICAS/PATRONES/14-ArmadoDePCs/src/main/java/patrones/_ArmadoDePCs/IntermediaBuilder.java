 package patrones._ArmadoDePCs;

public class IntermediaBuilder extends ComputadoraBuilder {
	
	private Computadora computadora;
	private Catalogo catalogo;
	
	public IntermediaBuilder(Catalogo catalogo) {
		super(catalogo);
	}

	@Override
	public void buildProcesador() {
		computadora.addComponente(catalogo.getComponente("Procesador Intermedio"));
	}

	@Override
	public void buildRAM() {
		computadora.addComponente(catalogo.getComponente("16GB"));
	}

	@Override
	public void buildDisco() {
		computadora.addComponente(catalogo.getComponente("SSD 500 GB"));
	}

	@Override
	public void buildTarjetaGrafica() {
		computadora.addComponente(catalogo.getComponente("GTX 1650"));
	}

	@Override
	public void buildGabinete() {
		computadora.addComponente(catalogo.getComponente("Gabinete Intermedio"));
		computadora.addComponente(catalogo.getComponente("Fuente 800 w"));
	}

}

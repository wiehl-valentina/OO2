 package patrones._ArmadoDePCs;

public class BasicaBuilder extends ComputadoraBuilder {
	
	private Computadora computadora;
	private Catalogo catalogo;
	
	public BasicaBuilder(Catalogo catalogo) {
		super(catalogo);
	}

	@Override
	public void buildProcesador() {
		computadora.addComponente(catalogo.getComponente("Procesador Básico"));
	}

	@Override
	public void buildRAM() {
		computadora.addComponente(catalogo.getComponente("8GB"));
	}

	@Override
	public void buildDisco() {
		computadora.addComponente(catalogo.getComponente("HDD 500 GB"));
	}

	@Override
	public void buildGabinete() {
		computadora.addComponente(catalogo.getComponente("Gabinete Estándar"));
	}
	
}

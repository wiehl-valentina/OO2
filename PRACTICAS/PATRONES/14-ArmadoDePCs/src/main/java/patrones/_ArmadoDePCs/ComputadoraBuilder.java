package patrones._ArmadoDePCs;

public abstract class ComputadoraBuilder {
	
	protected Computadora computadora;
	protected Catalogo catalogo;
	
	public ComputadoraBuilder(Catalogo catalogo) {
		this.catalogo = catalogo;
		this.computadora = new Computadora();
	}
	
	public abstract void buildProcesador();
	public abstract void buildRAM();
	public abstract void buildDisco();
	public abstract void buildGabinete();
	public void buildTarjetaGrafica() {}
	
	public Computadora getComputadora() {
		return this.computadora;
	}

}

  package patrones._ArmadoDePCs;

public class Vendedor {
	
	public Presupuesto generarPresupuesto(ComputadoraBuilder builder, String nombreCliente) {
		builder.buildProcesador();
		builder.buildRAM();
		builder.buildDisco();
		builder.buildTarjetaGrafica();
		builder.buildGabinete();
		
		return new Presupuesto(nombreCliente, builder.getComputadora());
	}

}

package patrones._PlanesMedicos;

public class CoseguroNulo implements Coseguro {
	
	private static CoseguroNulo instanciaNula = new CoseguroNulo();
	
	private CoseguroNulo() {}

	public static CoseguroNulo getInstancia() {
		return instanciaNula;
	}

	@Override
	public double getDescuento() {
		return 0;
	}

	@Override
	public int getAntiguedad() {
		return 0;
	}

	@Override
	public double getMontoCoberturaViajes() {
		return 0;
	}
	
}

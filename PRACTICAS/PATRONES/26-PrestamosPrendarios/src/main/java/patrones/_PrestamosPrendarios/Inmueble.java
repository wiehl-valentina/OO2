package patrones._PrestamosPrendarios;

public class Inmueble extends Prenda {
	
	private String direccion;
	private int superficie;
	private double costoM2;
	
	public Inmueble(String direccion, int superficie, double costoM2) {
		super();
		this.direccion = direccion;
		this.superficie = superficie;
		this.costoM2 = costoM2;
	}
	
	public String getDireccion() {
		return direccion;
	}

	public int getSuperficie() {
		return superficie;
	}

	public double getCostoM2() {
		return costoM2;
	}

	public void setCostoM2(double costoM2) {
		this.costoM2 = costoM2;
	}

	@Override
	public double getCoeficienteLiquidez() {
		return 0.2;
	}

	@Override
	public double calcularValor() {
		return this.superficie * this.costoM2;
	}

}

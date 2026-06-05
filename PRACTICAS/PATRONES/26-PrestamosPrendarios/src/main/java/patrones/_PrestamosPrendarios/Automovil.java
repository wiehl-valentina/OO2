package patrones._PrestamosPrendarios;

import java.time.LocalDate;

public class Automovil extends Prenda {
	
	private int modelo;
	private int kilometraje;
	private double costo0Km;

	public Automovil(int modelo, int kilometraje, double costo0Km) {
		super();
		this.modelo = modelo;
		this.kilometraje = kilometraje;
		this.costo0Km = costo0Km;
	}

	public int getModelo() {
		return modelo;
	}

	public int getKilometraje() {
		return kilometraje;
	}

	public void setKilometraje(int kilometraje) {
		this.kilometraje = kilometraje;
	}

	public double getCosto0Km() {
		return costo0Km;
	}

	public void setCosto0Km(double costo0Km) {
		this.costo0Km = costo0Km;
	}

	@Override
	public double getCoeficienteLiquidez() {
		return 0.7;
	}

	@Override
	public double calcularValor() {
		return this.costo0Km - this.calcularPerdidaDeValor();
	}
	
	private double calcularPerdidaDeValor() {
		return this.getCosto0Km() * (this.calcularAntiguedad() / 10);
	}

	private int calcularAntiguedad() {
		return LocalDate.now().getYear() - modelo;
	}
	
}

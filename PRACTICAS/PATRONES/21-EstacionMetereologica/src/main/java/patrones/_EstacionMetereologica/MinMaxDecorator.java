package patrones._EstacionMetereologica;

public class MinMaxDecorator extends WeatherDecorator {
	
	public String displayData() {
		return super.displayData() +
				"Mínimo: " + this.calcularMinimo() + 
				"Máximo: " + this.calcularMaximo() + "; ";
	}
	
	private double calcularMinimo() {
		return this.wrappee.getTemperaturas().stream()
			.mapToDouble(t -> t)
			.min().orElse(0);
	}
	
	private double calcularMaximo() {
		return this.wrappee.getTemperaturas().stream()
			.mapToDouble(t -> t)
			.max().orElse(0);
	}

}

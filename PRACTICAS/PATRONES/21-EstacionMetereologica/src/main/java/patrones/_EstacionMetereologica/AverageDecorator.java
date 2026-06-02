package patrones._EstacionMetereologica;

public class AverageDecorator extends WeatherDecorator {
	
	public String displayData() {
		return super.displayData() + 
				"Promedio: " + this.calcularPromedio() + "; ";		
	}
	
	private double calcularPromedio() {
		return this.wrappee.getTemperaturas().stream()
		.mapToDouble(a -> a)
		.average().orElse(0);
	}

}

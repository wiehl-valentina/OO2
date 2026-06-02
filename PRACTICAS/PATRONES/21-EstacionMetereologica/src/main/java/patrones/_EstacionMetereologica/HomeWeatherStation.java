package patrones._EstacionMetereologica;

import java.util.List;

public class HomeWeatherStation implements WeatherData {
	
	private double temperaturaF;
	private double presion;
	private double radiacionSolar;
	private List<Double> historialTemperaturasF;
	
	public HomeWeatherStation(double temperaturaF, double presion, double radiacionSolar,
			List<Double> historiasTemperaturasF) {
		super();
		this.temperaturaF = temperaturaF;
		this.presion = presion;
		this.radiacionSolar = radiacionSolar;
		this.historialTemperaturasF = historiasTemperaturasF;
	}

	@Override
	public double getTemperatura() {
		return this.temperaturaF;
	}

	@Override
	public double getPresion() {
		return this.presion;
	}

	@Override
	public double getRadiacionSolar() {
		return this.radiacionSolar;
	}

	@Override
	public List<Double> getTemperaturas() {
		return this.historialTemperaturasF;
	}

	@Override
	public String displayData() {
		return "Temperatura F: " + this.getTemperatura() + "; " +
				"Presión atmosf: " + this.getPresion() + "; " +
				"Radiación solar: " + this.getRadiacionSolar() + "; ";
	}

}

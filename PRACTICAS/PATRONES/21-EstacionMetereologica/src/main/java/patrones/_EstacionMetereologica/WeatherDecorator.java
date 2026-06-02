package patrones._EstacionMetereologica;

import java.util.List;

public abstract class WeatherDecorator implements WeatherData {
	
	protected WeatherData wrappee;

	@Override
	public double getTemperatura() {
		return this.wrappee.getTemperatura();
	}

	@Override
	public double getPresion() {
		return this.wrappee.getPresion();	}

	@Override
	public double getRadiacionSolar() {
		return this.wrappee.getRadiacionSolar();
	}

	@Override
	public List<Double> getTemperaturas() {
		return this.wrappee.getTemperaturas();
	}

	@Override
	public String displayData() {
		return this.wrappee.displayData();
	}

}

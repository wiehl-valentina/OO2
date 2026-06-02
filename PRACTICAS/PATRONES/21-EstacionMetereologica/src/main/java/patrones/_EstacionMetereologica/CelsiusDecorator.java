package patrones._EstacionMetereologica;

import java.util.List;
import java.util.stream.Collectors;

public class CelsiusDecorator extends WeatherDecorator {

	@Override
	public double getTemperatura() {
		return super.getTemperatura()-32 / 1.8; 
	}

	@Override
	public List<Double> getTemperaturas() {
		return super.getTemperaturas().stream()
		.map(temperatura -> temperatura-32 / 1.8)
		.collect(Collectors.toList());
	}

	@Override
	public String displayData() {
		String fLabel = "Temperatura F: " + Math.round(super.getTemperatura());
		String cLabel = "Temperatura C: " + Math.round(this.getTemperatura());
		
		return super.displayData().replace(fLabel, cLabel);
	}
	
}

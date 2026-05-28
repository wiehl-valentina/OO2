package patrones._LineaDeProduccion;

public class LightMix extends ProcessStep {
	
	public LightMix() {}

	public boolean basicExecute(MixingTank tank) {
		double temp = tank.temperature();
		tank.heatPower(100);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (tank.temperature()-temp == 10) {
			tank.mixerPower(5);
			return true;
		}
		else
			return false;
	}

}

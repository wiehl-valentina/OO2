package patrones.B_LineaDeProduccion;

public class LightMix extends ProcessStep {
	
	public LightMix() {}

	public boolean basicExecute(MixingTank tank) {
		try {
			double temp = tank.temperature();
			tank.heatPower(100);
			Thread.sleep(2000);
			if (tank.temperature()-temp == 10) {
				tank.mixerPower(5);
				return true;
			}
			else
				return false;
		} catch (InterruptedException e) {
			return false;
		}
	}

}

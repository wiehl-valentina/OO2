package patrones._LineaDeProduccion;

public class Purge extends ProcessStep {
	
	public Purge() {}

	protected boolean basicExecute(MixingTank tank) {
		return tank.heatPower(0) 
			&& tank.mixerPower(0)
			&& tank.purge();
	}

}

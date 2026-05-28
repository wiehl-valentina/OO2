package patrones.B_LineaDeProduccion;

public class Purge extends ProcessStep {
	
	public Purge() {}

	protected boolean basicExecute(MixingTank tank) {
		try {
            if (tank.upTo() == 0) {
                return false;
            } else {
                tank.heatPower(0);
                tank.mixerPower(0);
                tank.purge();
                
                // Esperamos los 4 segundos que tarda el desagote
                Thread.sleep(4000);
                
                if (tank.upTo() != 0) {
                    return false;
                }
                return true;
            }
        } catch (InterruptedException e) {
            return false;
        }
	}

}

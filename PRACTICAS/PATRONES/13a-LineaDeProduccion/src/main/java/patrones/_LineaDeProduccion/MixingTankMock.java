package patrones._LineaDeProduccion;

public class MixingTankMock extends MixingTank {

	private int heatPower = -1;
	private int mixerPower = -1;
	private boolean purgeCalled = false;
	
	private boolean heatPowerResponse = true;
	private boolean mixerPowerResponse = true;
	private boolean purgeResponse = true;
	
	public void setHeatPowerResponse(boolean response) { this.heatPowerResponse = response; }
    public void setMixerPowerResponse(boolean response) { this.mixerPowerResponse = response; }
    public void setPurgeResponse(boolean response) { this.purgeResponse = response; }
	
    
    // --- SOBRESCRITURA DE LOS MÉTODOS REALES ---
    @Override
    public boolean heatPower(int percentage) {
        this.heatPower = percentage; // 
        return this.heatPowerResponse;    
    }

    @Override
    public boolean mixerPower(int percentage) {
        this.mixerPower = percentage;
        return this.mixerPowerResponse;
    }

    @Override
    public boolean purge() {
        this.purgeCalled = true;
        return this.purgeResponse;
    }

    @Override
    public double upTo() { return 0; } // No se usa en estos tests
    @Override
    public double temperature() { return 0; } // No se usa en estos tests

    // el test llamará a estos métodos para comprobar si se mandó el mensaje correcto
    public boolean verifyHeatPowerCalledWith(int expected) {
        return this.heatPower == expected;
    }

    public boolean verifyMixerPowerCalledWith(int expected) {
        return this.mixerPower == expected;
    }

    public boolean verifyPurgeWasCalled() {
        return this.purgeCalled;
    }
    
}

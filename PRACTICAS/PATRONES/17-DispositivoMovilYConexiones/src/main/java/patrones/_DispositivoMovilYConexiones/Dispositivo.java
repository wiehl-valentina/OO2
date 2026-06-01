package patrones._DispositivoMovilYConexiones;

public class Dispositivo {
	
	private Display display;
	private Ringer ringer;
	private CRCStrategy crcCalculator;
	private Connection connection;
	
	public Dispositivo(Display display, Ringer ringer, CRCStrategy crcCalculator, Connection connection) {
		this.display = display;
		this.ringer = ringer;
		this.crcCalculator = crcCalculator;
		this.connection = connection;
	}

	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	public Ringer getRinger() {
		return ringer;
	}

	public void setRinger(Ringer ringer) {
		this.ringer = ringer;
	}

	public CRCStrategy getCrcCalculator() {
		return crcCalculator;
	}

	public void setCrcCalculator(CRCStrategy crcCalculator) {
		this.crcCalculator = crcCalculator;
	}

	public String send(String data) {
		int crc = this.crcCalculator.crcFor(data);
		return this.connection.sendData(data, crc);
	}
	
	public String changeConnection(Connection connection) {
		this.connection = connection;
		this.ringer.ring();
		return this.display.showBanner(this.connection.pict());
	}

}

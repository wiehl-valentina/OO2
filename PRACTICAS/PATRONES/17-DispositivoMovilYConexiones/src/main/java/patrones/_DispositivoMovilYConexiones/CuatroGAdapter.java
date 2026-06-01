package patrones._DispositivoMovilYConexiones;

public class CuatroGAdapter implements Connection {
	
	private CuatroGConnection adaptee;
	
	public CuatroGAdapter(CuatroGConnection connection) {
		super();
		this.adaptee = connection;
	}

	@Override
	public String sendData(String data, int crc) {
		return adaptee.transmit(data, crc);
	}

	@Override
	public String pict() {
		return adaptee.symb();
	}

}

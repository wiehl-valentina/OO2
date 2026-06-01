package patrones._DispositivoMovilYConexiones;

public class WifiConn implements Connection {
	
	private String pict = "wifi-symbol";

	@Override
	public String sendData(String data, int crc) {
		return "Enviando via WiFi: " + data + " | CRC: " + crc;
	}

	@Override
	public String pict() {
		return this.pict;
	}

}

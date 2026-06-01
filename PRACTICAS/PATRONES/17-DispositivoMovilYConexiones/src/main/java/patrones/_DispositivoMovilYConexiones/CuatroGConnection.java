package patrones._DispositivoMovilYConexiones;

public class CuatroGConnection {
	
	private String symb = "4G-symbol";
	
	public String transmit(String data, int crc) {
		return "Enviando via 4G: " + data + " | CRC: " + crc;
	}
	
	public String symb() {
		return this.symb;
	}

}

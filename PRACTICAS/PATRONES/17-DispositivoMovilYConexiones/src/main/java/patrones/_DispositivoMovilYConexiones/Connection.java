package patrones._DispositivoMovilYConexiones;

public interface Connection { 
	
	public String sendData(String data, int crc);
	public String pict();

}

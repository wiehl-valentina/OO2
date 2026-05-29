package patrones._Mensajero;

public class Mensajero {
	
	private EstrategiaCifrado cifrador;
	
	public Mensajero(EstrategiaCifrado cifrador) {
		this.cifrador = cifrador;
	}

	public void setCifrador(EstrategiaCifrado cifrador) {
		this.cifrador = cifrador;
	}
	
	public void enviar(String mensaje) {
		this.cifrador.cifrar(mensaje);
	}
	
	public void recibir(String mensaje) {
		this.cifrador.descifrar(mensaje);
	}

}

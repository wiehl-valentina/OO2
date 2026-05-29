package patrones._Mensajero;

public class FeistelAdapter implements EstrategiaCifrado {
	
	private FeistelCipher cifrador;
	
	public FeistelAdapter(String clave) {
		this.cifrador = new FeistelCipher(clave);
	}

	@Override
	public String cifrar(String mensaje) {
		return cifrador.encode(mensaje);
	}

	@Override
	public String descifrar(String mensaje) {
		return cifrador.encode(mensaje);
	}

}

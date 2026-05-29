 package patrones._Mensajero;

public class RC4Adapter implements EstrategiaCifrado {
	
	private RC4 cifrador;
	private String clave;
	
	public RC4Adapter(String clave) {
		this.cifrador = new RC4();
		this.clave = clave;
	}

	@Override
	public String cifrar(String mensaje) {
		return cifrador.encriptar(mensaje, clave);
	}

	@Override
	public String descifrar(String mensaje) {
		return cifrador.desencriptar(mensaje, clave);
	}

}

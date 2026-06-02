package patrones._JuegoDeRol;

public class Arco implements Arma {

	@Override
	public int dañoContra(Armadura armadura) {
		return armadura.recibirDaño(this);
	}

}

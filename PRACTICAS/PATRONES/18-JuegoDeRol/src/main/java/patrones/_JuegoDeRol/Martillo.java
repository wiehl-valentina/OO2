package patrones._JuegoDeRol;

public class Martillo implements Arma {

	@Override
	public int dañoContra(Armadura armadura) {
		return armadura.recibirDaño(this);
	}

}

package patrones._JuegoDeRol;

public class Baston implements Arma {

	@Override
	public int dañoContra(Armadura armadura) {
		return armadura.recibirDaño(this);
	}

}

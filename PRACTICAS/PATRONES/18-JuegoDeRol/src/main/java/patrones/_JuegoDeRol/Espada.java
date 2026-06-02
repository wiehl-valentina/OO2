package patrones._JuegoDeRol;

public class Espada implements Arma {

	@Override
	public int dañoContra(Armadura armadura) {
		return armadura.recibirDaño(this);
	}

}

package patrones._JuegoDeRol;

public class ArmaduraDeHierro implements Armadura {

	@Override
	public int recibirDaño(Espada espada) {
		return 5;
	}

	@Override
	public int recibirDaño(Arco arco) {
		return 3;
	}

	@Override
	public int recibirDaño(Baston baston) {
		return 1;
	}
	
	public int recibirDaño(Martillo martillo) {
		return 8;
	}

}

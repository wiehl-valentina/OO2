package patrones._JuegoDeRol;

public class ArmaduraDeAcero implements Armadura {
	
	public int recibirDaño(Espada espada) {
		return 3;
	}
	
	public int recibirDaño(Arco arco) {
		return 2;
	}
	
	public int recibirDaño(Baston baston) {
		return 1;
	}
	
	public int recibirDaño(Martillo martillo) {
		return 4;
	}
	
}

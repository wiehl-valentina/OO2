package patrones._JuegoDeRol;

public class ArmaduraDeCuero implements Armadura {
	
	public int recibirDaño(Espada espada) {
		return 8;
	}
	
	public int recibirDaño(Arco arco) {
		return 5;
	}
	
	public int recibirDaño(Baston baston) {
		return 2;
	}

}

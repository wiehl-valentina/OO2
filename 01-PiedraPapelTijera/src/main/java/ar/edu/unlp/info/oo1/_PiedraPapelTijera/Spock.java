package ar.edu.unlp.info.oo1._PiedraPapelTijera;

public class Spock implements Opcion {

	public String determinarGanador(Opcion opc) {
		return opc.jugarContraSpock(); 
	}
	
	public String jugarContraPiedra() {
		return "Gana spock"; 
	}
	
	public String jugarContraPapel() {
		return "Gana papel";
	}
	
	public String jugarContraTijera() {
		return "Gana spock";
	}
	
	public String jugarContraLagarto() {
		return "Gana lagarto"; 
	}
	
	public String jugarContraSpock() {
		return "Empate!"; 
	}
	
}

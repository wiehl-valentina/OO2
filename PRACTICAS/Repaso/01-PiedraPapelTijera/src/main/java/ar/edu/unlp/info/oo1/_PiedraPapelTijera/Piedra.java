package ar.edu.unlp.info.oo1._PiedraPapelTijera;

public class Piedra implements Opcion {
	
	public String determinarGanador(Opcion opc) {
		return opc.jugarContraPiedra(); 
	}
	
	public String jugarContraPiedra() {
		return "Empate!"; 
	}
	
	public String jugarContraPapel() {
		return "Gana papel";
	}
	
	public String jugarContraTijera() {
		return "Gana piedra";
	}
	
	public String jugarContraLagarto() {
		return "Gana piedra"; 
	}
	
	public String jugarContraSpock() {
		return "Gana spock"; 
	}
	
}

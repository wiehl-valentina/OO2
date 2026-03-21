package ar.edu.unlp.info.oo1._PiedraPapelTijera;

public class Lagarto implements Opcion {
	
	public String determinarGanador(Opcion opc) {
		return opc.jugarContraLagarto(); 
	}
	
	public String jugarContraPiedra() {
		return "Gana piedra"; 
	}
	
	public String jugarContraPapel() {
		return "Gana lagarto";
	}
	
	public String jugarContraTijera() {
		return "Gana tijera";
	}
	
	public String jugarContraLagarto() {
		return "Empate!"; 
	}
	
	public String jugarContraSpock() {
		return "Gana lagarto"; 
	}
	
}

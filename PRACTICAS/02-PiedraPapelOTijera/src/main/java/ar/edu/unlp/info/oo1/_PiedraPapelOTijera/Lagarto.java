package ar.edu.unlp.info.oo1._PiedraPapelOTijera;

public class Lagarto implements Jugada{
	public String enfrentarPiedra() {
		return "Derrota"; 
	}
	
	public String enfrentarPapel() {
		return "Victoria"; 
	}
	
	public String enfrentarTijera() {
		return "Derrota";
	}
	
	public String enfrentarLagarto() {
		return "Empate";
	}
	
	public String enfrentarSpock() {
		return "Victoria"; 
	}
	
	public String determinarGanador(Jugada otraJugada) {
		return otraJugada.enfrentarLagarto(); 
	}
}

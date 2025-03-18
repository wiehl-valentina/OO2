package ar.edu.unlp.info.oo1._PiedraPapelOTijera;

public class Papel implements Jugada{
	public String enfrentarPiedra() {
		return "Victoria"; 
	}
	
	public String enfrentarPapel() {
		return "Empate"; 
	}
	
	public String enfrentarTijera() {
		return "Derrota";
	}
	
	public String enfrentarLagarto() {
		return "Derrota";
	}
	
	public String enfrentarSpock() {
		return "Victoria"; 
	}
	
	public String determinarGanador(Jugada otraJugada) {
		return otraJugada.enfrentarPapel(); 
	}
}

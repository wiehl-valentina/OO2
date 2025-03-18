package ar.edu.unlp.info.oo1._PiedraPapelOTijera;

public class Spock implements Jugada{
	public String enfrentarPiedra() {
		return "Victoria"; 
	}
	
	public String enfrentarPapel() {
		return "Derrota"; 
	}
	
	public String enfrentarTijera() {
		return "Victoria";
	}
	
	public String enfrentarLagarto() {
		return "Derrota";
	}
	
	public String enfrentarSpock() {
		return "Empate"; 
	}
	
	public String determinarGanador(Jugada otraJugada) {
		return otraJugada.enfrentarSpock(); 
	}
}

package ar.edu.unlp.info.oo1._PiedraPapelOTijera;

public class Jugador {
	private Jugada jugada; 
	
	// CONSTRUCTOR
	public Jugador(Jugada opc) {
		this.jugada = opc; 
	}
	
	// MÉTODOS
	public Jugada getJugada() {
		return this.jugada; 
	}
	
	public String enfrentarJugador(Jugador jugador) {
		return this.jugada.determinarGanador(jugador.getJugada());
	}
}

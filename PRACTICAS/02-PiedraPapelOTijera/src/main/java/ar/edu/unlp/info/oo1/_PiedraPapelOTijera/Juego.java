package ar.edu.unlp.info.oo1._PiedraPapelOTijera;

import java.util.ArrayList;
import java.util.List;

public class Juego {
	private List<Jugador> jugadores; 
	
	// CONSTRUCTOR
	public Juego() {
		this.jugadores = new ArrayList<Jugador>(); 
	}
	
	// MÉTODOS
	public void agregarJugador(Jugador jugador) {
		this.jugadores.add(jugador);
	}
	
	public void eliminarJugador(Jugador jugador) {
		if (this.jugadores.contains(jugador))
			this.jugadores.remove(jugador);
	}
	
	public void enfrentarJugadores(Jugador jugador1, Jugador jugador2) {
		jugador1.enfrentarJugador(jugador2);
	}
}

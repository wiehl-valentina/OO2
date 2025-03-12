package ar.edu.unlp.info.oo1._PiedraPapelOTijera;

public class Jugador {
	private Opcion opcion; 
	
	// CONSTRUCTOR
	public Jugador(Opcion opc) {
		this.opcion = opc; 
	}
	
	// MÉTODOS
	public Opcion getOpcion() {
		return this.opcion; 
	}
	
	public void determinarGanador(Jugador jugador2, Tabla resultados) {
		this.opcion.comparar(jugador2.getOpcion(), resultados);
	}
}

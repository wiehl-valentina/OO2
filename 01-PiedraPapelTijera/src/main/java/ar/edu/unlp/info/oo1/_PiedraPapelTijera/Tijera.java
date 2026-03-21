package ar.edu.unlp.info.oo1._PiedraPapelTijera;

public class Tijera implements Opcion{

	public String determinarGanador(Opcion opc) {
		return opc.jugarContraTijera(); 
	}
	
	public String jugarContraPiedra() {
		return "Gana piedra"; 
	}
	
	public String jugarContraPapel() {
		return "Gana tijera";
	}
	
	public String jugarContraTijera() {
		return "Empate!";
	}
	
	public String jugarContraLagarto() {
		return "Gana tijera"; 
	}
	
	public String jugarContraSpock() {
		return "Gana spock"; 
	}
	
}

package ar.edu.unlp.info.oo1._PiedraPapelTijera;

public class Papel implements Opcion{
	public String determinarGanador(Opcion opc) {
		return opc.jugarContraPapel(); 
	}
	
	public String jugarContraPiedra() {
		return "Gana papel"; 
	}
	
	public String jugarContraPapel() {
		return "Empate!";
	}
	
	public String jugarContraTijera() {
		return "Gana tijera";
	}
	
	public String jugarContraLagarto() {
		return "Gana tijera"; 
	}
	
	public String jugarContraSpock() {
		return "Gana spock"; 
	}
}

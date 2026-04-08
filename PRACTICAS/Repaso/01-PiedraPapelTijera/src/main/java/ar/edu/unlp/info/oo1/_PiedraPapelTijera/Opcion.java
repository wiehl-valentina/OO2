package ar.edu.unlp.info.oo1._PiedraPapelTijera;

public interface Opcion {
	
	public String determinarGanador(Opcion opc); 
	public String jugarContraPiedra();
	public String jugarContraPapel();
	public String jugarContraTijera();
	public String jugarContraLagarto();
	public String jugarContraSpock();
}

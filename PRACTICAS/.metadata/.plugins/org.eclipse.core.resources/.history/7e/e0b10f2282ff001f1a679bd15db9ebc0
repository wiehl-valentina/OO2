package ar.edu.unlp.info.oo1._PiedraPapelOTijera;

public abstract class Opcion {
	protected int index; 
	
	// CONSTRUCTOR 
	public Opcion(int index) {
		this.index = index;
	}
	
	// MÉTODOS
	public int getIndex() {
		return this.index; 
	}
	
	public String comparar(Opcion opc, Tabla resultados) {
		return resultados.getResultado(this.index, opc.getIndex());
	}
}

package ejercicio5._SustanciasQuimicas;

public class Atomo extends ElementoQuimico {
	
	private String nombre; 
	private String simbolo; 
	private int pesoAtomico; 
	private int cargaElectrica; 
	private boolean esMetal;
	
	public String formula() {
		return simbolo; 
	}
	
	public int pesoMolecular() {
		return pesoAtomico; 
	}
	
	public int carga() {
		return cargaElectrica; 
	}
	
	public boolean esMetal() {
		return esMetal; 
	}

}

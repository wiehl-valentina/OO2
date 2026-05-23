package patrones._SustanciasQuimicas;

public class Atomo extends ElementoQuimico {
	
	private String nombre; 
	private String simbolo; 
	private int pesoAtomico; 
	private int carga;
	private boolean esMetal; 
	
	public String formula() {
		return this.simbolo; 
	}
	
	public int pesoMolecular() {
		return this.pesoAtomico; 
	}
	
	public int carga() {
		return this.carga; 
	}
	
	public boolean esValida() {
		return true;
	}
	
	public boolean aportaNoMetal() {
		return !esMetal; 
	}
	
}

package patrones._Topografias;

public interface Topografia {
	
	public double calcularProporcionAgua(); 
	
	public boolean esIgual(Topografia topografia);
	
	public boolean esAgua();

	public boolean esTierra();
	
	public boolean esPantano();
	
	public boolean esIgualAMixta(TopografiaMixta topografia);

}

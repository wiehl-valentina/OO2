package ar.edu.unlp.info.oo1._RedSocial;

public class Retweet implements Post{
	private Tweet origen; 
	
	// CONSTRUCTOR
	public Retweet(Tweet origen) {
		this.origen = origen; 
	}
	
	// MÉTODOS
	public String getTexto() {
		return this.origen.getTexto(); 
	}
}

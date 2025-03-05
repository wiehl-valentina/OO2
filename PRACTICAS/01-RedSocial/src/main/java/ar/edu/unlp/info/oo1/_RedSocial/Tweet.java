package ar.edu.unlp.info.oo1._RedSocial;

public class Tweet implements Post{
	private String texto; 
	
	// CONSTRUCTOR
	public Tweet(String texto) {
		this.texto = texto; 
	}
	
	//MÉTODOS
	public String getTexto() {
		return this.texto; 
	}
}

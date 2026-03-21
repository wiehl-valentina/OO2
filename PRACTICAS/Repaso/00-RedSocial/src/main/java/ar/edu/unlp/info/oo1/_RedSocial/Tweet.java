package ar.edu.unlp.info.oo1._RedSocial;

public class Tweet implements Post{
	
	private String texto; 
	
	public Tweet(String texto) {
		this.texto = texto; 
	}

	public String getTexto() {
		return texto;
	}

}

package ar.edu.unlp.info.oo1.Codigo;

public class Publicacion {
	
	private String texto;
	private int likes;
	   
	public Publicacion(String texto) {
		this.texto = texto;
		this.likes = 0;
	}

	public void darLike() {
		likes++;
	}

	public void darDislike() {
		likes--;
	}

	private int impacto() {
		return likes * 3;
	}

	public int alcance() {
		return impacto() * 10;
	}

}

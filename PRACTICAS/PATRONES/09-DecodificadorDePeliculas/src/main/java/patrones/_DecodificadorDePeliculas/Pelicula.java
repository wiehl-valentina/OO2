package patrones._DecodificadorDePeliculas;

import java.util.*;

public class Pelicula {
	
	private String titulo;
	private int añoEstreno;
	private List<Pelicula> peliculasSimilares;
	private double puntaje;
	
	public Pelicula(String titulo, int añoEstreno, double puntaje) {
		this.titulo = titulo;
		this.añoEstreno = añoEstreno;
		this.puntaje = puntaje;
	}
	
	public Pelicula(String titulo, int añoEstreno, List<Pelicula> peliculasSimilares, double puntaje) {
		this.titulo = titulo;
		this.añoEstreno = añoEstreno;
		this.peliculasSimilares = peliculasSimilares;
		this.puntaje = puntaje;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public int getAñoEstreno() {
		return añoEstreno;
	}
	
	public void setAñoEstreno(int añoEstreno) {
		this.añoEstreno = añoEstreno;
	}
	
	public List<Pelicula> getPeliculasSimilares() {
		return peliculasSimilares;
	}
	
	public void setPeliculasSimilares(List<Pelicula> peliculasSimilares) {
		this.peliculasSimilares = peliculasSimilares;
	}
	
	public double getPuntaje() {
		return puntaje;
	}
	
	public void setPuntaje(double puntaje) {
		this.puntaje = puntaje;
	}
	
	public void addPeliculaSimilar(Pelicula pelicula) {
		this.peliculasSimilares.add(pelicula);
		pelicula.addPeliculaSimilar(this);
	}
	
	

}

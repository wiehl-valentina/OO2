package patrones._DecodificadorDePeliculas;

import java.util.*;

public class Decodificador {
	
	private EstrategiaSugerencia estrategiaSugerencia;
	private List<Pelicula> grillaPeliculas;
	private List<Pelicula> peliculasReproducidas; 
	
	public Decodificador(EstrategiaSugerencia estrategiaSugerencia, List<Pelicula> grillaPeliculas,
			List<Pelicula> peliculasReproducidas) {
		super();
		this.estrategiaSugerencia = estrategiaSugerencia;
		this.grillaPeliculas = grillaPeliculas;
		this.peliculasReproducidas = peliculasReproducidas;
	}

	public void addPeliculaAGrilla(Pelicula pelicula) {
		this.grillaPeliculas.add(pelicula);
	}
	
	public void reproducir(Pelicula pelicula) {
		if (!peliculasReproducidas.contains(pelicula))
			peliculasReproducidas.add(pelicula);
	}

	public void setEstrategiaSugerencia(EstrategiaSugerencia estrategiaSugerencia) {
		this.estrategiaSugerencia = estrategiaSugerencia;
	}

	public List<Pelicula> sugerirPeliculas() {
		return estrategiaSugerencia.sugerir(grillaPeliculas, peliculasReproducidas); 
	}

}

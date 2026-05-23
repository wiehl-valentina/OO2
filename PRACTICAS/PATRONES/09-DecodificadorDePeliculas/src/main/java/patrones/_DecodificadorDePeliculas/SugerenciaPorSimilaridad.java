package patrones._DecodificadorDePeliculas;

import java.util.List;
import java.util.stream.Collectors;

public class SugerenciaPorSimilaridad extends EstrategiaSugerencia {
	
	protected List<Pelicula> ordenarPorEstrategia(List<Pelicula> peliculasDisponibles, List<Pelicula> peliculasVistas) {
		return ordenarDescendente(peliculasDisponibles).stream()
		.filter(pelicula -> esSimilar(pelicula, peliculasVistas))
		.collect(Collectors.toList());
	}
	
	private boolean esSimilar(Pelicula pelicula, List<Pelicula> peliculasVistas) {
		return peliculasVistas.stream()
		.anyMatch(peliculaVista -> peliculaVista.getPeliculasSimilares().contains(pelicula));
	}

}

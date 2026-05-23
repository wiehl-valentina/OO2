package patrones._DecodificadorDePeliculas;

import java.util.List;
import java.util.stream.Collectors;

public abstract class EstrategiaSugerencia {
	
	public List<Pelicula> sugerir(List<Pelicula> grilla, List<Pelicula> peliculasVistas) {
		List<Pelicula> peliculasNoVistas = filtrarVistas(grilla, peliculasVistas);
		
		return ordenarPorEstrategia(peliculasNoVistas, peliculasVistas).stream()
		.limit(3)
		.collect(Collectors.toList());
	}
	
	private List<Pelicula> filtrarVistas(List<Pelicula> grilla, List<Pelicula> peliculasVistas) {
		return grilla.stream()
		.filter(pelicula -> !peliculasVistas.contains(pelicula))
		.collect(Collectors.toList());
	}
	
	protected List<Pelicula> ordenarDescendente(List<Pelicula> peliculasDisponibles) {
		return peliculasDisponibles.stream()
		.sorted((p1, p2) -> Integer.compare(p1.getAñoEstreno(), p2.getAñoEstreno()))
		.collect(Collectors.toList())
		.reversed();
	}
	
	protected abstract List<Pelicula> ordenarPorEstrategia(List<Pelicula> peliculasDisponibles, List<Pelicula> peliculasVistas);
}

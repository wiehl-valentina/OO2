package patrones._DecodificadorDePeliculas;

import java.util.List;
import java.util.stream.Collectors;

public class SugerenciaPorPuntaje extends EstrategiaSugerencia {
	
	protected List<Pelicula> ordenarPorEstrategia(List<Pelicula> peliculasDisponibles, List<Pelicula> peliculasVistas) {
		return peliculasDisponibles.stream()
		.sorted((p1, p2) -> {
			int comparacionPuntaje = Double.compare(p2.getPuntaje(), p1.getPuntaje());
			if (comparacionPuntaje == 0)
				return Integer.compare(p2.getAñoEstreno(), p1.getAñoEstreno());
			return comparacionPuntaje;
		})
		.collect(Collectors.toList());
	}
	
}

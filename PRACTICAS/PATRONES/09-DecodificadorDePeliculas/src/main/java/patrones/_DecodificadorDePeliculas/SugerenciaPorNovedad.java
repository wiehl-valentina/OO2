package patrones._DecodificadorDePeliculas;

import java.util.*;

public class SugerenciaPorNovedad extends EstrategiaSugerencia {
	
	protected List<Pelicula> ordenarPorEstrategia(List<Pelicula> peliculasDisponibles, List<Pelicula> peliculasVistas) {
		return ordenarDescendente(peliculasDisponibles);
	}

}

package patrones._JuegoDeRol;

import java.util.List;

public class Juego {
	
	private PersonajeBuilder builder;
	private List<Personaje> personajes;
	
	public Juego(PersonajeBuilder builder) {
		super();
		this.builder = builder;
	}
	
	public void setBuilder(PersonajeBuilder builder) {
		this.builder = builder;
	}

	public List<Personaje> getPersonajes() {
		return personajes;
	}

	public Personaje construirPersonaje(String nombre) {
		this.builder.buildArma();
		this.builder.buildArmadura();
		this.builder.buildHabilidad();
		return builder.getPersonaje();
	}
	
	public void addPersonaje(String nombre) {
		this.personajes.add(construirPersonaje(nombre));
	}
	
}

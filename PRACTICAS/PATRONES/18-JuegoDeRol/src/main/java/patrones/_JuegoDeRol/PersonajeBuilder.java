package patrones._JuegoDeRol;

public abstract class PersonajeBuilder {
	
	protected Personaje personaje;
	
	public abstract void buildArmadura();
	public abstract void buildArma();
	public abstract void buildHabilidad();
	
	public void crearPersonaje(String nombre) {
		this.personaje = new Personaje(nombre);
	}
	
	public Personaje getPersonaje() {
		return this.personaje;
	}

}

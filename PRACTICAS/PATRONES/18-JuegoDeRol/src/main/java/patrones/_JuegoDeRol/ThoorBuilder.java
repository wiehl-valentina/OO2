package patrones._JuegoDeRol;

public class ThoorBuilder extends PersonajeBuilder {

	@Override
	public void buildArmadura() {
		this.personaje.setArmadura(new ArmaduraDeHierro());
	}

	@Override
	public void buildArma() {
		this.personaje.setArma(new Martillo());
	}

	@Override
	public void buildHabilidad() {
		this.personaje.addHabilidad(Habilidad.LANZA_RAYOS);
		this.personaje.addHabilidad(Habilidad.A_DISTANCIA);
	}

}

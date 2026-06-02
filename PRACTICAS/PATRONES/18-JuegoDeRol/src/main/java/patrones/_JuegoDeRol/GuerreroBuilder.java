package patrones._JuegoDeRol;

public class GuerreroBuilder extends PersonajeBuilder {

	@Override
	public void buildArmadura() {
		this.personaje.setArmadura(new ArmaduraDeAcero());
	}

	@Override
	public void buildArma() {
		this.personaje.setArma(new Espada());
	}

	@Override
	public void buildHabilidad() {
		this.personaje.addHabilidad(Habilidad.CUERPO_A_CUERPO);
	}

}

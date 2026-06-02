package patrones._JuegoDeRol;

public class ArqueroBuilder extends PersonajeBuilder {

	@Override
	public void buildArmadura() {
		this.personaje.setArmadura(new ArmaduraDeCuero());
	}

	@Override
	public void buildArma() {
		this.personaje.setArma(new Arco());
	}

	@Override
	public void buildHabilidad() {
		this.personaje.addHabilidad(Habilidad.ARQUERIA);
	}

}

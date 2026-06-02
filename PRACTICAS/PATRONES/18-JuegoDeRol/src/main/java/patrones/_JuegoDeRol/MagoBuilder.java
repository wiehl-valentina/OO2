package patrones._JuegoDeRol;

public class MagoBuilder extends PersonajeBuilder {

	@Override
	public void buildArmadura() {
		this.personaje.setArmadura(new ArmaduraDeHierro());
	}

	@Override
	public void buildArma() {
		this.personaje.setArma(new Baston());
	}

	@Override
	public void buildHabilidad() {
		this.personaje.addHabilidad(Habilidad.MAGIA);
		this.personaje.addHabilidad(Habilidad.A_DISTANCIA);
	}

}

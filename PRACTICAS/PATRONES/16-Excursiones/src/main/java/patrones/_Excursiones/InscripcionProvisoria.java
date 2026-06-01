package patrones._Excursiones;

public class InscripcionProvisoria extends EstadoInscripcion {

	public InscripcionProvisoria(Inscripcion inscripcion) {
		super(inscripcion);
	}
	
	@Override
	public void reaccionarACupoMinimo() {
		this.inscripcion.setEstado(new InscripcionDefinitiva(inscripcion));
	}

}

package patrones._Excursiones;

public abstract class EstadoInscripcion {
	
	protected Inscripcion inscripcion;

	public EstadoInscripcion(Inscripcion inscripcion) {
		this.inscripcion = inscripcion;
	}
	
	public void reaccionarACupoMinimo() {}

}

package patrones._Excursiones;

public abstract class EstadoExcursion {
	
	protected Excursion excursion;

	public EstadoExcursion(Excursion excursion) {
		this.excursion = excursion;
	}
	
	public String obtenerInformacion() {
		return excursion.getNombre() + " | " + excursion.getCosto() + 
		" | " + excursion.getFechaInicio() + " | " + excursion.getFechaFin()
		+ " | " + excursion.getPuntoEncuentro();
	}
	
	public void inscribir(Usuario usuario) {
		excursion.getInscripciones().add(new Inscripcion(usuario, this.excursion));
	}

}

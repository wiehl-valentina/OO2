package patrones._Excursiones;

public class Inscripcion {
	
	private Usuario usuario;
	private EstadoInscripcion estado;
	private Excursion excursion;
	
	public Inscripcion(Usuario usuario, Excursion excursion) {
		this.usuario = usuario;
		this.estado = new InscripcionProvisoria(this);
		this.excursion = excursion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public EstadoInscripcion getEstado() {
		return estado;
	}

	public void setEstado(EstadoInscripcion estado) {
		this.estado = estado;
	}
	
	public Excursion getExcursion() {
		return excursion;
	}

	public String getUserEmail() {
		return usuario.getEmail();
	}
	
	public void reaccionarACupoMinimo() {
		estado.reaccionarACupoMinimo();
	}

}

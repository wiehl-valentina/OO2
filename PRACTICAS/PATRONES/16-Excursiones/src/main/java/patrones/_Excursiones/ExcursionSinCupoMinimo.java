package patrones._Excursiones;

public class ExcursionSinCupoMinimo extends EstadoExcursion {
	
	public ExcursionSinCupoMinimo(Excursion excursion) {
		super(excursion);
	}

	public String obtenerInformacion() {
		return super.obtenerInformacion() + " | " + excursion.usuariosFaltantesParaCupoMinimo();
	}
	
	public void inscribir(Usuario usuario) {
		super.inscribir(usuario);
		
		if (excursion.cumpleCupoMinimo()) {
			excursion.setEstado(new ExcursionConCupoMinimo(this.excursion));
		}
	}

}

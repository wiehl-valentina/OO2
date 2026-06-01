package patrones._Excursiones;

public class ExcursionConCupoMinimo extends EstadoExcursion {

	public ExcursionConCupoMinimo(Excursion excursion) {
		super(excursion);
	}
	
	public String obtenerInformacion() {
		return super.obtenerInformacion() + " | " + excursion.listarEmails() + excursion.usuariosFaltantesParaCupoMaximo();
	}
	
	public void inscribir(Usuario usuario) {
		super.inscribir(usuario);
		
		if (excursion.cumpleCupoMaximo()) {
			excursion.setEstado(new ExcursionConCupoMaximo(excursion));
			excursion.notificarCupoAlcanzado();
		}
	}
	

}

package patrones._Excursiones;

public class ExcursionConCupoMaximo extends EstadoExcursion {

	public ExcursionConCupoMaximo(Excursion excursion) {
		super(excursion);
	}
	
	@Override
	public void inscribir(Usuario usuario) {
		excursion.agregarUsuarioListaDeEspera(new Inscripcion(usuario, this.excursion));
	}
	

}

package patrones._Excursiones;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Excursion {
	
	private String nombre;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String puntoEncuentro;
	private double costo;
	private int cupoMinimo;
	private int cupoMaximo;
	private EstadoExcursion estado;
	private List<Inscripcion> inscripciones;
	private List<Inscripcion> listaDeEspera;
	
	public Excursion(String nombre, LocalDate fechaInicio, LocalDate fechaFin, String puntoEncuentro, double costo,
			int cupoMinimo, int cupoMaximo) {
		super();
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.puntoEncuentro = puntoEncuentro;
		this.costo = costo;
		this.cupoMinimo = cupoMinimo;
		this.cupoMaximo = cupoMaximo;
		this.inscripciones = new LinkedList<Inscripcion>();
		this.listaDeEspera = new LinkedList<Inscripcion>();
	}
	
	public String getNombre() {
		return nombre;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public String getPuntoEncuentro() {
		return puntoEncuentro;
	}

	public double getCosto() {
		return costo;
	}

	public int getCupoMinimo() {
		return cupoMinimo;
	}

	public int getCupoMaximo() {
		return cupoMaximo;
	}

	public EstadoExcursion getEstado() {
		return estado;
	}

	public List<Inscripcion> getInscripciones() {
		return inscripciones;
	}

	public List<Inscripcion> getListaDeEspera() {
		return listaDeEspera;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	public void setEstado(EstadoExcursion estado) {
		this.estado = estado;
	}

	public String obtenerInformacion() {
		return estado.obtenerInformacion();
	}
	
	public void inscribir(Usuario usuario) {
		estado.inscribir(usuario);
	}
	
	public boolean cumpleCupoMaximo() {
		return this.inscripciones.size() == this.cupoMaximo;
	}
	
	public boolean cumpleCupoMinimo() {
		return this.inscripciones.size() == this.cupoMinimo;
	}
	
	public String listarEmails() {
		return this.inscripciones.stream()
		.map(inscripcion -> inscripcion.getUserEmail())
		.toString();
	}
	
	public int usuariosFaltantesParaCupoMinimo() {
		return this.cupoMinimo - inscripciones.size();
	}
	
	public int usuariosFaltantesParaCupoMaximo() {
		return this.cupoMaximo - inscripciones.size();
	}
	
	public void notificarCupoAlcanzado() {
		for (Inscripcion inscripcion : this.inscripciones)
			inscripcion.reaccionarACupoMinimo();
	}
	
	public void agregarUsuarioListaDeEspera(Inscripcion inscripcion) {
		this.listaDeEspera.add(inscripcion);
	}
	

}

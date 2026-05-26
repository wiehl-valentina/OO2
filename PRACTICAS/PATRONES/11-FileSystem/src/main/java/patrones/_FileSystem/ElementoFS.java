package patrones._FileSystem;

import java.time.LocalDate;
import java.util.List;

public abstract class ElementoFS {
	
	protected String nombre;
	protected LocalDate fechaDeCreacion;
	
	public ElementoFS(String nombre, LocalDate fechaDeCreacion) {
		super();
		this.nombre = nombre;
		this.fechaDeCreacion = fechaDeCreacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaDeCreacion() {
		return fechaDeCreacion;
	}

	public abstract double calcularTamaño();
	
	public abstract Archivo archivoMasGrande();
	
	public abstract Archivo archivoMasNuevo();
	
	public abstract ElementoFS buscar(String nombre);
	
	public abstract List<ElementoFS> buscarTodos(String nombre);
	
	protected abstract String listadoDeContenido(String pathPadre);
	

}

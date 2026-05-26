package patrones._FileSystem;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Archivo extends ElementoFS {

	private double tamaño;
	
	public Archivo(String nombre, LocalDate fechaDeCreacion, double tamaño) {
		super(nombre, fechaDeCreacion);
		this.tamaño = tamaño;
	}

	public double getTamaño() {
		return tamaño;
	}

	public void setTamaño(double tamaño) {
		this.tamaño = tamaño;
	}

	@Override
	public double calcularTamaño() {
		return this.tamaño;
	}

	@Override
	public Archivo archivoMasGrande() {
		return this;
	}

	@Override
	public Archivo archivoMasNuevo() {
		return this;
	}

	@Override
	public ElementoFS buscar(String nombre) {
		return (this.nombre == nombre) ? this : null;
	}

	@Override
	public List<ElementoFS> buscarTodos(String nombre) {
		List<ElementoFS> lista = new LinkedList<ElementoFS>();
		if (this.nombre == nombre) {
			lista.add(this);
		}
		return lista;
	}

	@Override
	protected String listadoDeContenido(String pathPadre) {
		return pathPadre + "/" + this.nombre + "\n";
	}
	
	
	
	

}

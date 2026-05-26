package patrones._FileSystem;

import java.util.List;

public class FileSystem {
	
	private Directorio directorioRaiz;
	
	public FileSystem(Directorio directorioRaiz) {
		super();
		this.directorioRaiz = directorioRaiz;
	}

	public double tamañoTotalOcupado() {
		return directorioRaiz.calcularTamaño();
	}
	
	public Archivo archivoMasGrande() {
		return directorioRaiz.archivoMasGrande();
	}
	
	public Archivo archivoMasNuevo() {
		return directorioRaiz.archivoMasNuevo();
	}
	
	public ElementoFS buscar(String nombre) {
		return directorioRaiz.buscar(nombre);
	}
	
	public List<ElementoFS> buscarTodos(String nombre) {
		return directorioRaiz.buscarTodos(nombre);
	}
	
	public String listadoDeContenido() {
		return directorioRaiz.listadoDeContenido("");
	}

}

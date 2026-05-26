package patrones._FileSystem;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Directorio extends ElementoFS {

	private List<ElementoFS> contenido;
	public static int TAMAÑO_INICIAL = 32000;

	public Directorio(String nombre, LocalDate fechaDeCreacion) {
		super(nombre, fechaDeCreacion);
		this.contenido = new LinkedList<ElementoFS>();
	}

	public List<ElementoFS> getContenido() {
		return contenido;
	}

	public void setContenido(List<ElementoFS> contenido) {
		this.contenido = contenido;
	}
	
	public void addElemento(ElementoFS elemento) {
		this.contenido.add(elemento);
	}
	
	public void deleteElemento(ElementoFS elemento) {
		this.contenido.remove(elemento);
	}

	@Override
	public double calcularTamaño() {
		return TAMAÑO_INICIAL + 
		this.contenido.stream()
		.mapToDouble(elem -> elem.calcularTamaño())
		.sum(); 
	}

	@Override
	public Archivo archivoMasGrande() {
		return this.contenido.stream()
		.map(elem -> elem.archivoMasGrande())
		.filter(archivo -> archivo != null)
		.max((a1, a2) -> Double.compare(a1.calcularTamaño(), a2.calcularTamaño()))
		.orElse(null);
	}

	@Override
	public Archivo archivoMasNuevo() {
		return this.contenido.stream()
		.map(elem -> elem.archivoMasGrande())
		.filter(archivo -> archivo != null)
		.min((a1, a2) -> a1.getFechaDeCreacion().compareTo(a2.getFechaDeCreacion()))
		.orElse(null);
	}

	@Override
	public ElementoFS buscar(String nombre) {
		if (this.nombre.equals(nombre))
			return this;
		
		return this.contenido.stream()
		.map(elem -> elem.buscar(nombre))
		.filter(resultado -> resultado != null)
		.findFirst()
		.orElse(null);
	}

	@Override
	public List<ElementoFS> buscarTodos(String nombre) {
		List<ElementoFS> resultado = new LinkedList<ElementoFS>();
		if (this.nombre.equals(nombre))
			resultado.add(this);
		
		List<ElementoFS> resultadosHijos = this.contenido.stream()
		.flatMap(elem -> elem.buscarTodos(nombre).stream())
		.collect(Collectors.toList());
		
		resultado.addAll(resultadosHijos);
		return resultado;
	}

	@Override
	protected String listadoDeContenido(String pathPadre) {
		String pathActual = pathPadre + "/" + this.nombre;
        StringBuilder builder = new StringBuilder(pathActual + "\n");
        
        for (ElementoFS elemento : contenido) {
            builder.append(elemento.listadoDeContenido(pathActual));
        }
        return builder.toString();
	}
	
	
	
}

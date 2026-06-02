package patrones._FileManager;

import java.time.LocalDate;

public class FileOO2 implements FileItem {
	
	private String nombre;
	private String extension;
	private double tamaño;
	private LocalDate fechaCreacion;
	private LocalDate fechaModificacion;
	private String permisos;

	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public String getExtension() {
		return this.extension;
	}

	@Override
	public double getTamaño() {
		return this.tamaño;
	}

	@Override
	public LocalDate getFechaCreacion() {
		return this.fechaCreacion;
	}

	@Override
	public LocalDate getFechaModificacion() {
		return this.fechaModificacion;
	}

	@Override
	public String getPermisos() {
		return this.permisos;
	}

	@Override
	public String prettyPrint() {
		return this.nombre;
	}

}

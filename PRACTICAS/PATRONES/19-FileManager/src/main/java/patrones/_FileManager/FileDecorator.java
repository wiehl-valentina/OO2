package patrones._FileManager;

import java.time.LocalDate;

public abstract class FileDecorator implements FileItem {

	protected FileItem wrappee;
	
	public FileDecorator(FileItem wrappee) {
		super();
		this.wrappee = wrappee;
	}

	@Override
	public String getNombre() {
		return this.wrappee.getNombre();
	}

	@Override
	public String getExtension() {
		return this.wrappee.getExtension();
	}

	@Override
	public double getTamaño() {
		return this.wrappee.getTamaño();
	}

	@Override
	public LocalDate getFechaCreacion() {
		return this.wrappee.getFechaCreacion();
	}

	@Override
	public LocalDate getFechaModificacion() {
		return this.wrappee.getFechaModificacion();
	}

	@Override
	public String getPermisos() {
		return this.wrappee.getPermisos();
	}

	@Override
	public String prettyPrint() {
		return this.wrappee.prettyPrint();
	}

}

package patrones._FileManager;

import java.time.LocalDate;

public interface FileItem {
	
	public String getNombre();
	public String getExtension();
	public double getTamaño();
	public LocalDate getFechaCreacion();
	public LocalDate getFechaModificacion();
	public String getPermisos();
	public String prettyPrint();

}

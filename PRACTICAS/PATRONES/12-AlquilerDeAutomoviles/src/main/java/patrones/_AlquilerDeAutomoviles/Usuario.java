package patrones._AlquilerDeAutomoviles;

import java.util.*;

public class Usuario {
	
	private String nombre;
	private List<AutoEnAlquiler> autosEnAlquiler;
	
	public Usuario(String nombre) {
		this.nombre = nombre;
		this.autosEnAlquiler = new LinkedList<AutoEnAlquiler>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<AutoEnAlquiler> getAutosEnAlquiler() {
		return autosEnAlquiler;
	}
	
}

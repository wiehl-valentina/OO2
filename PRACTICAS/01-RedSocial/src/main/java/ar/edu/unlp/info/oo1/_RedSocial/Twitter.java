package ar.edu.unlp.info.oo1._RedSocial;

import java.util.ArrayList;
import java.util.List;

public class Twitter {
	private List<Usuario> usuarios; 
	
	// CONSTRUCTOR
	public Twitter() {
		this.usuarios = new ArrayList<Usuario>(); 
	}
	
	// MÉTODOS
	public List<Usuario> getUsuarios() {
		return this.usuarios; 
	}
	
	public void crearUsuario(String screenName) {
		if (!this.chequearExistencia(screenName)) {
			Usuario user = new Usuario(screenName); 
			this.usuarios.add(user);
		}
	}
	
	public void eliminarUsuario(Usuario user) {
		user.eliminarTodo();
		this.usuarios.remove(user);
	}
	
	private boolean chequearExistencia(String screenName) {
		return this.usuarios.stream()
				.anyMatch(usuario -> usuario.getScreenName() == screenName);
	}
}

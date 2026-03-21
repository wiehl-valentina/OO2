package ar.edu.unlp.info.oo1._RedSocial;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Twitter {

	private List<User> usuarios; 
	
	public Twitter() {
		usuarios = new LinkedList<User>(); 
	}
	
	public void crearUsuario() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese su nombre de usuario:");
		String name = sc.nextLine(); 
		
		if (this.existeUsuario(name))
			System.out.println("El nombre de usuario ya se encuentra registrado");
		else {
			User newUser = new User(name);
			usuarios.add(newUser);
		}
		
		sc.close();
	}
	
	public void eliminarUsuario(User usuario) {
		if (this.existeUsuario(usuario.getScreenName())) {
			usuario.eliminarTweets();
			usuarios.remove(usuario);
		}
	}
	
	public List<User> getUsuarios() {
		return usuarios;
	}
	
	private boolean existeUsuario(String name) {
		return usuarios.stream().anyMatch(user -> user.chequearNombre(name)); 
	}
	
}

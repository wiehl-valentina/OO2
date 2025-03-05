package ar.edu.unlp.info.oo1._RedSocial;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String screenName; 
	private List<Post> posts;
	
	// CONSTRUCTOR
	public Usuario(String screenName) {
		this.screenName = screenName; 
		this.posts = new ArrayList<Post>(); 
	}
	
	// MÉTODOS 
	public String getScreenName() {
		return this.screenName; 
	}
	
	public void crearTweet(String texto) {
		if (texto.length() > 0 && texto.length() <= 280) {
			Tweet newTweet = new Tweet(texto);
			this.posts.add(newTweet);
		}
		else {
			System.out.println("La longitud del tweet es inválida.");
		}
	}
	
	public void hacerRetweet(Tweet tweet) {
		this.posts.add(tweet);
	}
	
	public void eliminarTweet(Tweet tweet) {
		this.posts.remove(tweet);
	}
	
	public void eliminarTodo() {
		if (!this.posts.isEmpty()) 
			this.posts.clear();
	}
}

package ar.edu.unlp.info.oo1._RedSocial;

import java.util.LinkedList;
import java.util.List;

public class User {

	private String screenName; 
	private List<Post> tweets; 
	
	public User(String name) {
		tweets = new LinkedList<Post>(); 
		screenName = name; 
	}
	
	public String getScreenName() {
		return screenName;
	}
	
	public List<Post> getPosts() {
		return tweets;
	}

	public void twittear(String texto) {
		if (this.validarTexto(texto)) {
			Tweet newTweet = new Tweet(texto); 
			tweets.add(newTweet); 
		} 
		else {
			System.out.println("El texto debe tener a lo sumo 280 caracteres.");
		}
	}
	
	public void eliminarTweets() {
		tweets.clear(); 
	}
	
	public boolean chequearNombre(String username) {
		return (this.screenName == username);
	}
	
	private boolean validarTexto(String texto) {
		return (texto.length() > 0 && texto.length() <= 280);
	}
	
	// puede hacerse retweet de un retweet?? o el tipo del parámetro debería ser Tweet
	public void retweetear(Post tweet) {
		Retweet newRetweet = new Retweet(tweet); 
		this.tweets.add(newRetweet); 
		tweets.add(newRetweet);
	}

}

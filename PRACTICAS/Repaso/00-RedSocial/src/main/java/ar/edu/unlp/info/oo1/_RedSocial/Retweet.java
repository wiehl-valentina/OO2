package ar.edu.unlp.info.oo1._RedSocial;

public class Retweet implements Post{
	
	private Post tweetOriginal; 
	
	public Retweet(Post tweetOriginal) {
		this.tweetOriginal = tweetOriginal; 
	}

	public Post getTweetOriginal() {
		return tweetOriginal;
	}

}

package patrones._MediaPlayer;

import java.util.*;
public class MediaPlayer {
	
	private List<Media> media; 
	
	public void play() {
		media.stream()
		.forEach(piece -> piece.play());
	}

}



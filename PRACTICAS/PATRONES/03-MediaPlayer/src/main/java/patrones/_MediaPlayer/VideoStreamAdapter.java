package patrones._MediaPlayer;

public class VideoStreamAdapter extends Media {

	private VideoStream videoStreamer; 
	
	public VideoStreamAdapter(VideoStream videoStreamer) {
		super();
		this.videoStreamer = videoStreamer;
	}

	public void play() {
		videoStreamer.reproduce();
	}
	
}

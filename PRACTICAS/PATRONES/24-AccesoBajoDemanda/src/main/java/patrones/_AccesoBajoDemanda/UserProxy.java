package patrones._AccesoBajoDemanda;

import java.util.List;

public class UserProxy implements PersistableUser {
	
	private User realUser;
	private PostRepository postRepository;
	private List<Post> posts;
	
	public UserProxy(User realUser, PostRepository postRepository) {
		this.realUser = realUser;
		this.postRepository = postRepository;
	}

	@Override
	public String getUsername() {
		return this.realUser.getUsername();
	}

	@Override
	public String getEmail() {
		return this.realUser.getEmail();
	}

	@Override
	public List<Post> getPosts() {
		if (this.posts == null)
			this.posts = this.postRepository.findPostsByUsername(this.getUsername());
		return this.posts;
	}

}

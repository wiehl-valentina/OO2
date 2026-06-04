package patrones._AccesoBajoDemanda;

import java.util.List;

public interface PersistableUser {

	public String getUsername();

	public String getEmail();

	public List<Post> getPosts();

}

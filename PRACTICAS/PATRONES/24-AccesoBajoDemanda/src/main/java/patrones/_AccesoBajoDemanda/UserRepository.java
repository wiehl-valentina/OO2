package patrones._AccesoBajoDemanda;

import java.io.FileReader;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class UserRepository {
	
	private PostRepository postRepository;
	
	public UserRepository(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@SuppressWarnings("unchecked")
	public PersistableUser findUserByUsername(String aUsername) {
		JSONParser parser = new JSONParser();
		try {
			List<JSONObject> usersData = (List<JSONObject>) parser.parse(new FileReader("users.json"));
			return usersData.stream()
				.filter(userData -> userData.get("username").equals(aUsername)).findFirst()
				.map(userData -> {
					User realUser = new User((String) userData.get("username"), (String) userData.get("email"));
					return new UserProxy(realUser, this.postRepository);
				})
				.orElse(null);
		} catch (Exception e) {
			return null;
		}
	}

}

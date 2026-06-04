package patrones._AccesoBajoDemanda;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import patrones._AccesoBajoDemanda.PersistableUser;
import patrones._AccesoBajoDemanda.UserRepository;

public class UserRepositoryTest {

	@Test
	public void testFindUserByUsername() {
		UserRepository userRepository = new UserRepository(new PostRepository());
		
		PersistableUser user = userRepository.findUserByUsername("john_doe");
		assertEquals("john_doe", user.getUsername());
		assertEquals("john.doe@example.com", user.getEmail());

		// Incluir estas condiciones en el test final
		assertEquals(1, user.getPosts().size());
		assertTrue(user.getPosts().stream()
		.anyMatch(post -> post.getText().equals("¡Acabo de publicar mi primer post!")));
	}

}

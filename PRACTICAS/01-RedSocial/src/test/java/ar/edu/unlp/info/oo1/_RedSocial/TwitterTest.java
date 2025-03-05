package ar.edu.unlp.info.oo1._RedSocial;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TwitterTest {
	private Twitter twitter; 
	
	@BeforeEach
	void setUp() {
		this.twitter = new Twitter();
	}
	
	@Test
	void testCrearUsuario() {
		// crear usuario con screenname válido
		this.twitter.crearUsuario("valen");
		assertEquals(1, this.twitter.getUsuarios().size());
		// crear usuario con screenname en uso
		this.twitter.crearUsuario("valen");
		assertEquals(1, this.twitter.getUsuarios().size());
	}
}

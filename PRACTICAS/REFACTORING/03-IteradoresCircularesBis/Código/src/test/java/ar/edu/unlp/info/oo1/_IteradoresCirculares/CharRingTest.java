package ar.edu.unlp.info.oo1._IteradoresCirculares;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CharRingTest {
	
	CharRing ring;
	
	@BeforeEach
	void setUp() throws Exception{
		ring = new CharRing("Hola");
	}

	@Test
	void testNextReturnsCharactersInOrder() {
		assertEquals('H', ring.next());
		assertEquals('o', ring.next());
		assertEquals('l', ring.next());
		assertEquals('a', ring.next());
	}
	
	@Test
	void testCircularBehavior() {
		ring.next(); // H
		ring.next(); // o
		ring.next(); // l
		ring.next(); // a
		assertEquals('H', ring.next());
	}

}

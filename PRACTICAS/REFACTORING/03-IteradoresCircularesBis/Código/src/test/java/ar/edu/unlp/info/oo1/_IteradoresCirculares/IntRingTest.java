package ar.edu.unlp.info.oo1._IteradoresCirculares;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntRingTest {
	
	IntRing ring; 

	@BeforeEach
	void setUp() throws Exception {
		ring = new IntRing(new int[] {1,2,3});
	}

	@Test
	void testNextReturnsNumbersInOrder() {
		assertEquals(1, ring.next());
		assertEquals(2, ring.next());
		assertEquals(3, ring.next());
	}
	
	@Test
	void testCircularBehavior() {
		ring.next();
		ring.next();
		ring.next();
		assertEquals(1, ring.next());
	}

}

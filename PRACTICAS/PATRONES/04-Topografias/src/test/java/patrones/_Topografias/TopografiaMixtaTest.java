package patrones._Topografias;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TopografiaMixtaTest {
	
	private TopografiaMixta topografia1, topografia2; 
	
	@BeforeEach 
	void setUp() {
		topografia1 = new TopografiaMixta();
		topografia1.agregarTopografia(new TopografiaAgua());
		topografia1.agregarTopografia(new TopografiaTierra());
		topografia1.agregarTopografia(new TopografiaTierra());
		topografia1.agregarTopografia(new TopografiaAgua());
		
		topografia2 = new TopografiaMixta(); 
		topografia2.agregarTopografia(new TopografiaAgua());
		topografia2.agregarTopografia(new TopografiaTierra());
		topografia2.agregarTopografia(new TopografiaTierra());
		topografia2.agregarTopografia(topografia1);
	}

	@Test
	void test() {
		
	}

}

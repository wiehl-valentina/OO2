package patrones._CalculoDeSueldos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpleadoConCargasFamiliaresTest {
	
	private EmpleadoConCargasFamiliares casadoConHijosTemporario, casadoSinHijosTemporario, solteroConHijosTemporario, solteroSinHijosTemporario;
	private EmpleadoConCargasFamiliares casadoConHijosPlanta, casadoSinHijosPlanta, solteroConHijosPlanta, solteroSinHijosPlanta;

	
	@BeforeEach
	void setUp() throws Exception {
		casadoConHijosTemporario = new EmpleadoTemporario(2, true, 6);
		casadoSinHijosTemporario = new EmpleadoTemporario(0, true, 6); 
		solteroConHijosTemporario = new EmpleadoTemporario(2, false, 6);
		solteroSinHijosTemporario = new EmpleadoTemporario(0, false, 6); 
		casadoConHijosPlanta = new EmpleadoPlanta(2, true, 5);
		casadoSinHijosPlanta = new EmpleadoPlanta(0, true, 5); 
		solteroConHijosPlanta = new EmpleadoPlanta(2, false, 5); 
		solteroSinHijosPlanta = new EmpleadoPlanta(0, false, 5); 
	}

	@Test
	void testSueldoTemporarios() {
		assertEquals(27516, casadoConHijosTemporario.sueldo());
		assertEquals(23716, casadoSinHijosTemporario.sueldo());
		assertEquals(22766, solteroConHijosTemporario.sueldo());
		assertEquals(18966, solteroSinHijosTemporario.sueldo()); 
	}
	
	@Test
	void testSueldoPlanta() {
		assertEquals(61550, casadoConHijosPlanta.sueldo());
		assertEquals(57750, casadoSinHijosPlanta.sueldo());
		assertEquals(56800, solteroConHijosPlanta.sueldo());
		assertEquals(53000, solteroSinHijosPlanta.sueldo());
	}

}

package patrones._CalculoDeSueldos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpleadoPasanteTest {
	
	private Empleado empleadoSinExamenes, empleadoConExamenes;
	
	@BeforeEach
	void setUp() {
		empleadoSinExamenes = new EmpleadoPasante(0);
		empleadoConExamenes = new EmpleadoPasante(2);
	}

	@Test
	void testSueldo() {
		assertEquals(17400, empleadoSinExamenes.sueldo());
		assertEquals(21200, empleadoConExamenes.sueldo());
	}

}

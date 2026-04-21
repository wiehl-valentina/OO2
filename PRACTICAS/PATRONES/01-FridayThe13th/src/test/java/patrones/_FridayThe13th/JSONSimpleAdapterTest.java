package patrones._FridayThe13th;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.json.JSONException;

import java.util.*;

class JSONSimpleAdapterTest {
	
	private Exporter exportador; 
	private List<Socio> socios; 
	String expected1 = """
		[
			{
			  "nombre": "Valentina",
			  "email": "valenwiehl@gmail.com",
			  "legajo": "20272"
			}
		]
		""";
	String expected2 = """
		[
			{
			  "nombre": "Valentina",
			  "email": "valenwiehl@gmail.com",
			  "legajo": "20272"
			},
			{
			  "nombre": "María",
			  "email": "valenwiehl@gmail.com",
			  "legajo": "20272"
			}
		]
		""";

	@BeforeEach
	void setUp() {
		exportador = new JSONSImpleAdapter(); 
		socios = new LinkedList<Socio>(); 
		
	}
	
	@Test
	void testExportar() throws JSONException {
		// caso de que no haya socios registrados
		assertEquals("[]", exportador.exportar(socios)); 
		socios.add(new Socio("Valentina", "valenwiehl@gmail.com", "20272"));
		// caso con socios registrados
		JSONAssert.assertEquals(expected1, exportador.exportar(socios), true);
		socios.add(new Socio("María", "valenwiehl@gmail.com", "20272"));
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

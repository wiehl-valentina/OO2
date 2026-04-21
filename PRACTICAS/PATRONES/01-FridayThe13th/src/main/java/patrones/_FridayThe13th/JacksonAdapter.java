package patrones._FridayThe13th;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;



public class JacksonAdapter implements Exporter {

	@Override
	public String exportar(List<Socio> socios) {
		String data = "[]";
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(socios);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return data; 
	}
	
}

package patrones._FridayThe13th;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONSImpleAdapter implements Exporter {

	@SuppressWarnings("unchecked")
	private JSONObject crearSocio(Socio socio) {
		JSONObject object = new JSONObject();
		
		object.put("nombre", socio.getNombre());
		object.put("email", socio.getEmail());
		object.put("legajo", socio.getLegajo());
		
		return object; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public String exportar(List<Socio> socios) {
		if (socios.isEmpty()) {
			return "[]";
		}
		JSONArray arreglo = new JSONArray(); 
		socios.stream()
		.forEach(socio -> arreglo.add(this.crearSocio(socio)));
		
		return arreglo.toJSONString();
	}
}

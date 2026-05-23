package patrones._SustanciasQuimicas;

import java.util.*;
import java.util.stream.Collectors;

public class UnionQuimica extends ElementoQuimico {
	
	List<ElementoQuimico> sustancias; 
	
	public UnionQuimica() {
		sustancias = new LinkedList<ElementoQuimico>(); 
	}
	
	public void agregarSustancia(ElementoQuimico sustancia) {
		sustancias.add(sustancia); 
	}
	
	public void eliminarSustancia(ElementoQuimico sustancia) {
		sustancias.remove(sustancia);
	}
	
	public String formula() {
		return sustancias.stream()
				.map(sustancia -> sustancia.formula())
				.distinct()
				.map(subFormula -> {
					long coincidencias = sustancias.stream()
							.filter(sustancia -> sustancia.formula().equals(subFormula))
							.count(); 
					return coincidencias > 1 ? subFormula + coincidencias : subFormula;
				})
				.collect(Collectors.joining());
	}
	
	public int pesoMolecular() {
		return sustancias.stream()
				.mapToInt(sustancia -> sustancia.pesoMolecular())
				.sum(); 
	}
	
	public int carga() {
		return sustancias.stream()
				.mapToInt(sustancia -> sustancia.carga())
				.sum(); 
	}
	
	public boolean esValida() {
		return sustancias.stream()
				.anyMatch(sustancia -> sustancia.aportaNoMetal());
	}
	
	public boolean aportaNoMetal() {
		return sustancias.stream()
				.anyMatch(sustancia -> sustancia.aportaNoMetal());
	}

}

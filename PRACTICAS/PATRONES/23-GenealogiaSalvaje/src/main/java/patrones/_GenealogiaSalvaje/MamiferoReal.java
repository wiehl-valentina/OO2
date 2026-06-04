package patrones._GenealogiaSalvaje;

import java.time.LocalDate;

public class MamiferoReal implements Mamifero {

	private String identificador; 
	private String especie; 
	private LocalDate fechaNacimiento;
	private Mamifero padre; 
	private Mamifero madre; 
	
	public MamiferoReal() {}
	
	public MamiferoReal(String nombre) {
		identificador = nombre; 
	}
	
	public MamiferoReal(String identificador, String especie, LocalDate fechaNacimiento, Mamifero padre,
			Mamifero madre) {
		super();
		this.identificador = identificador;
		this.especie = especie;
		this.fechaNacimiento = fechaNacimiento;
		this.padre = padre;
		this.madre = madre;
	}

	
	public String getIdentificador() {
		return identificador; 
	}
	
	public void setIdentificador(String nombre) {
		identificador = nombre; 
	}
	
	public String getEspecie() {
		return especie; 
	}
	
	public void setEspecie(String especie) {
		this.especie = especie; 
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento; 
	}

	public void setFechaNacimiento(LocalDate fecha) {
		fechaNacimiento = fecha; 
	}

	public Mamifero getPadre() {
		return padre; 
	}
	
	public void setPadre(Mamifero padre) {
		this.padre = padre; 
	}

	public Mamifero getMadre() {
		return madre;
	}
	
	public void setMadre(Mamifero madre) {
		this.madre = madre; 
	}

	public Mamifero getAbueloMaterno() {
		return this.madre.getPadre();
	}
	
	public Mamifero getAbuelaMaterna() {
		return this.madre.getMadre();
	}

	public Mamifero getAbueloPaterno() {
		return this.padre.getPadre();
	}

	public Mamifero getAbuelaPaterna() {
		return this.padre.getMadre();
	}

	public boolean tieneComoAncestroA(Mamifero unMamifero) {
		return this.madre == unMamifero || this.padre == unMamifero
			|| this.madre.tieneComoAncestroA(unMamifero) || this.padre.tieneComoAncestroA(unMamifero);
	}

}

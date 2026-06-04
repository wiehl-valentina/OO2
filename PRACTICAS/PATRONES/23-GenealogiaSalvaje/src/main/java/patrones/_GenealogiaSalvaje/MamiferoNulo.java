package patrones._GenealogiaSalvaje;

import java.time.LocalDate;

public class MamiferoNulo implements Mamifero {
	
	private static MamiferoNulo instanciaNula = new MamiferoNulo();
	
	private MamiferoNulo() {}
	
	public static MamiferoNulo getInstancia() {
		return instanciaNula;
	}

	@Override
	public String getIdentificador() {
		return "Desconocido";
	}

	@Override
	public void setIdentificador(String id) {}

	@Override
	public String getEspecie() {
		return "Desconocida";
	}

	@Override
	public void setEspecie(String especie) {}

	@Override
	public LocalDate getFechaNacimiento() {
		return null;
	}

	@Override
	public void setFechaNacimiento(LocalDate fecha) {}

	@Override
	public Mamifero getPadre() {
		return this;
	}

	@Override
	public void setPadre(Mamifero padre) {}

	@Override
	public Mamifero getMadre() {
		return this;
	}

	@Override
	public void setMadre(Mamifero madre) {}

	@Override
	public Mamifero getAbueloMaterno() {
		return this;
	}

	@Override
	public Mamifero getAbuelaMaterna() {
		return this;
	}

	@Override
	public Mamifero getAbueloPaterno() {
		return this;
	}

	@Override
	public Mamifero getAbuelaPaterna() {
		return this;
	}

	@Override
	public boolean tieneComoAncestroA(Mamifero unMamifero) {
		return false;
	}

}

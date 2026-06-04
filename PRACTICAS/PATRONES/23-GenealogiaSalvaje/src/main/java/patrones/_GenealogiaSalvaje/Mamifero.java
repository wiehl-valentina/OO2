package patrones._GenealogiaSalvaje;

import java.time.LocalDate;

public interface Mamifero {
	
	public String getIdentificador();
	public void setIdentificador(String id);
	public String getEspecie();
	public void setEspecie(String especie);
	public LocalDate getFechaNacimiento();
	public void setFechaNacimiento(LocalDate fecha);
	public Mamifero getPadre();
	public void setPadre(Mamifero padre);
	public Mamifero getMadre();
	public void setMadre(Mamifero madre);
	public Mamifero getAbueloMaterno();
	public Mamifero getAbuelaMaterna();
	public Mamifero getAbueloPaterno();
	public Mamifero getAbuelaPaterna();
	public boolean tieneComoAncestroA(Mamifero unMamifero);

}

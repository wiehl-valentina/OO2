package patrones._JuegoDeRol;

import java.util.List;

public class Personaje {
	
	private String nombre;
	private int vida = 100;
	private Armadura armadura;
	private Arma arma;
	private List<Habilidad> habilidades;
	
	public Personaje(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public Armadura getArmadura() {
		return armadura;
	}
	
	public void setArmadura(Armadura armadura) {
		this.armadura = armadura;
	}
	
	public Arma getArma() {
		return arma;
	}
	
	public void setArma(Arma arma) {
		this.arma = arma;
	}
	
	public List<Habilidad> getHabilidades() {
		return habilidades;
	}
	
	public void setHabilidades(List<Habilidad> habilidades) {
		this.habilidades = habilidades;
	}
	
	public void atacar(Personaje defensor) {
		if (this.vida > 0 && defensor.getVida() > 0)
			defensor.recibirAtaque(this.arma);
	}
	
	public void recibirAtaque(Arma arma) {
		this.vida = vida - arma.dañoContra(this.armadura);
	}

	public void addHabilidad(Habilidad hab) {
		this.habilidades.add(hab);
	}
	
}

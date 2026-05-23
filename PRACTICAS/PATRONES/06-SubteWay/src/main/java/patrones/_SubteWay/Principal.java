package patrones._SubteWay;

public enum Principal {
	
	TERNERA("Carne de ternera", 300),
	PROVOLETA("Provoleta", 200),
	GIRGOLAS("Girgolas", 500),
	POLLO("Pollo", 250);
	
	private final String nombre;
	private final double precio;
	
	Principal(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public double getPrecio() {return precio;}
	public String getNombre() {return nombre;}
	
}

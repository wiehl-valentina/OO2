package patrones._SubteWay;

public enum Aderezo {

	MAYONESA("Mayonesa", 20),
	CRIOLLA("Salsa criolla", 20),
	TARTARA("Salsa tartara", 18);
	
	private final String nombre;
	private final double precio;
	
	Aderezo(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public double getPrecio() {return precio;}
	public String getNombre() {return nombre;}
	
}

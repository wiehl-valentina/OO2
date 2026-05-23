package patrones._SubteWay;

public enum Pan implements Componente {
	
	BRIOCHE("Pan brioche", 100),
	SEMILLAS("Pan con semillas", 120),
	INTEGRAL("Pan integral", 100),
	CHIPA("Pan de chipá", 150);
	
	private final String nombre;
	private final double precio;
	
	Pan(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public double getPrecio() {return precio;}
	public String getNombre() {return nombre;}
	
}

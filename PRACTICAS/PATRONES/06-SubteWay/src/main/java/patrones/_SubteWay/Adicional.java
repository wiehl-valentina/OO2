package patrones._SubteWay;

public enum Adicional {
	
	TOMATE("Tomate", 80),
	BERENJENAS("Berenjenas al escabeche", 100),
	VERDURAS("Verduras grilladas", 200);
	
	private final String nombre;
	private final double precio;
	
	Adicional(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public double getPrecio() {return precio;}
	public String getNombre() {return nombre;}

}

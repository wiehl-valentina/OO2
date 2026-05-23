package patrones._ProductosFinancieros;

public class MembresiaSilver implements Membresia {
	
	public ProductoCombinado crearProducto1() {
		ProductoCombinado producto = new ProductoCombinado();
		
		producto.agregarProducto(new CompraDolares());
		producto.agregarProducto(new PlazoFijo(35, 5));
		producto.agregarProducto(new CompraPesos());
		
		return producto;
	}
	
	public ProductoCombinado crearProducto2() {
		ProductoCombinado producto = new ProductoCombinado();
		
		producto.agregarProducto(new CompraBonoBajoRiesgo(72));
		producto.agregarProducto(new CompraDolares());
		producto.agregarProducto(new PlazoFijo(35, 5));
		producto.agregarProducto(new CompraPesos());
	
		return producto;
	}
	
	public ProductoCombinado crearProducto3() {
		throw new RuntimeException("Los miebros silver no tienen acceso al producto 3");
	}
	
	public ProductoCombinado crearProducto4() {
		throw new RuntimeException("Los miembros silver no tienen acceso al producto 4");
	}

}

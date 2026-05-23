package patrones._ProductosFinancieros;

public class MembresiaGold implements Membresia {
	
	public ProductoCombinado crearProducto1() {
		ProductoCombinado producto = new ProductoCombinado();
		
		producto.agregarProducto(new CompraDolares());
		producto.agregarProducto(new PlazoFijo(30, 6));
		producto.agregarProducto(new CompraPesos());
		
		return producto;
	}
	
	public ProductoCombinado crearProducto2() {
		ProductoCombinado producto = new ProductoCombinado();
		
		producto.agregarProducto(new CompraBonoBajoRiesgo(24));
		producto.agregarProducto(new CompraDolares());
		producto.agregarProducto(new PlazoFijo(30, 6));
		producto.agregarProducto(new CompraPesos());
	
		return producto;
	}
	
	public ProductoCombinado crearProducto3() {
		ProductoCombinado producto = new ProductoCombinado();
		
		producto.agregarProducto(new CompraBonoAltoRiesgo(24));
		producto.agregarProducto(new CompraBonoBajoRiesgo(24));
		producto.agregarProducto(new PlazoFijo(30, 6));
		
		return producto;
	}
	
	public ProductoCombinado crearProducto4() {
		ProductoCombinado producto = new ProductoCombinado();
		
		producto.agregarProducto(new CompraBonoAltoRiesgo(24));
		producto.agregarProducto(new CompraBonoAltoRiesgo(24));
		producto.agregarProducto(new CompraBonoAltoRiesgo(24));
		
		return producto;
	}

}

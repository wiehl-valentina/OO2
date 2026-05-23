package patrones._ProductosFinancieros;

import java.util.*;

public class ProductoCombinado extends ProductoFinanciero {
	
	List<ProductoFinanciero> productos; 
	
	public ProductoCombinado() {
		this.productos = new LinkedList<ProductoFinanciero>(); 
	}
	
	public void agregarProducto(ProductoFinanciero producto) {
		this.productos.add(producto); 
	}
	
	public void eliminarProducto(ProductoFinanciero producto) {
		this.productos.remove(producto);
	}
	
	public double retornoInversion(double montoInicial) {
		double capitalActual = montoInicial;
		for (ProductoFinanciero producto : productos) {
			// el resultado de la inversión actual se convierte
			// en el monto inicial de la siguiente
			capitalActual = producto.retornoInversion(capitalActual);
		}
		return capitalActual;
	}

}

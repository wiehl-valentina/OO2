# 2.4 Carrito de compras
<div align='center'>

![](/Ejercicio2/images/ej4.png)
</div>

~~~java
public class Producto {
    private String nombre;
    private double precio;
    
    public double getPrecio() {
        return this.precio;
    }
}

public class ItemCarrito {
    private Producto producto;
    private int cantidad;
        
    public Producto getProducto() {
        return this.producto;
    }
    
    public int getCantidad() {
        return this.cantidad;
    }

}

public class Carrito {
    private List<ItemCarrito> items;
    
    public double total() {
        return this.items.stream()
        .mapToDouble(item -> 
        item.getProducto().getPrecio() * item.getCantidad())
        .sum();
    }
}
~~~

<u><i>Code smells</i></u> </br>
   * Feature Envy.
   * Data Class.
</br> 

<u><i>Refactoring</i></u> </br>
   * Extract Method.
   * Move Method.
</br> 

<i>Solución:</i></br>
Aplico el refactoring "Extract Method" para aislar el bloque de código que presenta envidia de atributos y luego "Move Method" para que la responsabilidad de calcular el precio de un item quede bien asignada dentro de la clase ItemCarrito.

~~~java
public class Producto {
    private String nombre;
    private double precio;
    
    public double getPrecio() {
        return this.precio;
    }
}

public class ItemCarrito {
    private Producto producto;
    private int cantidad;
        
    public Producto getProducto() {
        return this.producto;
    }
    
    public int getCantidad() {
        return this.cantidad;
    }

    public double calcularPrecioTotal() {
        return producto.getPrecio()*cantidad; 
    }

}

public class Carrito {
    private List<ItemCarrito> items;
    
    public double total() {
        return this.items.stream()
        .mapToDouble(item -> 
        item.calcularPrecioTotal())
        .sum();
    }
}
~~~

<div align='center'>

![](/Ejercicio2/images/ej4ref1.png)
</div>

<u><i>Code smells</i></u> </br>
   * Nombre poco descriptivo.
</br> 

<u><i>Refactoring</i></u> </br>
   * Rename Method.
</br> 

<i>Solución:</i></br>
Aplico el refactoring "Rename Method" sobre el método "total()" de la clase Carrito para que describa de mejor manera cual es su tarea.

~~~java
public class Producto {
    private String nombre;
    private double precio;
    
    public double getPrecio() {
        return this.precio;
    }
}

public class ItemCarrito {
    private Producto producto;
    private int cantidad;
        
    public Producto getProducto() {
        return this.producto;
    }
    
    public int getCantidad() {
        return this.cantidad;
    }

    public double calcularPrecio() {
        return producto.getPrecio()*cantidad; 
    }

}

public class Carrito {
    private List<ItemCarrito> items;
    
    public double calcularPrecioTotal() {
        return this.items.stream()
        .mapToDouble(item -> 
        item.calcularPrecioTotal())
        .sum();
    }
}
~~~

<div align='center'>

![](/Ejercicio2/images/ej4ref2.png)
</div>
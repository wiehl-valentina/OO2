# Ejercicio 7: Etiquetas
Observe el siguiente código:

```java
abstract class Etiqueta {
    protected String nombreProducto;
    protected double precio;

    public Etiqueta(String nombre, double precio) {
        this.nombreProducto = nombre;
        this.precio = precio;
    }
}

class EtiquetaSimple extends Etiqueta {
    public EtiquetaSimple(String nombre, double precio) {
        super(nombre, precio);
    }

    public void generar() {
        System.out.println("--- ETIQUETA BÁSICA ---");
        System.out.println("Producto: " + nombreProducto);
        System.out.println("Precio: $" + precio);
        System.out.println("-----------------------");
    }
}

class EtiquetaDetalle extends Etiqueta {
    public EtiquetaDetalle(String nombre, double precio) {
        super(nombre, precio);
    }

    public void generar() {
        System.out.println("--- ETIQUETA DETALLE ---");
        System.out.println("Producto: " + nombreProducto);
        System.out.println("Precio sin imp.: $" + (precio * 0.79));
        System.out.println("Precio final: $" + precio);
        System.out.println("-----------------------");
    }
}
```

### Tareas
1.  ¿Hay código duplicado? Indique claramente en qué líneas se encuentra.

2.  Se quiere aplicar el refactoring Pull Up Method para subir el método generar() a la superclase Etiqueta. ¿Es posible hacerlo en el código anterior? Justifique su respuesta basándose en las precondiciones del refactoring vistas en la teoría y en el libro de Refactoring de Martin Fowler.
3.  Mencione los refactorings previos necesarios para que sea posible aplicar Pull Up Method.
4.  Aplique Pull Up Method para subir el método generar() a la superclase Etiqueta.

## Resolución

1. Hay código duplicado en el método `generar()` de la clase `EtiquetaSimple` y `EtiquetaDetalle`, en las líneas 18, 19, 20, 31, 33 y 34.

2. No es posible aplicar el refactoring `Pull Up Method` debido a que el método `generar()` no es idéntico en ambas clases y esto es una precondición para poder aplicarlo.

3. Antes de aplicar `Pull Up Method` sería necesario aplicar `Extract Method` sobre las partes del código que difieren para obtener implementaciones idénticas.

4. Aplico `Extract Method`y luego `Pull Up Method`.

#### Extract Method

```java
abstract class Etiqueta {
    protected String nombreProducto;
    protected double precio;

    public Etiqueta(String nombre, double precio) {
        this.nombreProducto = nombre;
        this.precio = precio;
    }

    public abstract void imprimirTitulo(); 
    public abstract void imprimirPrecio(); 
}

class EtiquetaSimple extends Etiqueta {
    public EtiquetaSimple(String nombre, double precio) {
        super(nombre, precio);
    }

    public void generar() {
        imprimirTitulo()
        System.out.println("Producto: " + nombreProducto);
        imprimirPrecio()
        System.out.println("-----------------------");
    }

    public void imprimirTitulo() {
        System.out.println("--- ETIQUETA BÁSICA ---");
    }

    public void imprimirPrecio() {
        System.out.println("Precio: $" + precio);
    }
}

class EtiquetaDetalle extends Etiqueta {
    public EtiquetaDetalle(String nombre, double precio) {
        super(nombre, precio);
    }

    public void generar() {
        imprimirTitulo()
        System.out.println("Producto: " + nombreProducto);
        imprimirPrecio()
        System.out.println("-----------------------");
    }

    public void imprimirTitulo() {
        System.out.println("--- ETIQUETA DETALLE ---");
    }

    public void imprimirPrecio() {
        System.out.println("Precio sin imp.: $" + (precio * 0.79))
        System.out.println("Precio final: $" + precio);
    }
}
```

#### Pull Up Field

```java
abstract class Etiqueta {
    protected String nombreProducto;
    protected double precio;

    public Etiqueta(String nombre, double precio) {
        this.nombreProducto = nombre;
        this.precio = precio;
    }

    public void generar() {
        imprimirTitulo()
        System.out.println("Producto: " + nombreProducto);
        imprimirPrecio()
        System.out.println("-----------------------");
    }

    public abstract void imprimirTitulo(); 
    public abstract void imprimirPrecio(); 
}

class EtiquetaSimple extends Etiqueta {
    public EtiquetaSimple(String nombre, double precio) {
        super(nombre, precio);
    }

    public void imprimirTitulo() {
        System.out.println("--- ETIQUETA BÁSICA ---");
    }

    public void imprimirPrecio() {
        System.out.println("Precio: $" + precio);
    }
}

class EtiquetaDetalle extends Etiqueta {
    public EtiquetaDetalle(String nombre, double precio) {
        super(nombre, precio);
    }

    public void imprimirTitulo() {
        System.out.println("--- ETIQUETA DETALLE ---");
    }

    public void imprimirPrecio() {
        System.out.println("Precio sin imp.: $" + (precio * 0.79))
        System.out.println("Precio final: $" + precio);
    }
}
```
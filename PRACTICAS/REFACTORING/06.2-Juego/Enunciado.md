# Ejercicio 6.2 Juego
Realice en forma iterativa los siguientes pasos:
* (i) indique el mal olor,
* (ii) indique el refactoring que lo corrige, 
* (iii) aplique el refactoring, mostrando el resultado final (código y/o diseño según corresponda). 

Si vuelve a encontrar un mal olor, retorne al paso (i).

```java
public class Juego {
    // ......
    public void incrementar(Jugador j) {
        j.puntuacion = j.puntuacion + 100;
    }
    public void decrementar(Jugador j) {
        j.puntuacion = j.puntuacion - 50;
    }
}
```
```java
public class Jugador {
    public String nombre;
    public String apellido;
    public int puntuacion = 0;
}
```

## Resolución

* ### Public Field
    Para solucionar este code smell aplico `Encapsulate Field` sobre las variables de instancias declaradas como públicas en la clase `Jugador`.

```java
public class Juego {
    // ......
    public void incrementar(Jugador j) {
        j.setPuntuacion(j.getPuntuacion() + 100);
    }
    public void decrementar(Jugador j) {
        j.setPuntuacion(j.getPuntuacion() - 50);
    }
}
```
```java
public class Jugador {
    private String nombre;
    private String apellido;
    private int puntuacion = 0;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre; 
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido; 
    }

    public int getPuntuacion() {
        return this.puntuacion; 
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion; 
    }

}
```
* ### Uncommunicative Name
    El nombre de los métodos `incrementar()` y `decrementar()` de la clase `Juego` no son lo suficientemente explicativos respecto a lo que hacen, por lo tanto aplico `Rename Method` para achicar la brecha semántica.

```java
public class Juego {
    // ......
    public void incrementarPuntuacion(Jugador j) {
        j.setPuntuacion(j.getPuntuacion() + 100);
    }
    public void decrementarPuntuacion(Jugador j) {
        j.setPuntuacion(j.getPuntuacion() - 50);
    }
}
```
```java
public class Jugador {
    private String nombre;
    private String apellido;
    private int puntuacion = 0;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre; 
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido; 
    }

    public int getPuntuacion() {
        return this.puntuacion; 
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion; 
    }

}
```

* ### Feature Envy
    Los métodos `incrementarPuntuacion()` y `decrementarPuntuacion()` de la clase `Juego` acceden a las variables de instancia de la clase `Jugador` y violan el encapsulamiento. Para resolverlo aplico `Extract Method`? y `Move Method`.

```java
public class Juego {
    // ......
    public void incrementarPuntuacion(Jugador j) {
        j.incrementarPuntuacion(); 
    }
    public void decrementarPuntuacion(Jugador j) {
        j.decrementarPuntuacion();
    }

}
```
```java
public class Jugador {
    private String nombre;
    private String apellido;
    private int puntuacion = 0;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre; 
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido; 
    }

    public int getPuntuacion() {
        return this.puntuacion; 
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion; 
    }

    public void incrementarPuntuacion() {
        this.puntuacion += 100; 
    }

    public void decrementarPuntuacion() {
        this.puntuacion -= 50; 
    }

}
```
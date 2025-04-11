# 2.2 Juego 
~~~java
public class Juego {
    // ......
    public void incrementar(Jugador j) {
        j.puntuacion = j.puntuacion + 100;
    }
    public void decrementar(Jugador j) {
        j.puntuacion = j.puntuacion - 50;
    }
}

public class Jugador {
    public String nombre;
    public String apellido;
    public int puntuacion = 0;
}
~~~

<u><i>Code smells</i></u> </br>
   * Public fields. 
</br> 

<u><i>Refactoring</i></u> </br>
   * Encapsulate Field.
</br> 

<i>Solución:</i></br>
Aplico el refactoring llamado "Encapsulate Field" para ocultar las variables de instancia de las clases y establezco accessors para poder obtener su valor o modificarlas.

~~~java
public class Juego {
    // ......
    public void incrementar(Jugador j) {
        j.setPuntuacion(j.puntuacion + 100);
    }
    public void decrementar(Jugador j) {
        j.setPuntuacion(j.puntuacion - 50);
    }
}

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

    public void setPuntuacion(int puntos) {
        puntuacion = puntos; 
    }
}
~~~

<u><i>Code smells</i></u> </br>
   * The value of the fields "nombre" and "apellido" should be set only when it’s created, and not change at any time after that.
</br> 

<u><i>Refactoring</i></u> </br>
   * Remove Setting Method.
</br> 

<i>Solución:</i></br>
Elimino los métodos para settear las variables de instancia que deben asignarse una sola vez.

~~~java
public class Juego {
    // ......
    public void incrementar(Jugador j) {
        j.setPuntuacion(j.getPuntuacion() + 100);
    }
    public void decrementar(Jugador j) {
        j.setPuntuacion(j.getPuntuacion() - 50);
    }
}

public class Jugador {
    private String nombre;
    private String apellido;
    private int puntuacion = 0;

    public String getNombre() {
        return this.nombre; 
    }

    public String getApellido() {
        return this.apellido; 
    }

    public int getPuntuacion() {
        return this.puntuacion;
    }

    public void setPuntuacion(int puntos) {
        puntuacion = puntos; 
    }
}
~~~


<u><i>Code smells</i></u> </br>
   * Nombres poco descriptivos. 
</br> 

<u><i>Refactoring</i></u> </br>
   * Rename Method.
</br> 

<i>Solución:</i></br>
Cambio el nombre de los métodos "incrementar()" y "decrementar()" para que sean más descriptivos respecto a la tarea que realizan.

~~~java
public class Juego {
    // ......
    public void incrementarPuntos(Jugador j) {
        j.setPuntuacion(j.getPuntuacion() + 100);
    }
    public void decrementarPuntos(Jugador j) {
        j.setPuntuacion(j.getPuntuacion() - 50);
    }
}

public class Jugador {
    private String nombre;
    private String apellido;
    private int puntuacion = 0;

    public String getNombre() {
        return this.nombre; 
    }

    public String getApellido() {
        return this.apellido; 
    }

    public int getPuntuacion() {
        return this.puntuacion;
    }

    public void setPuntuacion(int puntos) {
        puntuacion = puntos; 
    }
}
~~~

<u><i>Code smells</i></u> </br>
   * Data Class.
   * Feature Envy.
</br> 

<u><i>Refactoring</i></u> </br>
   * Move Method.
</br> 

<i>Solución:</i></br>

~~~java
public class Juego {
    // ......
    public void incrementarPuntos(Jugador j) {
        j.incrementarPuntuacion();
    }
    public void decrementarPuntos(Jugador j) {
        j.decrementarPuntuacion();
    }
}

public class Jugador {
    private String nombre;
    private String apellido;
    private int puntuacion = 0;

    public String getNombre() {
        return this.nombre; 
    }

    public String getApellido() {
        return this.apellido; 
    }

    public int getPuntuacion() {
        return this.puntuacion;
    }

    public void setPuntuacion(int puntos) {
        puntuacion = puntos; 
    }

    public void incrementarPuntuacion() {
        this.puntuacion+=100; 
    }

    public void decrementarPuntuacion() {
        this.puntuacion-=50; 
    }
}
~~~

<u><i>Code smells</i></u> </br>
   * La clase Jugador no posee un constructor que inicialice sus variables de instancia.
</br> 

<u><i>Refactoring</i></u> </br>
   * Move Method.
</br> 

<i>Solución:</i></br>

~~~java
public class Juego {
    // ......
    public void incrementarPuntos(Jugador j) {
        j.incrementarPuntuacion();
    }
    public void decrementarPuntos(Jugador j) {
        j.decrementarPuntuacion();
    }
}

public class Jugador {
    private String nombre;
    private String apellido;
    private int puntuacion;

    public Jugador(String nombre, String apellido) {
        this.nombre = nombre; 
        this.apellido = apellido; 
        this.puntuacion = 0; 
    }

    public String getNombre() {
        return this.nombre; 
    }

    public String getApellido() {
        return this.apellido; 
    }

    public int getPuntuacion() {
        return this.puntuacion;
    }

    public void setPuntuacion(int puntos) {
        puntuacion = puntos; 
    }

    public void incrementarPuntuacion() {
        this.puntuacion+=100; 
    }

    public void decrementarPuntuacion() {
        this.puntuacion-=50; 
    }
}
~~~

<i>Consultas:</i></br>
¿Existe la posibilidad de refactoring por Lazy Class (Juego)?
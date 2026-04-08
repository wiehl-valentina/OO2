# Ejercicio 4: Alcance en Redes Sociales 
Una nueva red social está desarrollando un sistema para modelar perfiles y publicaciones, y medir su alcance como parte del algoritmo de relevancia. Cada publicación acumula reacciones de los usuarios, y cada perfil consolida el alcance de sus publicaciones amplificándolo según si está verificado o no. El código es el siguiente:

```java
package redesocial;

public class Publicacion {
   private String texto;
   private int likes;
   public Publicacion(String texto) {
      this.texto = texto;
      this.likes = 0;
   }
   public void darLike() { likes++; }
   public void darDislike() { likes--; }
   private int procesar() {
       return likes * 3;
   }
   public int calcular() {
       return procesar() * 10;
   }
}

public class Perfil {
   private boolean verificado;
   private ArrayList<Publicacion> publicaciones;
   public Perfil(boolean verificado) {
        this.verificado = verificado;
        this.publicaciones = new ArrayList<>();
   }
   public void agregarPublicacion(Publicacion p) { publicaciones.add(p); }
   private int bonus() { return verificado ? 2 : 1; }
   private int alcanceDePublicaciones() {
       return publicaciones.stream().mapToInt(p -> p.calcular()).sum();
   }
   public int calcular() {
       return alcanceDePublicaciones() * bonus();
   }
}
```

### Tarea
Liste cada uno de los cambios necesarios, indicando archivo y línea afectados, para cada uno de los siguientes refactorings:
1. Rename method: procesar (referenciado en línea 11 de Publicacion.java) por impacto 

2. Rename method: calcular (referenciado en línea 14 de Publicacion.java) por alcance
3. Rename method: calcular (referenciado en línea 15 de Perfil.java) por alcance
4. Rename parameter: el parámetro “p” del método agregarPublicacion (línea 10 de Perfil.java) por “publicacion”

* #### Rename Method Procesar
    * Publicacion.java
    1. Línea 11 se modifica el nombre del método procesar() por impacto()
    2. Línea 15 se reemplaza la llamada al método procesar() por el nuevo nombre impacto()

* #### Rename Method Calcular (Publicacion)
    * Publicacion.java
    1. Línea 14 se modifica el nombre del método calcular() por alcance()
    * Perfil.java
    1. Línea 13 se modifica la llamada al método calcular() por su nuevo nombre alcance()

* #### Rename Method Calcular (Perfil)
    * Perfil.java
    1. Línea 15 se modifica el nombre del método calcular() por alcance()

* #### Rename Parameter
    * Perfil.java
    1. Línea 10 se renombra el parámetro p por publicación

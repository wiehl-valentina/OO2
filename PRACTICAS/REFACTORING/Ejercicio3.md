# Ejercicio 3 
Dado el siguiente código implementado en la clase Document y que calcula algunas estadísticas del mismo:

~~~java
public class Document {
    List<String> words;
  
    public long characterCount() {
        long count = this.words
        .stream()
        .mapToLong(w -> w.length())
        .sum();
        return count;
	}
    public long calculateAvg() {
    	long avgLength = this.words
        .stream()
        .mapToLong(w -> w.length())
        .sum() / this.words.size();
        return avgLength;
	}
// Resto del código que no importa
}
~~~

<i>Tareas:</i> </br>
1. Enumere los code smell y que refactorings utilizará para solucionarlos. </br>
2. Aplique los refactorings encontrados, mostrando el código refactorizado luego de aplicar cada uno. </br>
3. Analice el código original y detecte si existe un problema al calcular las estadísticas. Explique cuál es el error y en qué casos se da. ¿El error identificado sigue presente luego de realizar los refactorings? En caso de que no esté presente, ¿en qué momento se resolvió? De acuerdo a lo visto en la teoría, ¿podemos considerar esto un refactoring?

<u><i>Code smells</i></u> </br>
   * Public Field.
</br> 

<u><i>Refactoring</i></u> </br>
   * Encapsulate Field.
</br> 

<i>Solución:</i></br>
Aplico el refactoring "Encapsulate Field", cambio el modificador de acceso de la variable de instancia "words" a privado e implemento getter y setter para poder acceder a su valor o modificarlo.

~~~java
public class Document {
    private List<String> words;
  
    public long characterCount() {
        long count = this.words
        .stream()
        .mapToLong(w -> w.length())
        .sum();
        return count;
	}
    public long calculateAvg() {
    	long avgLength = this.words
        .stream()
        .mapToLong(w -> w.length())
        .sum() / this.words.size();
        return avgLength;
	}

    public List<String> getWords() {
        return words; 
    }

    public void setWords(List<String> words) {
        this.words = words; 
    }
// Resto del código que no importa
}
~~~

<u><i>Code smells</i></u> </br>
   * Duplicated Code.
</br> 

<u><i>Refactoring</i></u> </br>
   * Extract Method.
</br> 

<i>Solución:</i></br>
Debido a que tanto el método "characterCount()" como "calculateAvg()" repiten la lógica para contar la longitud total de caracteres de la lista "words", hago uso del refactoring "Extract Method" para eliminar el código duplicado.

~~~java
public class Document {
    private List<String> words;
  
    public long characterCount() {
        long count = this.words
        .stream()
        .mapToLong(w -> w.length())
        .sum();
        return count;
	}
    public long calculateAvg() {
    	long avgLength = this.characterCount() / this.words.size();
        return avgLength;
	}

    public List<String> getWords() {
        return words; 
    }

    public void setWords(List<String> words) {
        this.words = words; 
    }
// Resto del código que no importa
}
~~~

<u><i>Code smells</i></u> </br>
   * Uso de variables temporales para almacenar una expresión sencilla.
</br> 

<u><i>Refactoring</i></u> </br>
   * Inline Temp.
</br> 

<i>Solución:</i></br>
Aplico el refactoring "Inline Temp" para eliminar las variables temporales dentro de ambos métodos.

~~~java
public class Document {
    private List<String> words;
  
    public long characterCount() {
        return this.words.stream()
        .mapToLong(w -> w.length()).sum();
	}
    public long calculateAvg() {
    	return this.characterCount() / this.words.size();
	}

    public List<String> getWords() {
        return words; 
    }

    public void setWords(List<String> words) {
        this.words = words; 
    }
// Resto del código que no importa
}
~~~

### Error 1
El módulo "calculateAvg()" devuelve un resultado de tipo long cuando debería devolver un resultado de tipo double, ya que un promedio puede tener decimales.

### Error 2
El módulo "calculateAvg()" podría lanzar un error de división por 0 si la lista de palabras estuviera vacía.

Ambos casos no son refactorings, ya que al modificar los errores estaríamos cambiando la funcionalidad del código. 







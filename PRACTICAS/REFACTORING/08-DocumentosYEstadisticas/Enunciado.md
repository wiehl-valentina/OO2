# Ejercicio 8 - Documentos y estadísticas

Dado el siguiente código implementado en la clase Document y que calcula algunas estadísticas del mismo:

```java
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
```

### Tareas

1. Enumere los code smell y que refactorings utilizará para solucionarlos.

2. Aplique los refactorings encontrados, mostrando el código refactorizado luego de aplicar cada uno.
3. Analice el código original y detecte si existe un problema al calcular las estadísticas. Explique cuál es el error y en qué casos se da ¿El error identificado sigue presente luego de realizar los refactorings? En caso de que no esté presente, ¿en qué momento se resolvió? De acuerdo a lo visto en la teoría, ¿podemos considerar esto un refactoring?

## Resolución

1. Code smells
   - Duplicated Code: se soluciona aplicando `Extract Method`? (no estoy segura porque el código ya forma parte de un método, solo habría que reemplazarlo por una llamada)

   - Public Field: la variable de instancia words no tiene un modificador de acceso declarado y por lo tanto es visible y accesible para las demás clases dentro de su paquete. Esto se soluciona aplicando `Encapsulate Field`.
   - La variable `count()` en characterCount() si bien no es completamente necesaria aporta una explicación de lo que se obtiene a partir del uso del stream. Está bien dejarla?

2. Aplicación de los refactorings:

#### Extract Method

```java
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
    	long avgLength = characterCount() / this.words.size();
            return avgLength;
    }
    // Resto del código que no importa
}
```

#### Encapsulate Field

```java
public class Document {
    private List<String> words;

    public String getWords() {
        return this.words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public long characterCount() {
        long count = this.words
        .stream()
        .mapToLong(w -> w.length())
        .sum();
                return count;
	}

    public long calculateAvg() {
    	long avgLength = characterCount() / this.words.size();
            return avgLength;
    }
    // Resto del código que no importa
}
```

3. Errores en el código:

#### Posibilidad de realizar división por 0

Si la lista de palabras estuviera vacía, el método `calculateAvg()` ejecutaría una división por 0. Este error sigue presente luego de los refactorings debido a que aplicar un refactoring no cambia la funcionalidad del código.

#### Tipo de retorno incorrecto

El método `calculateAvg()` retorna un valor de tipo long que se usa para representar números enteros, pero un promedio puede contener decimales, por lo que debería devolver un dato de tipo double para no perder información. El error sigue presente luego de los refactorings debido a que aplicar un refactoring no cambia la funcionalidad del código.

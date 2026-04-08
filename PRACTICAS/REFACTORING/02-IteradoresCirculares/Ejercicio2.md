# Ejercicio 2: Iteradores circulares 
Dada la siguiente implementación:
```java
public class CharRing extends Object {
    char[] source;
    int idx;

    public CharRing(String srcString) {
        char result;
        source = new char[srcString.length()];
        srcString.getChars(0, srcString.length(), source, 0);
        result = 0;
        idx = result;
    }

    public char next() {
        int result;
        if (idx >= source.length)
            idx = 0;
        result = idx++;
        return source[result];
    }
}
```
## Tareas
1. Se quiere aplicar el refactoring Rename Variable sobre la variable result que se usa en la línea 18 con el nuevo nombre currentPosition.
2. ¿Cómo queda el código final y qué inconveniente se podría encontrar?

#### Resolución:
```java
public class CharRing extends Object {
    char[] source;
    int idx;

    public CharRing(String srcString) {
        char result;
        source = new char[srcString.length()];
        srcString.getChars(0, srcString.length(), source, 0);
        result = 0;
        idx = result;
    }

    public char next() {
        int currentPosition;
        if (idx >= source.length)
            idx = 0;
        currentPosition = idx++;
        return source[currentPosition];
    }
}
```
Podrían generarse inconvenientes si el refactoring no se aplica correctamente en todas las referencias a la variable dentro del método `next()`.
# Ejercicio 3: Iteradores circulares bis 
Se cuenta con las siguientes implementaciones de iteradores circulares, las cuales presentan implementaciones similares.

```java
public class CharRing {
    private char[] source;
    private int idx;

    public CharRing(String src) {
        source = src.toCharArray();
        idx = 0;
    }

    public char next() {
        if (idx >= source.length)
            idx = 0;
        return source[idx++];
    }
}

public class IntRing {
    private int[] source;
    private int idx;

    public IntRing(int[] src) {
        source = src;
        idx = 0;
    }

    public int next() {
        if (idx >= source.length)
            idx = 0;
        return source[idx++];
    }
}
```

### Tareas
1. Diseñe e implemente Test de Unidad para las clases CharRing e IntRing. Asegúrese de que los test pasen.

2. Aplique el refactoring Extract Superclass. Detalle cada uno de los pasos intermedios que son necesarios para poder aplicar correctamente este refactoring.
3. Verifique que los tests definidos en el paso 1 sigan funcionando correctamente.
Realice un diagrama de clases UML con el diseño refactorizado.

#### Aplicación de Extract Superclass:
1. Crear una nueva `clase abstracta` y hacer que las clases originales hereden de ella.
2. Aplicar `Pull Up Field` para mover los atributos en común a la superclase.
3. Aplicar `Extract Method` en el método next() para desacoplar la funcionalidad de obtener el índice del siguiente elemento.
4. Aplicar `Pull Up Method` para mover el método `getNextIndex(int length)` a la superclase.
5. Aplicar `Pull Up Constructor Body` para unificar las partes comunes en los constructoresa de las subclases.




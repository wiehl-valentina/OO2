# Ejercicio 6.1 Empleados
Realice en forma iterativa los siguientes pasos:
* (i) indique el mal olor,
* (ii) indique el refactoring que lo corrige, 
* (iii) aplique el refactoring, mostrando el resultado final (código y/o diseño según corresponda). 

Si vuelve a encontrar un mal olor, retorne al paso (i).

```java
public class EmpleadoTemporario {
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
    public double horasTrabajadas = 0;
    public int cantidadHijos = 0;
    // ......
    
    public double sueldo() {
        return this.sueldoBasico
        + (this.horasTrabajadas * 500) 
        + (this.cantidadHijos * 1000) 
        - (this.sueldoBasico * 0.13);
    }
}
```
```java
public class EmpleadoPlanta {
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
    public int cantidadHijos = 0;
    // ......
    
    public double sueldo() {
        return this.sueldoBasico 
        + (this.cantidadHijos * 2000)
        - (this.sueldoBasico * 0.13);
    }
}
```
```java
public class EmpleadoPasante {
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
    // ......
    
    public double sueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }
}
```
## Resolución

* ### Public Field
    
    Para solucionarlo aplico el refactoring `Encapsulate Field` sobre todas las variables de instancia declaradas como públicas en las tres clases.

* #### EmpleadoTemporario

```java
public class EmpleadoTemporario {
    private String nombre;
    private String apellido;
    private double sueldoBasico = 0;
    private double horasTrabajadas = 0;
    private int cantidadHijos = 0;
    // ......

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

    public double getSueldoBasico() {
        return this.sueldoBasico;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico; 
    }

    public double getHorasTrabajadas() {
        return this.horasTrabajadas;
    }

    public void setHorasTrabajadas(double horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas; 
    }

    public int getCantidadHijos() {
        return this.cantidadHijos;
    }

    public void setCantidadHijos(int cantidadHijos) {
        this.cantidadHijos = cantidadHijos; 
    }
    
    public double sueldo() {
        return this.sueldoBasico
        + (this.horasTrabajadas * 500) 
        + (this.cantidadHijos * 1000) 
        - (this.sueldoBasico * 0.13);
    }
}
```
* #### EmpleadoPlanta

```java
public class EmpleadoPlanta {
    private String nombre;
    private String apellido;
    private double sueldoBasico = 0;
    private int cantidadHijos = 0;
    // ......
    
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

    public double getSueldoBasico() {
        return this.sueldoBasico;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico; 
    }

    public int getCantidadHijos() {
        return this.cantidadHijos;
    }

    public void setCantidadHijos(int cantidadHijos) {
        this.cantidadHijos = cantidadHijos; 
    }

    public double sueldo() {
        return this.sueldoBasico 
        + (this.cantidadHijos * 2000)
        - (this.sueldoBasico * 0.13);
    }
}
```
* #### EmpleadoPasante

```java
public class EmpleadoPasante {
    private String nombre;
    private String apellido;
    private double sueldoBasico = 0;
    // ......
    
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

    public double getSueldoBasico() {
        return this.sueldoBasico;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico; 
    }

    public double sueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }
}
```

* ### Duplicated Code

    Como el código duplicado se encuentra en diferentes clases que no pertenecen a una jerarquía, para solucionarlo aplico `Extract Superclass` con el objetivo de generalizar estado y comportamiento.

```java
public abstract class Empleado {

    protected String nombre;
    protected String apellido;
    protected double sueldoBasico = 0;

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

    public double getSueldoBasico() {
        return this.sueldoBasico;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico; 
    }

    public abstract double sueldo();

}
```
```java
public class EmpleadoTemporario extends Empleado {

    private double horasTrabajadas = 0;
    // ......

    public double getHorasTrabajadas() {
        return this.horasTrabajadas;
    }

    public void setHorasTrabajadas(double horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas; 
    }

    public int getCantidadHijos() {
        return this.cantidadHijos;
    }

    public void setCantidadHijos(int cantidadHijos) {
        this.cantidadHijos = cantidadHijos; 
    }
    
    public double sueldo() {
        return this.sueldoBasico
        + (this.horasTrabajadas * 500) 
        + (this.cantidadHijos * 1000) 
        - (this.sueldoBasico * 0.13);
    }

}
```
```java
public class EmpleadoPlanta extends Empleado {
    // ......

    public int getCantidadHijos() {
        return this.cantidadHijos;
    }

    public void setCantidadHijos(int cantidadHijos) {
        this.cantidadHijos = cantidadHijos; 
    }

    public double sueldo() {
        return this.sueldoBasico 
        + (this.cantidadHijos * 2000)
        - (this.sueldoBasico * 0.13);
    }

}
```
```java
public class EmpleadoPasante extends Empleado {
    // ......

    public double sueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }

}
```

* ### Duplicated Code

    Como el código duplicado pertenece a las clases `EmpleadoTemporario` y `EmpleadoPlanta` pero no a `EmpleadoPasante` no puedo mover el comportamiento a la superclase Empleado, por lo tanto vuelvo a aplicar `Extract Superclass` para generalizar el estado y comportamiento de EmpleadoTemporario y EmpleadoPlanta.

```java
public abstract class Empleado {

    protected String nombre;
    protected String apellido;
    protected double sueldoBasico = 0;

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

    public double getSueldoBasico() {
        return this.sueldoBasico;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico; 
    }

    public abstract double sueldo();

}
```
```java
public abstract class EmpleadoConHijos extends Empleado {

    protected int cantidadHijos = 0;

    public int getCantidadHijos() {
        return this.cantidadHijos;
    }

    public void setCantidadHijos(int cantidadHijos) {
        this.cantidadHijos = cantidadHijos; 
    }

    public abstract double sueldo();

}
```
```java
public class EmpleadoTemporario extends EmpleadoConHijos {

    private double horasTrabajadas = 0;
    // ......

    public double getHorasTrabajadas() {
        return this.horasTrabajadas;
    }

    public void setHorasTrabajadas(double horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas; 
    }
    
    public double sueldo() {
        return this.sueldoBasico
        + (this.horasTrabajadas * 500) 
        + (this.cantidadHijos * 1000) 
        - (this.sueldoBasico * 0.13);
    }

}
```
```java
public class EmpleadoPlanta extends EmpleadoConHijos {
    // ......

    public double sueldo() {
        return this.sueldoBasico 
        + (this.cantidadHijos * 2000)
        - (this.sueldoBasico * 0.13);
    }

}
```
```java
public class EmpleadoPasante extends Empleado {
    // ......

    public double sueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }

}
```
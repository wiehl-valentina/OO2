Realice en forma iterativa los siguientes pasos: </br>
  1. Indique el mal olor, </br>
  2. Indique el refactoring que lo corrige, </br>
  3. Aplique el refactoring, mostrando el resultado final (código y/o diseño según corresponda). </br>
  
Si vuelve a encontrar un mal olor, retorne al paso 1.

# 2.1 Empleados 
~~~java
public class EmpleadoTemporario {
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
    public double horasTrabajadas = 0;
    public int cantidadHijos = 0;
    // ......
    
    public double sueldo() {
        return this.sueldoBasico + (this.horasTrabajadas * 500) 
        + (this.cantidadHijos * 1000) + (this.sueldoBasico * 0.13);
    }
}

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

public class EmpleadoPasante {
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
    // ......
    
    public double sueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }
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

    public void setSueldoBasico(double sueldo) {
        sueldoBasico = sueldo; 
    }

    public double getHorasTrabajadas() {
        return this.horasTrabajadas; 
    }

    public void setHorasTrabajadas(double horas) {
        horasTrabajadas = horas;
    }

    public int getCantidadDeHijos() {
        return this.cantidadHijos; 
    }

    public void setCantidadDeHijos(int cantidad) {
        cantidadHijos = cantidad; 
    }

     public double sueldo() {
        return this.sueldoBasico + (this.horasTrabajadas * 500) 
        + (this.cantidadHijos * 1000) + (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoPlanta {
    private String nombre;
    private String apellido;
    private double sueldoBasico = 0;
    private int cantidadHijos = 0;
    // ......

    public double sueldo() {
        return this.sueldoBasico + (this.horasTrabajadas * 500) 
        + (this.cantidadHijos * 1000) + (this.sueldoBasico * 0.13);
    }

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

    public void setSueldoBasico(double sueldo) {
        sueldoBasico = sueldo; 
    }

    public int getCantidadDeHijos() {
        return this.cantidadHijos; 
    }

    public void setCantidadDeHijos(int cantidad) {
        cantidadHijos = cantidad; 
    }
    
    public double sueldo() {
        return this.sueldoBasico 
        + (this.cantidadHijos * 2000)
        - (this.sueldoBasico * 0.13);
    }
}

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

    public void setSueldoBasico(double sueldo) {
        sueldoBasico = sueldo; 
    }
    
    public double sueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
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

    public String getApellido() {
        return this.apellido; 
    }

    public double getSueldoBasico() {
        return this.sueldoBasico; 
    }

    public void setSueldoBasico(double sueldo) {
        sueldoBasico = sueldo; 
    }

    public double getHorasTrabajadas() {
        return this.horasTrabajadas; 
    }

    public void setHorasTrabajadas(double horas) {
        horasTrabajadas = horas;
    }

    public int getCantidadDeHijos() {
        return this.cantidadHijos; 
    }

    public void setCantidadDeHijos(int cantidad) {
        cantidadHijos = cantidad; 
    }

     public double sueldo() {
        return this.sueldoBasico + (this.horasTrabajadas * 500) 
        + (this.cantidadHijos * 1000) + (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoPlanta {
    private String nombre;
    private String apellido;
    private double sueldoBasico = 0;
    private int cantidadHijos = 0;
    // ......

    public double sueldo() {
        return this.sueldoBasico + (this.horasTrabajadas * 500) 
        + (this.cantidadHijos * 1000) + (this.sueldoBasico * 0.13);
    }

    public String getNombre() {
        return this.nombre; 
    }

    public String getApellido() {
        return this.apellido; 
    }

    public double getSueldoBasico() {
        return this.sueldoBasico; 
    }

    public void setSueldoBasico(double sueldo) {
        sueldoBasico = sueldo; 
    }

    public int getCantidadDeHijos() {
        return this.cantidadHijos; 
    }

    public void setCantidadDeHijos(int cantidad) {
        cantidadHijos = cantidad; 
    }
    
    public double sueldo() {
        return this.sueldoBasico 
        + (this.cantidadHijos * 2000)
        - (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoPasante {
    private String nombre;
    private String apellido;
    private double sueldoBasico = 0;
    // ......

    public String getNombre() {
        return this.nombre; 
    }

    public String getApellido() {
        return this.apellido; 
    }

    public double getSueldoBasico() {
        return this.sueldoBasico; 
    }

    public void setSueldoBasico(double sueldo) {
        sueldoBasico = sueldo; 
    }
    
    public double sueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }
}
~~~

<u><i>Code smells</i></u> </br>
   * No se tiene constructores que permitan inicializar las variables de instancia.
</br> 

<u><i>Refactoring</i></u> </br>
   * No tiene nombre específico.
</br> 

<i>Solución:</i></br>
Implementar constructores que permitan inicializar las variables de instancia (nombre, apellido, sueldo básico, horas trabajadas y cantidad de hijos).

~~~java
public class EmpleadoTemporario {
    private String nombre;
    private String apellido;
    private double sueldoBasico;
    private double horasTrabajadas; 
    private int cantidadHijos;
    // ......

    public EmpleadoTemporario(String nombre, String apelido, double horasTrabajadas, int cantidadHijos) {
        this.nombre = nombre; 
        this.apellido = apellido; 
        this.horasTrabajadas = horasTrabajadas;
        this.cantidadHijos = cantidadHijos; 
        this.sueldoBasico = 0; 
    }

    public String getNombre() {
        return this.nombre; 
    }

    public String getApellido() {
        return this.apellido; 
    }

    public double getSueldoBasico() {
        return this.sueldoBasico; 
    }

    public void setSueldoBasico(double sueldo) {
        sueldoBasico = sueldo; 
    }

    public double getHorasTrabajadas() {
        return this.horasTrabajadas; 
    }

    public void setHorasTrabajadas(double horas) {
        horasTrabajadas = horas;
    }

    public int getCantidadDeHijos() {
        return this.cantidadHijos; 
    }

    public void setCantidadDeHijos(int cantidad) {
        cantidadHijos = cantidad; 
    }

     public double sueldo() {
        return this.sueldoBasico + (this.horasTrabajadas * 500) 
        + (this.cantidadHijos * 1000) + (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoPlanta {
    private String nombre;
    private String apellido;
    private double sueldoBasico = 0;
    private int cantidadHijos = 0;
    // ......

    public EmpleadoPlanta(String nombre, String apelido, int cantidadHijos) {
        this.nombre = nombre; 
        this.apellido = apellido; 
        this.cantidadHijos = cantidadHijos; 
        this.sueldoBasico = 0; 
    }

    public double sueldo() {
        return this.sueldoBasico + (this.horasTrabajadas * 500) 
        + (this.cantidadHijos * 1000) + (this.sueldoBasico * 0.13);
    }

    public String getNombre() {
        return this.nombre; 
    }

    public String getApellido() {
        return this.apellido; 
    }

    public double getSueldoBasico() {
        return this.sueldoBasico; 
    }

    public void setSueldoBasico(double sueldo) {
        sueldoBasico = sueldo; 
    }

    public int getCantidadDeHijos() {
        return this.cantidadHijos; 
    }

    public void setCantidadDeHijos(int cantidad) {
        cantidadHijos = cantidad; 
    }
    
    public double sueldo() {
        return this.sueldoBasico 
        + (this.cantidadHijos * 2000)
        - (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoPasante {
    private String nombre;
    private String apellido;
    private double sueldoBasico = 0;
    // ......

    public EmpleadoPasante(String nombre, String apelido) {
        this.nombre = nombre; 
        this.apellido = apellido; 
        this.sueldoBasico = 0; 
    }

    public String getNombre() {
        return this.nombre; 
    }

    public String getApellido() {
        return this.apellido; 
    }

    public double getSueldoBasico() {
        return this.sueldoBasico; 
    }

    public void setSueldoBasico(double sueldo) {
        sueldoBasico = sueldo; 
    }
    
    public double sueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }
}
~~~

<u><i>Code smells</i></u> </br>
   * Duplicated Code
   (three classes with common fields and methods).
</br> 

<u><i>Refactoring</i></u> </br>
   * Extract Superclass.
</br> 

<i>Solución:</i></br>
Aplico el refactoring "Extract Superclass" haciendo uso de  "Pull Up Field", "Pull Up Method" y "Pull Up Constructor Body".

~~~java
public abstract class Empleado {
    protected String nombre;
    protected String apellido;
    protected double sueldoBasico;

    public Empleado(String nombre, String apellido) {
        this.nombre = nombre; 
        this.apellido = apellido; 
        this.sueldoBasico = 0; 
    }

    public String getNombre() {
        return this.nombre; 
    }

    public String getApellido() {
        return this.apellido; 
    }

    public double getSueldoBasico() {
        return this.sueldoBasico; 
    }

    public void setSueldoBasico(double sueldo) {
        sueldoBasico = sueldo; 
    }

    public abstarct double sueldo();
}

public class EmpleadoTemporario extends Empleado {
    private double horasTrabajadas; 
    private int cantidadHijos;
    // ......

    public EmpleadoTemporario(String nombre, String apelido, double horasTrabajadas, int cantidadHijos) {
        super(nombre, apellido);
        this.horasTrabajadas = horasTrabajadas;
        this.cantidadHijos = cantidadHijos; 
    }

    public double getHorasTrabajadas() {
        return this.horasTrabajadas; 
    }

    public void setHorasTrabajadas(double horas) {
        horasTrabajadas = horas;
    }

    public int getCantidadDeHijos() {
        return this.cantidadHijos; 
    }

    public void setCantidadDeHijos(int cantidad) {
        cantidadHijos = cantidad; 
    }

     public double sueldo() {
        return this.sueldoBasico + (this.horasTrabajadas * 500) 
        + (this.cantidadHijos * 1000) + (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoPlanta extends Empleado {
    private int cantidadHijos = 0;
    // ......

    public EmpleadoPlanta(String nombre, String apelido, int cantidadHijos) {
        super(nombre, apellido);
        this.cantidadHijos = cantidadHijos; 
    }
    
    public int getCantidadDeHijos() {
        return this.cantidadHijos; 
    }

    public void setCantidadDeHijos(int cantidad) {
        cantidadHijos = cantidad; 
    }
    
    public double sueldo() {
        return this.sueldoBasico 
        + (this.cantidadHijos * 2000)
        - (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoPasante extends Empleado {
    // ......

    public EmpleadoPasante(String nombre, String apelido) {
        super(nombre, apellido);
    }
    
    public double sueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }
}
~~~

<u><i>Code smells</i></u> </br>
   * Nombre poco descriptivo.
</br> 

<u><i>Refactoring</i></u> </br>
   * Rename Method.
</br> 

<i>Solución:</i></br>
Modifico el nombre del método sueldo() por uno más descriptivo de la tarea que realiza.

~~~java
public abstract class Empleado {
    protected String nombre;
    protected String apellido;
    protected double sueldoBasico;

    public Empleado(String nombre, String apellido) {
        this.nombre = nombre; 
        this.apellido = apellido; 
        this.sueldoBasico = 0; 
    }

    public String getNombre() {
        return this.nombre; 
    }

    public String getApellido() {
        return this.apellido; 
    }

    public double getSueldoBasico() {
        return this.sueldoBasico; 
    }

    public void setSueldoBasico(double sueldo) {
        sueldoBasico = sueldo; 
    }

    public abstarct double calcularSueldo();
}

public class EmpleadoTemporario extends Empleado {
    private double horasTrabajadas; 
    private int cantidadHijos;
    // ......

    public EmpleadoTemporario(String nombre, String apelido, double horasTrabajadas, int cantidadHijos) {
        super(nombre, apellido);
        this.horasTrabajadas = horasTrabajadas;
        this.cantidadHijos = cantidadHijos; 
    }

    public double getHorasTrabajadas() {
        return this.horasTrabajadas; 
    }

    public void setHorasTrabajadas(double horas) {
        horasTrabajadas = horas;
    }

    public int getCantidadDeHijos() {
        return this.cantidadHijos; 
    }

    public void setCantidadDeHijos(int cantidad) {
        cantidadHijos = cantidad; 
    }

     public double calcularSueldo() {
        return this.sueldoBasico + (this.horasTrabajadas * 500) 
        + (this.cantidadHijos * 1000) + (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoPlanta extends Empleado {
    private int cantidadHijos = 0;
    // ......

    public EmpleadoPlanta(String nombre, String apelido, int cantidadHijos) {
        super(nombre, apellido);
        this.cantidadHijos = cantidadHijos; 
    }
    
    public int getCantidadDeHijos() {
        return this.cantidadHijos; 
    }

    public void setCantidadDeHijos(int cantidad) {
        cantidadHijos = cantidad; 
    }
    
    public double calcularSueldo() {
        return this.sueldoBasico 
        + (this.cantidadHijos * 2000)
        - (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoPasante extends Empleado {
    // ......

    public EmpleadoPasante(String nombre, String apelido) {
        super(nombre, apellido);
    }
    
    public double calcularSueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }
}
~~~

<u><i>Code smells</i></u> </br>
   * Duplicated Code (clases EmpleadoPlanta y EmpleadoTemporario tienen la variable de instancia cantidadHijos repetida).
</br> 

<u><i>Refactoring</i></u> </br>
   * Extract Superclass.
</br> 

<i>Solución:</i></br>
Aplico el refactoring "Extract Superclass" haciendo uso de  "Pull Up Field", "Pull Up Method" y "Pull Up Constructor Body".

~~~java
public abstract class Empleado {
    protected String nombre;
    protected String apellido;
    protected double sueldoBasico;

    public Empleado(String nombre, String apellido) {
        this.nombre = nombre; 
        this.apellido = apellido; 
        this.sueldoBasico = 0; 
    }

    public String getNombre() {
        return this.nombre; 
    }

    public String getApellido() {
        return this.apellido; 
    }

    public double getSueldoBasico() {
        return this.sueldoBasico; 
    }

    public void setSueldoBasico(double sueldo) {
        sueldoBasico = sueldo; 
    }

    public abstarct double calcularSueldo();
}

public class EmpleadoConHijos extends Empleado {
    protected int cantidadHijos; 

    public EmpleadoConHijos(String nombre, String apellido, int cantidadHijos) {
        super(nombre, apellido); 
        this.cantidadHijos = cantidadHijos; 
    }

    public int getCantidadDeHijos() {
        return this.cantidadHijos; 
    }

    public void setCantidadDeHijos(int cantidad) {
        cantidadHijos = cantidad; 
    }
}

public class EmpleadoTemporario extends EmpleadoConHijos {
    private double horasTrabajadas; 

    public EmpleadoTemporario(String nombre, String apelido, double horasTrabajadas, int cantidadHijos) {
        super(nombre, apellido, cantidadHijos);
        this.horasTrabajadas = horasTrabajadas;
    }

    public double getHorasTrabajadas() {
        return this.horasTrabajadas; 
    }

    public void setHorasTrabajadas(double horas) {
        horasTrabajadas = horas;
    }

    public double calcularSueldo() {
        return this.sueldoBasico + (this.horasTrabajadas * 500) 
        + (this.cantidadHijos * 1000) + (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoPlanta extends EmpleadoConHijos {

    public EmpleadoPlanta(String nombre, String apelido, int cantidadHijos) {
        super(nombre, apellido, cantidadHijos); 
    }
    
    public double calcularSueldo() {
        return this.sueldoBasico 
        + (this.cantidadHijos * 2000)
        - (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoPasante extends Empleado {

    public EmpleadoPasante(String nombre, String apelido) {
        super(nombre, apellido);
    }
    
    public double calcularSueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }
}
~~~

<u><i>Code smells</i></u> </br>
   * You have a complicated expression.
</br> 

<u><i>Refactoring</i></u> </br>
   * Introduce Explaining Variable ó
   * Extract Method.
</br> 

<i>Solución:</i></br>
En este caso opto por utilizar el refactoring "Extract Method" sobre las expresiones complejas incluidas en los métodos "calcularSueldo()" para evitar el uso de variables temporales y que la clase pueda utilizar los métodos resultantes en otro lado si lo necesitara.

~~~java
public abstract class Empleado {
    protected String nombre;
    protected String apellido;
    protected double sueldoBasico;

    public Empleado(String nombre, String apellido) {
        this.nombre = nombre; 
        this.apellido = apellido; 
        this.sueldoBasico = 0; 
    }

    public String getNombre() {
        return this.nombre; 
    }

    public String getApellido() {
        return this.apellido; 
    }

    public double getSueldoBasico() {
        return this.sueldoBasico; 
    }

    public void setSueldoBasico(double sueldo) {
        sueldoBasico = sueldo; 
    }

    public int calcularPorcentajeSalarial() {
        return this.sueldoBasico*0.13; 
    }

    public abstarct double calcularSueldo();
}

public abstract class EmpleadoConHijos extends Empleado {
    protected int cantidadHijos; 

    public EmpleadoConHijos(String nombre, String apellido, int cantidadHijos) {
        super(nombre, apellido); 
        this.cantidadHijos = cantidadHijos; 
    }

    public int getCantidadDeHijos() {
        return this.cantidadHijos; 
    }

    public void setCantidadDeHijos(int cantidad) {
        cantidadHijos = cantidad; 
    }

    public abstract int calcularMontoPorHijos() {}

    public abstarct double calcularSueldo();
}

public class EmpleadoTemporario extends EmpleadoConHijos {
    private double horasTrabajadas; 

    public EmpleadoTemporario(String nombre, String apelido, double horasTrabajadas, int cantidadHijos) {
        super(nombre, apellido, cantidadHijos);
        this.horasTrabajadas = horasTrabajadas;
    }

    public double getHorasTrabajadas() {
        return this.horasTrabajadas; 
    }

    public void setHorasTrabajadas(double horas) {
        horasTrabajadas = horas;
    }

    public int calcularMontoPorHijos() {
        return this.cantidadHijos*1000; 
    }

    public double calcularMontoPorHoras() {
        return this.horasTrabajadas*500; 
    }

    public double calcularSueldo() {
        return this.sueldoBasico + calcularMontoPorHoras()
        + calcularMontoPorHijos() + calcularPorcentajeSalarial();
    }
}

public class EmpleadoPlanta extends EmpleadoConHijos {

    public EmpleadoPlanta(String nombre, String apelido, int cantidadHijos) {
        super(nombre, apellido, cantidadHijos); 
    }

    public int calcularMontoPorHijos() {
        return this.cantidadHijos*2000;
    }
    
    public double calcularSueldo() {
        return this.sueldoBasico 
        + calcularMontoPorHijos()
        - calcularPorcentajeSalarial();
    }
}

public class EmpleadoPasante extends Empleado {

    public EmpleadoPasante(String nombre, String apelido) {
        super(nombre, apellido);
    }
    
    public double calcularSueldo() {
        return this.sueldoBasico - calcularPorcentajeSalarial();
    }
}
~~~


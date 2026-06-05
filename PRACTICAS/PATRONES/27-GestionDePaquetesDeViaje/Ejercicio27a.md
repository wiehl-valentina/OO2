# Ejercicio 27: Gestión de paquetes de viaje

Una agencia de viajes posee un sitio web para gestionar las solicitudes de paquetes de sus clientes.
De un paquete de viaje se conoce su precio base, su plataforma de pago y su situación actual (para darle seguimiento).

El sistema debe soportar las siguientes operaciones sobre los paquete de viaje:

- confirmar() - formaliza la reserva del paquete solicitado si su situación actual lo permite.
- cancelar() - anula la reserva del paquete con una penalización que varía según su situación actual.
- calcularPrecio() - calcula y retorna el precio efectivo, que varía según la situación actual del paquete.
- generarResumen() - produce un texto descriptivo del paquete.

Se presentan dos posibles implementaciones:

`OPCIÓN A`

```java
public class PaqueteViaje {
    private String estado = "PENDIENTE";
    private EstrategiaReserva estrategia;
    private PlataformaPago plataformaPago;
    private double precioBase;

    public PaqueteViaje(double precioBase, PlataformaPago plataformaPago) {
        this.precioBase = precioBase;
        this.plataformaPago= plataformaPago;
        this.estrategia = new EstrategiaPendiente();
    }

    public void setEstrategia(EstrategiaReserva estrategia) {
       this.estrategia = estrategia;
    }

    public void confirmar() {
        if (estado.equals("PENDIENTE") && this.plataformaPago.pagar(this.calcularPrecio())) {
            estado = "CONFIRMADO";
            estrategia = this.setEstrategia(new EstrategiaConfirmado());
        } else {
            System.out.println("No se puede confirmar.");
        }
    }

    public void cancelar() {
        if (estado.equals("PENDIENTE") || estado.equals("CONFIRMADO")) {
            estado = "CANCELADO";
            estrategia = this.setEstretegia(new EstrategiaCancelado());
        } else {
            System.out.println("No se puede cancelar.");
        }
    }

    public double calcularPrecio() {
        return estrategia.calcularPrecio(precioBase);
    }

    public String generarResumen() {
        return estrategia.generarResumen();
    }

}
```

```java
public interface EstrategiaReserva {
    double calcularPrecio(double precioBase);
    String generarResumen();
}
```

```java
public class EstrategiaPendiente implements EstrategiaReserva {

    public double calcularPrecio(double precioBase) {
        return precioBase;
    }

    public String generarResumen() {
        return "Pendiente";
    }

}

public class EstrategiaConfirmado implements EstrategiaReserva {

    public double calcularPrecio(double precioBase) {
        return precioBase * 1.05;
    }

    public String generarResumen() {
        return "Confirmado";
    }

}

public class EstrategiaCancelado implements EstrategiaReserva {

    public double calcularPrecio(double precioBase) {
        return 0;
    }
    public String generarResumen() {
        return "Cancelado";
    }

}
```

```java
public interface PlataformaPago {
    public boolean pagar(double monto);
}
```

### Tareas

Responda a las siguientes preguntas:

1. ¿La variable estado, implementa correctamente el patrón State? Responda si o no.

   Rta: No, la variable estado no implementa de manera correcta el patrón State.

2. ¿Respecto del patrón State, es correcto que la misma clase PaqueteViaje implemente el comportamiento a realizar según el estado? Responda si o no.

   Rta: No, el objetivo del patrón State es que el contexto (en este caso la clase PaqueteViaje) pueda delegar la implementación del comportamiento a las clases concretas de estado.

3. Realice el diagrama UML del código. Si ud. considera que el patrón State está presente, marque los roles que se encuentran implementados. En caso de que no existan, adecue el diseño para que se implemente correctamente.

![uml](<27a - PaquetesDeViaje.jpg>)

4. ¿La variable estrategia, implementa correctamente el patrón Strategy? Responda si o no.

   No, la variable estrategia estaba en realidad intentando aplicar el patrón State aunque estaba mal nombrada y el patrón mal implementado.

5. Explique con sus palabras cual es el objetivo del patrón Strategy

   El objetivo del patrón Strategy es delegar los detalles de implementación de una funcionalidad a otra clase, encapsulando distintas formas de resolver un mismo problema que pueden ser intercambiables en tiempo de ejecución.

`OPCIÓN B`

```java
public class PaqueteViaje {
private EstadoReserva estado;
private PlataformaPago plataformaPago;
private double precioBase;

    public PaqueteViaje(double precioBase, PlataformaPago plataformaPago) {
        this.precioBase = precioBase;
        this.plataformaPago= plataformaPago;
        this.estado = new EstadoPendiente();
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void confirmar() {
        estado.confirmar(this);
    }

    public void cancelar() {
        estado.cancelar(this);
    }

    public double calcularPrecio() {
        return estado.calcularPrecio(this);
    }

    public String generarResumen() {
        return estado.generarResumen(this);
    }

}
```

```java
public interface EstadoReserva {
    void confirmar(PaqueteViaje paquete);
    void cancelar(PaqueteViaje paquete);
    double calcularPrecio(PaqueteViaje paquete);
    String generarResumen(PaqueteViaje paquete);
}
```

```java
public class EstadoPendiente implements EstadoReserva {

    public void confirmar(PaqueteViaje p) {
        if (p.getPlataformaPago().pagar(p.calcularPrecio())){
          p.setEstado(new EstadoConfirmado());
          System.out.println("Confirmada.");
        }
    }

    public void cancelar(PaqueteViaje p) {
        p.setEstado(new EstadoCancelado());
        System.out.println("Cancelado sin penalización.");
    }

    public double calcularPrecio(PaqueteViaje p) {
        return p.getPrecioBase();
    }

    public String generarResumen(PaqueteViaje p) {
        return "Pendiente";
    }

}

public class EstadoConfirmado implements EstadoReserva {

    public void confirmar(PaqueteViaje p) {
        System.out.println("Ya está confirmada.");
    }

    public void cancelar(PaqueteViaje p) {
        p.setEstado(new EstadoCancelado());
        System.out.println("Cancelado con penalización del 20%.");
    }

    public double calcularPrecio(PaqueteViaje p) {
        return p.getPrecioBase() * 1.05;
    }

    public String generarResumen(PaqueteViaje p) {
        return "Confirmado";
    }

}

public class EstadoCompletado implements EstadoReserva {

    public void confirmar(PaqueteViaje p) {
        System.out.println("El viaje ya se realizó.");
    }

    public void cancelar(PaqueteViaje p) {
        System.out.println("No se puede cancelar: completado.");
    }

    public double calcularPrecio(PaqueteViaje p) {
        return p.getPrecioBase() * 1.05;
    }

    public String generarResumen(PaqueteViaje p) {
        return "Completado";
    }

}

public class EstadoCancelado implements EstadoReserva {

    public void confirmar(PaqueteViaje p) {
        System.out.println("No se puede confirmar: cancelado.");
    }

    public void cancelar(PaqueteViaje p) {
        System.out.println("Ya está cancelado.");
    }

    public double calcularPrecio(PaqueteViaje p) {
        return 0;
    }

    public String generarResumen(PaqueteViaje p) {
        return "Cancelado";
    }

}
```

```java
public interface PlataformaPago {
    public boolean pagar(double monto);
}
```

### Tareas

Responda a las siguientes preguntas:

1. ¿La variable estado, implementa correctamente el patrón State?. Responda si o no.

   Sí, la variable estado implementa correctamente el patrón State.

2. ¿Respecto del patrón State, es correcto crear diferentes clases para implementar el comportamiento a realizar según el estado?. Responda si o no.

   Sí, el objetivo del patrón State es que una clase pueda delegar la implementación de una funcionalidad de acuerdo al estado en el que se encuentra. Para eso deben existir múltiples estados que resuelvan la implementación de diferente manera de acuerdo a lo necesario.

3. Si la respuesta anterior es NO, realice el diagrama UML con clases y roles para implementar correctamente el patrón State.
4. ¿Existe en el código alguna implementación del patrón Strategy? Responda si o no.

   Está implementado si faltan las concrete strategies?

5. Si respondió SÍ indique donde está implementado el patrón. Indique los roles de cada clase.

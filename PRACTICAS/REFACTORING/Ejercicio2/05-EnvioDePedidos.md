# 2.5 Envío de pedidos

<div align='center'> 

![](/Ejercicio2/images/ej5.png)
</div>

~~~java
public class Supermercado {
   public void notificarPedido(long nroPedido, Cliente cliente) {
     String notificacion = MessageFormat.format(“Estimado cliente, se le informa que hemos recibido su pedido con número {0}, el cual será enviado a la dirección {1}”, new Object[] { nroPedido, cliente.getDireccionFormateada() });

     // lo imprimimos en pantalla, podría ser un mail, SMS, etc..
    System.out.println(notificacion);
  }
}

public class Cliente {
   public String getDireccionFormateada() {
	return 
		this.direccion.getLocalidad() + “, ” +
		this.direccion.getCalle() + “, ” +
		this.direccion.getNumero() + “, ” +
		this.direccion.getDepartamento();
   }
}
~~~

<u><i>Code smells</i></u> </br>
   * Inappropriate Intimacy.
   * Feature Envy.
</br> 

<u><i>Refactoring</i></u> </br>
   * Move Field.
</br> 

<i>Solución:</i></br>
Utilizo el refactoring "Move Field" para transferirlos a la clase Cliente y eliminar de esa manera el Feature Envy y la Inappropriate Intimacy. 

~~~java
public class Supermercado {
   public void notificarPedido(long nroPedido, Cliente cliente) {
     String notificacion = MessageFormat.format(“Estimado cliente, se le informa que hemos recibido su pedido con número {0}, el cual será enviado a la dirección {1}”, new Object[] { nroPedido, cliente.getDireccionFormateada() });

     // lo imprimimos en pantalla, podría ser un mail, SMS, etc..
    System.out.println(notificacion);
  }
}

public class Cliente {
    public String localidad; 
    public String calle; 
    public String numero;
    public String departamento; 

    public String getDireccionFormateada() {
	    return 
            localidad + “, ” +
            calle + “, ” +
            numero + “, ” +
            departamento;
   }

   public class Direccion {
        public String localidad; 
        public String calle; 
        public String numero;
        public String departamento; 
   }
}
~~~
<div align='center'> 

![](/Ejercicio2/images/ej5ref1.png)
</div>

<u><i>Code smells</i></u> </br>
   * Lazy Class.
</br> 

<u><i>Refactoring</i></u> </br>
   * Eliminar la clase.
</br> 

<i>Solución:</i></br>
Elimino la clase "Direccion" ya que no es de utilidad. 

~~~java
public class Supermercado {
   public void notificarPedido(long nroPedido, Cliente cliente) {
     String notificacion = MessageFormat.format(“Estimado cliente, se le informa que hemos recibido su pedido con número {0}, el cual será enviado a la dirección {1}”, new Object[] { nroPedido, cliente.getDireccionFormateada() });

     // lo imprimimos en pantalla, podría ser un mail, SMS, etc..
    System.out.println(notificacion);
  }
}

public class Cliente {
    private String localidad; 
    private String calle; 
    private String numero;
    private String departamento; 

    public String getDireccionFormateada() {
	    return 
            localidad + “, ” +
            calle + “, ” +
            numero + “, ” +
            departamento;
   }
}
~~~
<div align='center'> 

![](/Ejercicio2/images/ej5ref2.png)
</div>

<u><i>Code smells</i></u> </br>
   * Public Field.
</br> 

<u><i>Refactoring</i></u> </br>
   * Encapsulate Field.
</br> 

<i>Solución:</i></br>
Cambio la visibilidad de los atributos de la clase Cliente.
<div align='center'> 

![](/Ejercicio2/images/ej5ref3.png)
</div>
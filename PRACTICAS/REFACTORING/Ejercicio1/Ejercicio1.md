# 1.1	Protocolo de Cliente. 
La clase Cliente tiene el siguiente protocolo. ¿Cómo puede mejorarlo?

~~~java
/** 
* Retorna el límite de crédito del cliente
*/
public double lmtCrdt() {...

/** 
* Retorna el monto facturado al cliente desde la fecha f1 a la fecha f2
*/
protected double mtFcE(LocalDate f1, LocalDate f2) {...

/** 
* Retorna el monto cobrado al cliente desde la fecha f1 a la fecha f2
*/
private double mtCbE(LocalDate f1, LocalDate f2) {...
~~~

<u><i>Code smells</i></u> </br>
  * Nombres poco descriptivos. 
</br> </br>

<i>Solución:<i>

~~~java 
/** 
* Retorna el límite de crédito del cliente
*/
public double getLimiteDeCredito() {...

/** 
* Retorna el monto facturado al cliente desde la fecha f1 a la fecha f2
*/
protected double calcularMontoFacturado(LocalDate f1, LocalDate f2) {...

/** 
* Retorna el monto cobrado al cliente desde la fecha f1 a la fecha f2
*/
private double calcularMontoCobrado(LocalDate f1, LocalDate f2) {...

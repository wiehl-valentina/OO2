# 1.1 Protocolo de Cliente
La clase Cliente tiene el siguiente protocolo. ¿Cómo puede mejorarlo? 

```java
/** 
* Retorna el límite de crédito del cliente
**/
public double lmtCrdt() {...}

/** 
* Retorna el monto facturado al cliente desde la fecha f1 a la fecha f2
*/
protected double mtFcE(LocalDate f1, LocalDate f2) {...}

/** 
* Retorna el monto cobrado al cliente desde la fecha f1 a la fecha f2
*/
private double mtCbE(LocalDate f1, LocalDate f2) {...} 
```

## Code smells

### 1. Nombres de métodos poco explicativos.

#### Resolución: aplicar el refactoring <i>Rename Method</i>. 

1. Cambio el nombre del método en todos los lugares donde sea referenciado por otro que sea más explicativo respecto a lo que hace el método.

```java
/** 
* Retorna el límite de crédito del cliente
**/
public double limiteCredito() {...}

/** 
* Retorna el monto facturado al cliente desde la fecha f1 a la fecha f2
*/
protected double montoFacturadoEnPeriodo(LocalDate f1, LocalDate f2) {...}

/** 
* Retorna el monto cobrado al cliente desde la fecha f1 a la fecha f2
*/
private double montoCobradoEnPeriodo(LocalDate f1, LocalDate f2) {...} 
```

### 2. Nombres de parámetros poco descriptivos.

#### Resolución: renombrar parámetros.

1. Cambio el nombre de los parámetros por otros más descriptivos.

```java
/** 
* Retorna el límite de crédito del cliente
**/
public double limiteCredito() {...}

/** 
* Retorna el monto facturado al cliente desde la fecha f1 a la fecha f2
*/
protected double montoFacturadoEnPeriodo(LocalDate fechaInicio, LocalDate fechaFin) {...}

/** 
* Retorna el monto cobrado al cliente desde la fecha f1 a la fecha f2
*/
private double montoCobradoEnPeriodo(LocalDate fechaInicio, LocalDate fechaFin) {...} 
```


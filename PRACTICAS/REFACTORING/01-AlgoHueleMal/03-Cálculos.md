# 1.3 Cálculos 
Analice el código que se muestra a continuación. Indique qué code smells encuentra y cómo pueden corregirse.						
```java
public void imprimirValores() {
	int totalEdades = 0;
	double promedioEdades = 0;
	double totalSalarios = 0;
	
	for (Empleado empleado : personal) {
		totalEdades = totalEdades + empleado.getEdad();
		totalSalarios = totalSalarios + empleado.getSalario();
	}
	promedioEdades = totalEdades / personal.size();
		
	String message = String.format("El promedio de las edades es %s y el total de salarios es %s",        promedioEdades, totalSalarios);
	
	System.out.println(message);
}
```

## Code smells
### 1. Imperative Loops. El cálculo promedio de edades puede simplificarse usando streams.
#### Resolución: aplicar <i>Replace Loop with Pipeline</i>.
```java
public void imprimirValores() {
	double totalSalarios = 0;
	double promedioEdades = this.personal.streams().mapToDouble(empleado -> empleado.getEdad()).average().orElse(0); 
	
	String message = String.format("El promedio de las edades es %s y el total de salarios es %s",        promedioEdades, totalSalarios);
	
	System.out.println(message);
}
```

### 2. Imperative Loops. El cálculo total de salarios también puede realizarse de forma más sencilla usando streams.
#### Resolución: aplicar <i>Replace Loop with Pipeline</i>.
```java
public void imprimirValores() {
	double totalSalarios = this.personal.streams().mapToDouble(empleado -> empleado.getSalario()).sum(); 
	double promedioEdades = this.personal.streams().mapToDouble(empleado -> empleado.getEdad()).average().orElse(0); 
	
	String message = String.format("El promedio de las edades es %s y el total de salarios es %s",        promedioEdades, totalSalarios);
	
	System.out.println(message);
}
```

### 3. Long Method. El método hace varias cosas y sería mejor descomponerlo en varios métodos más pequeños y específicos.
#### Resolución: aplicar <i>Extract Method</i> dos veces.
```java
public void imprimirValores() {
	String message = String.format("El promedio de las edades es %s y el total de salarios es %s",        calcularPromedioEdades(), calcularTotalSalarios());
	
	System.out.println(message);
}

public double calcularTotalSalarios() {
    double totalSalarios = this.personal.streams().mapToDouble(empleado -> empleado.getSalario()).sum(); 
    return totalSalarios; 
}

public double calcularPromedioEdades() {
    double promedioEdades = this.personal.streams().mapToDouble(empleado -> empleado.getEdad()).average().orElse(0); 
    return promedioEdades;  
}
```
### 4. Long Method. El método imprimirValores() todavía hace demasiadas cosas juntas.
#### Resolución: aplicar <i>Extract Method</i> para tener dos métodos cortos que puedan ser utilizados por separado en otros lugares del programa.
```java
public void imprimirValores() {
	String message = String.format("El promedio de las edades es %s", calcularPromedioEdades());
	System.out.println(message);
}

public void imprimirTotalSalarios() {
    String message = String.format("El total de salarios es %s", calcularTotalSalarios());
    System.out.println(message);
}

public double calcularTotalSalarios() {
    double totalSalarios = this.personal.streams().mapToDouble(empleado -> empleado.getSalario()).sum(); 
    return totalSalarios; 
}

public double calcularPromedioEdades() {
    double promedioEdades = this.personal.streams().mapToDouble(empleado -> empleado.getEdad()).average().orElse(0); 
    return promedioEdades;  
}
```

### 5. Uncommunicative Name. El nombre del método imprimirValores() es poco descriptivo.
#### Resolución: aplicar <i>Rename Method</i>.
```java
public void imprimirPromedioEdades() {
	String message = String.format("El promedio de las edades es %s", calcularPromedioEdades());
	System.out.println(message);
}

public void imprimirTotalSalarios() {
    String message = String.format("El total de salarios es %s", calcularTotalSalarios());
    System.out.println(message);
}

public double calcularTotalSalarios() {
    double totalSalarios = this.personal.streams().mapToDouble(empleado -> empleado.getSalario()).sum(); 
    return totalSalarios; 
}

public double calcularPromedioEdades() {
    double promedioEdades = this.personal.streams().mapToDouble(empleado -> empleado.getEdad()).average().orElse(0); 
    return promedioEdades;  
}
```

### 6. Uso de variables temporales innecesarias. 
#### Resolución: aplicar <i>Inline Temp</i> en los cuatro métodos para deshacerse de las variables temporales en cada uno de ellos.
```java
public void imprimirPromedioEdades() {
	System.out.println("El promedio de las edades es " + calcularPromedioEdades());
}

public void imprimirTotalSalarios() {
    System.out.println("El total de salarios es " + calcularTotalSalarios());
}

public double calcularTotalSalarios() {
    return this.personal.streams().mapToDouble(empleado -> empleado.getSalario()).sum();
}

public double calcularPromedioEdades() {
    return this.personal.streams().mapToDouble(empleado -> empleado.getEdad()).average().orElse(0);  
}
```
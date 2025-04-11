# 1.3 Cálculos 
Analice el código que se muestra a continuación. Indique qué code smells encuentra y cómo pueden corregirse.	

~~~java  public void imprimirValores() {
	int totalEdades = 0;
	double promedioEdades = 0;
	double totalSalarios = 0;
	
	for (Empleado empleado : personal) {
		totalEdades = totalEdades + empleado.getEdad();
		totalSalarios = totalSalarios + empleado.getSalario();
	}
	promedioEdades = totalEdades / personal.size();
		
	String message = String.format("El promedio de las edades es %s y el total de salarios es %s", promedioEdades, totalSalarios);
	
	System.out.println(message);
} 
~~~

<u><i>Code smells</i></u> </br>
  * Long Method. </br>
  * Nombre de método poco descriptivo. 
</br> </br>

Es importante corregir el nombre del método, ya que es poco descriptivo respecto a lo que hace. Podría reemplazarse por ejemplo por imprimirEdadesYTotalSalarios().
En segundo lugar, el método imprimirValores() hace demasiadas cosas. Su tarea puede descomponerse en otros métodos más pequeños que estén bien nombrados y hagan uso de herramientas como los streams, haciendo que el código sea más limpio y fácil de entender.

<i>Solución:<i>

~~~java
public void imprimirPromedioEdadesYTotalSalarios() {	
	System.out.println(String.format("El promedio de las edades es %s y el total de salarios es %s", calcularPromedioDeEdades(), calcularTotalSalarios()));
}

public double calcularTotalSalarios() {
    return personal.stream()
        .mapToDouble(empleado -> empleado.getSalario())
        .sum(); 
}

public int calcularTotalEdades() {
    return personal.stream()
        .mapToInt(empleado -> empleado.getEdad())
        .sum(); 
}

public double calcularPromedioDeEdades() {
    return calcularTotalEdades()/personal.size(); 
}
~~~




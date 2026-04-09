# Ejercicio 5: Productos
Se cuenta con un sistema que maneja una jerarquía de productos que pueden ser estadías de hoteles o alquileres de autos. En el siguiente material adicional puede descargar un proyecto con las clases implementadas. Observe que el proyecto cuenta con test unitarios que verifican el funcionamiento correcto de la aplicación. A continuación se muestra un extracto del código:

```java
public class HotelStay extends Product {
    public double cost;
    private TimePeriod timePeriod;
    private Hotel hotel;

    public HotelStay(double cost, TimePeriod timePeriod, Hotel hotel) {
        this.cost = cost;
        this.timePeriod = timePeriod;
        this.hotel = hotel;
    }

    public LocalDate startDate() {
        return this.timePeriod.start();
    }

    public LocalDate endDate() {
        return this.timePeriod.end();
    }

    public double priceFactor() {
        return this.cost / this.price();
    }

    public double price() {
        return this.timePeriod.duration() * this.hotel.nightPrice() * this.hotel.discountRate();
    }
}

public class CarRental extends Product {
    public double cost;
    private TimePeriod timePeriod;
    private Company company;

  public CarRental(double cost, TimePeriod timePeriod, Company company) {
        this.cost = cost;
        this.timePeriod = timePeriod;
        this.company = company;
    }

    public LocalDate startDate() {
        return this.timePeriod.start();
    }

    public LocalDate endDate() {
        return this.timePeriod.end();
    }

    public double price() {
        return this.company.price() * this.company.promotionRate();
    }

    public double cost() {
        return this.cost;
    }
}
```

### Tareas
1. La variable “cost” está declarada como pública, lo que rompe el encapsulamiento de la clase. Utilice el refactoring Encapsulate Field y describa brevemente los pasos llevados a cabo. Verifique que los tests provistos sigan funcionando. Discuta con un ayudante:

    * ¿Es correcto modificar alguno de los tests para que el código refactorizado funcione?

    * En caso de qué el test falle, ¿qué situación está representando este test?
2. Utilice el refactoring Rename Field en el método priceFactor(), para que la variable “cost” se pase a llamar “quote”. Verifique que los tests provistos sigan funcionando. Discuta con un ayudante: ¿en este caso, es necesario modificar alguno de los tests para que el código refactorizado funcione?
3. Se quiere aplicar el refactoring Pull Up Method para subir los métodos startDate() y endDate() a la superclase Product. ¿Es posible hacerlo en el código anterior? Justifique su respuesta basándose en las precondiciones del refactoring vistas en la teoría y en el libro de Refactoring de Martin Fowler.
4. Mencione y aplique los refactorings necesarios para poder hacer Pull Up Method.
5. Aplique Pull Up Method para subir los métodos a la superclase Product. Verifique que los tests provistos sigan funcionando.
6. Observe los métodos price() en CarRental.java (línea 21) y en HotelStay.java (línea 25). Identifique los Code Smell presentes. Luego aplique los refactoring correspondientes para eliminarlos. Verifique que los tests provistos sigan funcionando.

#### Resolución
1. Pasos para aplicar `Encapsulate Field`
    
    1. Creo getter y setter para la variable "cost" la cual está declarada como pública.

    2. Reemplazo todas las invocaciones a la variable con el getter y modifico todas las asignaciones para hacerlo con el setter. 
    3. Una vez que hice todos los reemplazos, cambio la declaración de la variable a privada y testeo.

    Sí, se debe modificar el método testCost() de la clase HotelStayTest para reemplazar la invocación a la variable cost por su getter.

2. No es necesario modificar ninguno de los tests para que el código refactorizado funcione debido a que los mismos operan con el getter de la variable quote y por lo tanto no perciben el cambio de nombre en la misma. 

3. No es posible aplicar `Pull Up Method` en los métodos startDate() y endDate() debido a que ambos operan sobre la variable timePeriod perteneciente a ambas subclases. Para poder llevar `Pull Up Method` a cabo las variables sobre las que opera el método deben encontrarse en la superclase.

4. Antes de aplicar `Pull Up Method` sobre starDate() y endDate() es necesario aplicar `Pull Up Field` sobre la variable timePeriod perteneciente a ambas subclases.

5. Los tests siguen funcionando sin problema.

6. CarRental.java: el método price() presenta envidia de atributos debido a que opera con las variables de instancia de la clase Company. Para eliminar este code smell primero aplico `Move Method` para moverlo a la clase Company y luego aplico `Rename Method` para cambiar el nombre price() por getCost() debido a que la clase ya posee un método llamado price().

    HotelStay.java: el método price() presenta envidia de atributos porque opera con variables de instancia de la clase Hotel. Para resolverlo primero aplico `Extract Method` sobre el fragmento del código que manipula las variables de la clase Hotel y luego aplico `Move Method` al método extraído.
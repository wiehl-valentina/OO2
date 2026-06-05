# Ejercicio 27b: Gestión de paquetes de viaje

La agencia ha contratado una pasarela de pago externa de un proveedor tercero para procesar el cobro en el momento de confirmar una reserva. La interfaz de dicha pasarela utiliza mensajes en inglés. Ni la pasarela contratada ni la clase PaqueteViaje pueden ser modificadas.

Teniendo en cuenta ambas implementaciones (opción A y B), responda:

1. ¿Qué patrón puede utilizar para resolver este problema? Indique el nombre del patrón.

   El patrón que puede ser utilizado para resolver el problema es el Adapter.

2. ¿Qué problema resuelve el patrón indicado?

   El patrón Adapter resuelve problemas de incompatibilidad de interfaces. Traduce la interfaz de una clase que se desea usar pero difiere con la que espera el cliente para que pueda ser utilizada.

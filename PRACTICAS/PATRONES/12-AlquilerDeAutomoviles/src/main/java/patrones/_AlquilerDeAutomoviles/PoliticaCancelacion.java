package patrones._AlquilerDeAutomoviles;

import java.time.LocalDate;

public interface PoliticaCancelacion {
	
	 public double calcularReembolso(Reserva reserva, LocalDate fechaCancelacion);

}

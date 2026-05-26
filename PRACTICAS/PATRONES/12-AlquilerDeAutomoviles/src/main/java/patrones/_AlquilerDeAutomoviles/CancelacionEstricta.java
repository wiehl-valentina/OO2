package patrones._AlquilerDeAutomoviles;

import java.time.LocalDate;

public class CancelacionEstricta implements PoliticaCancelacion {
	
	public double calcularReembolso(Reserva reserva, LocalDate fechaCancelacion) {
		return 0;
	}

}

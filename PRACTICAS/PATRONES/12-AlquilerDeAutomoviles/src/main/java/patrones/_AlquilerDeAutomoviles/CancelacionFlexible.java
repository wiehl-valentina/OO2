package patrones._AlquilerDeAutomoviles;

import java.time.LocalDate;

public class CancelacionFlexible implements PoliticaCancelacion{

	public double calcularReembolso(Reserva reserva, LocalDate fechaCancelacion) {
		if (fechaCancelacion.isBefore(reserva.getFecha()))
			return reserva.montoAPagar();
		return 0;
	}
	
}

package patrones._AlquilerDeAutomoviles;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CancelacionModerada implements PoliticaCancelacion {

	public double calcularReembolso(Reserva reserva, LocalDate fechaReserva) {
		if (ChronoUnit.DAYS.between(fechaReserva, reserva.getFecha()) >= 7)
			return reserva.montoAPagar();
		if (ChronoUnit.DAYS.between(fechaReserva, reserva.getFecha()) >= 2)
			return reserva.montoAPagar()/2.0;
		return 0;
	}
	
}

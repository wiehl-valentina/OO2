package patrones.B_LineaDeProduccion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProcessStepExtTest {

	@Test
    public void testLightMixExecuteExito() {
        // Happy Path: El FakeTank funciona perfecto y calculará +10 grados en 2s.
        FakeMixingTank tank = new FakeMixingTank();
        LightMix lightMix = new LightMix();

        lightMix.execute(tank);

        assertTrue(lightMix.isDone());
    }

    @Test
    public void testLightMixExecuteFallaPorCalentadorRoto() {
        // Sobrescribimos el Fake al vuelo (Clase Anónima) para simular una rotura de hardware
        FakeMixingTank tanqueRoto = new FakeMixingTank() {
            @Override
            public boolean heatPower(int percentage) {
                return false; // El calentador recibe la orden pero no hace nada
            }
        };
        LightMix lightMix = new LightMix();

        lightMix.execute(tanqueRoto);

        // Como no calentó, la diferencia no será 10 y debe dar false
        assertFalse(lightMix.isDone()); 
    }

    // ==========================================
    // TESTS PARA PURGE
    // ==========================================

    @Test
    public void testPurgeExecuteExito() {
        FakeMixingTank tank = new FakeMixingTank(); // Arranca con volumen 100
        Purge purge = new Purge();

        purge.execute(tank); // Tardará 4 segundos reales de test en ejecutarse

        assertTrue(purge.isDone());
        assertEquals(0.0, tank.upTo()); // Verificamos que quedó vacío
    }

    @Test
    public void testPurgeExecuteFallaTanqueYaVacio() {
        FakeMixingTank tank = new FakeMixingTank();
        tank.vaciarTanque(); // Precondición: el tanque ya estaba vacío
        
        Purge purge = new Purge();

        purge.execute(tank);

        // El pseudocódigo dice que si el volumen ya era 0, retorna false de inmediato
        assertFalse(purge.isDone());
    }
    
    @Test
    public void testPurgeExecuteFallaObstruccion() {
        // Simulamos un tanque con la válvula tapada (nunca se vacía)
        FakeMixingTank tanqueTapado = new FakeMixingTank() {
            @Override
            public double upTo() { return 50.0; } // Siempre devuelve 50
        };
        
        Purge purge = new Purge();

        purge.execute(tanqueTapado);

        assertFalse(purge.isDone());
    }
}

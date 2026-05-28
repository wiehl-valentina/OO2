package patrones._LineaDeProduccion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProcessStepTest {

	private MixingTankMock tankMock;
    private LightMix lightMix;

    @BeforeEach
    public void setUp() {
        // Instanciamos nuestro propio Mock
        tankMock = new MixingTankMock(); 
        lightMix = new LightMix();
    }

    @Test
    public void testLightMixExecuteExito() {
        // 1. Arrange: Configuramos el STUB (Happy path por defecto ya es true)
        tankMock.setHeatPowerResponse(true);
        tankMock.setMixerPowerResponse(true);

        // 2. Act: Ejecutamos el método
        lightMix.execute(tankMock);

        // 3. Assert (State Verification): Verificamos el estado final del proceso
        assertTrue(lightMix.isDone());
        
        // 4. Assert (Behavior Verification): ¡Acá actúa el MOCK! 
        // Le preguntamos al tanque si la receta que le mandaron fue la correcta.
        assertTrue(tankMock.verifyHeatPowerCalledWith(20));
        assertTrue(tankMock.verifyMixerPowerCalledWith(5));
    }

    @Test
    public void testLightMixExecuteFallaCalentador() {
        // 1. Arrange: Forzamos que el tanque falle al prender el calor
        tankMock.setHeatPowerResponse(false);

        // 2. Act
        lightMix.execute(tankMock);

        // 3. Assert: Como falló el calor, el paso completo debe dar false
        assertFalse(lightMix.isDone());
        
        // Comprobamos que sí se intentó prender el calor con 20
        assertTrue(tankMock.verifyHeatPowerCalledWith(20));
        
        // Como hubo falla y usamos && (short-circuit), la mezcladora NUNCA debió prenderse
        assertTrue(tankMock.verifyMixerPowerCalledWith(-1)); // -1 es el valor inicial intocado
    }

}

package patrones.B_LineaDeProduccion;

public class FakeMixingTank extends MixingTank {
    
    private double temperaturaBase = 20.0;
    private double volumen = 100.0; // Arranca lleno
    
    // Variables para simular el tiempo
    private long tiempoInicioCalor = 0;
    private int potenciaActualCalor = 0;
    
    private long tiempoInicioPurga = 0;
    private boolean purgando = false;

    @Override
    public boolean heatPower(int percentage) {
        // Antes de cambiar la potencia, consolidamos la temperatura actual
        this.temperaturaBase = this.temperature(); 
        this.potenciaActualCalor = percentage;
        this.tiempoInicioCalor = System.currentTimeMillis();
        return true;
    }

    @Override
    public double temperature() {
        if (potenciaActualCalor == 0 || tiempoInicioCalor == 0) {
            return temperaturaBase;
        }
        
        long milisegundosPasados = System.currentTimeMillis() - tiempoInicioCalor;
        // Usamos Math.round para evitar fallas por milisegundos desfasados en el procesador
        long segundos = Math.round(milisegundosPasados / 1000.0);
        
        int aumentoPorSegundo = 0;
        if (potenciaActualCalor == 100) aumentoPorSegundo = 5;
        else if (potenciaActualCalor == 75) aumentoPorSegundo = 4;
        else if (potenciaActualCalor == 50) aumentoPorSegundo = 2;
        else if (potenciaActualCalor == 25) aumentoPorSegundo = 1;

        return temperaturaBase + (segundos * aumentoPorSegundo);
    }

    @Override
    public boolean purge() {
        this.purgando = true;
        this.tiempoInicioPurga = System.currentTimeMillis();
        return true;
    }

    @Override
    public double upTo() {
        if (purgando) {
            long milisegundosPasados = System.currentTimeMillis() - tiempoInicioPurga;
            long segundos = Math.round(milisegundosPasados / 1000.0);
            
            if (segundos >= 4) {
                this.volumen = 0; // Se vació por completo
                this.purgando = false;
            }
        }
        return this.volumen;
    }

    @Override
    public boolean mixerPower(int percentage) { return true; }

    // --- MÉTODOS EXTRA PARA LOS TESTS ---
    public void vaciarTanque() { this.volumen = 0; }
}
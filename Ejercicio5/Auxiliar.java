package Ejercicio5;
public class Auxiliar extends Jugador {
    private int ataquesEfectivos;
    private int bloqueosEfectivos;
    private int bloqueosFallidos;

    public Auxiliar(String nombre, String pais, int errores, int aces, int totalServicios, int ataquesEfectivos, int bloqueosEfectivos, int bloqueosFallidos) {
        super(nombre, pais, errores, aces, totalServicios);
        this.ataquesEfectivos = ataquesEfectivos;
        this.bloqueosEfectivos = bloqueosEfectivos;
        this.bloqueosFallidos = bloqueosFallidos;
    }

    @Override
    public double calcularEfectividad() {
        return super.calcularEfectividad() + ((ataquesEfectivos + bloqueosEfectivos - bloqueosFallidos - getErrores()) * 100.0 / (ataquesEfectivos + bloqueosEfectivos + bloqueosFallidos + getErrores()));
    }

    public int getAtaquesEfectivos() {
        return ataquesEfectivos;
    }

    public void setAtaquesEfectivos(int ataquesEfectivos) {
        this.ataquesEfectivos = ataquesEfectivos;
    }

    public int getBloqueosEfectivos() {
        return bloqueosEfectivos;
    }

    public void setBloqueosEfectivos(int bloqueosEfectivos) {
        this.bloqueosEfectivos = bloqueosEfectivos;
    }

    public int getBloqueosFallidos() {
        return bloqueosFallidos;
    }

    public void setBloqueosFallidos(int bloqueosFallidos) {
        this.bloqueosFallidos = bloqueosFallidos;
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + ataquesEfectivos + "," + bloqueosEfectivos + "," + bloqueosFallidos;
    }

    public static Auxiliar fromCSV(String csv) {
        Jugador jugador = Jugador.fromCSV(csv);
        if (jugador != null) {
            String[] partes = csv.split(",");
            if (partes.length != 8) {
                return null; // Error en el formato CSV
            }
            int ataquesEfectivos = Integer.parseInt(partes[5]);
            int bloqueosEfectivos = Integer.parseInt(partes[6]);
            int bloqueosFallidos = Integer.parseInt(partes[7]);
            return new Auxiliar(jugador.getNombre(), jugador.getPaís(), jugador.getErrores(), jugador.getAces(), jugador.getTotalServicios(), ataquesEfectivos, bloqueosEfectivos, bloqueosFallidos);
        }
        return null;
    }

    @Override
    public String toString() {
        return super.toString() + ", Ataques Efectivos: " + ataquesEfectivos + ", Bloqueos Efectivos: " + bloqueosEfectivos + ", Bloqueos Fallidos: " + bloqueosFallidos;
    }
}

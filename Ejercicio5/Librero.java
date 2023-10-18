package Ejercicio5;
class Libero extends Jugador {
    private int recibosEfectivos;

    public Libero(String nombre, String país, int errores, int aces, int totalServicios, int recibosEfectivos) {
        super(nombre, país, errores, aces, totalServicios);
        this.recibosEfectivos = recibosEfectivos;
    }

    @Override
    public double calcularEfectividad() {
        return super.calcularEfectividad() + (recibosEfectivos * 100.0 / getTotalServicios());
    }

    public int getRecibosEfectivos() {
        return recibosEfectivos;
    }

    public void setRecibosEfectivos(int recibosEfectivos) {
        this.recibosEfectivos = recibosEfectivos;
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + recibosEfectivos;
    }

    public static Libero fromCSV(String csv) {
        Jugador jugador = Jugador.fromCSV(csv);
        if (jugador != null) {
            String[] partes = csv.split(",");
            if (partes.length != 6) {
                return null; // Error en el formato CSV
            }
            int recibosEfectivos = Integer.parseInt(partes[5]);
            return new Libero(jugador.getNombre(), jugador.getPaís(), jugador.getErrores(), jugador.getAces(), jugador.getTotalServicios(), recibosEfectivos);
        }
        return null;
    }

    @Override
    public String toString() {
        return super.toString() + ", Recibos Efectivos: " + recibosEfectivos;
    }
}

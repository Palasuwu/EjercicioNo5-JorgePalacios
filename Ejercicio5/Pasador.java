package Ejercicio5;
class Pasador extends Jugador {
    private int pases;
    private int fintasEfectivas;

    public Pasador(String nombre, String país, int errores, int aces, int totalServicios, int pases, int fintasEfectivas) {
        super(nombre, país, errores, aces, totalServicios);
        this.pases = pases;
        this.fintasEfectivas = fintasEfectivas;
    }

    @Override
    public double calcularEfectividad() {
        return super.calcularEfectividad() + ((pases + fintasEfectivas - getErrores()) * 100.0 / (pases + fintasEfectivas + getErrores()));
    }

    public int getPases() {
        return pases;
    }

    public void setPases(int pases) {
        this.pases = pases;
    }

    public int getFintasEfectivas() {
        return fintasEfectivas;
    }

    public void setFintasEfectivas(int fintasEfectivas) {
        this.fintasEfectivas = fintasEfectivas;
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + pases + "," + fintasEfectivas;
    }

    public static Pasador fromCSV(String csv) {
        Jugador jugador = Jugador.fromCSV(csv);
        if (jugador != null) {
            String[] partes = csv.split(",");
            if (partes.length != 7) {
                return null; // Error en el formato CSV
            }
            int pases = Integer.parseInt(partes[5]);
            int fintasEfectivas = Integer.parseInt(partes[6]);
            return new Pasador(jugador.getNombre(), jugador.getPaís(), jugador.getErrores(), jugador.getAces(), jugador.getTotalServicios(), pases, fintasEfectivas);
        }
        return null;
    }

    @Override
    public String toString() {
        return super.toString() + ", Pases: " + pases + ", Fintas Efectivas: " + fintasEfectivas;
    }
}
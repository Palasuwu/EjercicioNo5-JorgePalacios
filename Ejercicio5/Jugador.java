package Ejercicio5;
class Jugador {
    private String nombre;
    private String país;
    private int errores;
    private int aces;
    private int totalServicios;

    public Jugador(String nombre, String país, int errores, int aces, int totalServicios) {
        this.nombre = nombre;
        this.país = país;
        this.errores = errores;
        this.aces = aces;
        this.totalServicios = totalServicios;
    }

    public double calcularEfectividad() {
        return 0.0; // Implementa la fórmula de efectividad en las subclases
    }

    public String getNombre() {
        return nombre;
    }

    public String getPaís() {
        return país;
    }

    public int getErrores() {
        return errores;
    }

    public int getAces() {
        return aces;
    }

    public int getTotalServicios() {
        return totalServicios;
    }

    public String toCSV() {
        return nombre + "," + país + "," + errores + "," + aces + "," + totalServicios;
    }

    public static Jugador fromCSV(String csv) {
        String[] partes = csv.split(",");
        if (partes.length != 5) {
            return null; // Error en el formato CSV
        }

        String nombre = partes[0];
        String país = partes[1];
        int errores = Integer.parseInt(partes[2]);
        int aces = Integer.parseInt(partes[3]);
        int totalServicios = Integer.parseInt(partes[4]);

        return new Jugador(nombre, país, errores, aces, totalServicios);
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                ", País: " + país +
                ", Errores: " + errores +
                ", Aces: " + aces +
                ", Total de Servicios: " + totalServicios;
    }
}
package Ejercicio5;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logica logica = new Logica(); // Cambio de "Torneo" a "Logica"

        int opcion;
        do {
            System.out.println("Menú Principal");
            System.out.println("1. Agregar jugador");
            System.out.println("2. Cargar catálogo desde archivo");
            System.out.println("3. Mostrar jugadores");
            System.out.println("4. Mostrar mejores líberos");
            System.out.println("5. Contar pasadores con efectividad > 80%");
            System.out.println("6. Guardar catálogo en archivo");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.next();
                    System.out.print("País: ");
                    String pais = scanner.next();
                    System.out.print("Errores: ");
                    int errores = scanner.nextInt();
                    System.out.print("Aces: ");
                    int aces = scanner.nextInt();
                    System.out.print("Total de servicios: ");
                    int totalServicios = scanner.nextInt();

                    System.out.println("Selecciona el tipo de jugador:");
                    System.out.println("1. Líbero");
                    System.out.println("2. Pasador");
                    System.out.println("3. Auxiliar/Opuesto");
                    System.out.print("Tipo: ");
                    int tipoJugador = scanner.nextInt();

                    logica.crearYAgregarJugador(tipoJugador, nombre, pais, errores, aces, totalServicios, scanner);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del archivo CSV: ");
                    String archivo = scanner.next();
                    logica.cargarCSV(archivo);
                    break;
                case 3:
                    logica.mostrarJugadores();
                    break;
                case 4:
                    System.out.print("Cantidad de mejores líberos a mostrar: ");
                    int cantidadLiberos = scanner.nextInt();
                    logica.mostrarMejoresLiberos(cantidadLiberos);
                    break;
                case 5:
                    logica.contarPasadoresConEfectividad();
                    break;
                case 6:
                    System.out.print("Ingrese el nombre del archivo CSV para guardar: ");
                    String archivoGuardar = scanner.next();
                    logica.guardarCSV(archivoGuardar);
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }

        } while (opcion != 0);
        scanner.close();
    }
}

package Ejercicio5;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Logica {
    private List<Jugador> jugadores;

    public Logica() {
        jugadores = new ArrayList<>();
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void cargarCSV(String archivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                Jugador jugador = Jugador.fromCSV(linea);
                if (jugador != null) {
                    agregarJugador(jugador);
                }
            }
            System.out.println("Catálogo cargado desde archivo '" + archivo + "'.");
        } catch (IOException e) {
            System.err.println("Error al cargar el catálogo desde archivo: " + e.getMessage());
        }
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void crearYAgregarJugador(int tipoJugador, String nombre, String pais, int errores, int aces, int totalServicios, Scanner scanner) {
        Jugador jugador = null;
        switch (tipoJugador) {
            case 1:
                System.out.print("Recibos efectivos: ");
                int recibosEfectivos = scanner.nextInt();
                jugador = new Libero(nombre, pais, errores, aces, totalServicios, recibosEfectivos);
                break;
            case 2:
                System.out.print("Pases: ");
                int pases = scanner.nextInt();
                System.out.print("Fintas efectivas: ");
                int fintasEfectivas = scanner.nextInt();
                jugador = new Pasador(nombre, pais, errores, aces, totalServicios, pases, fintasEfectivas);
                break;
            case 3:
                System.out.print("Ataques efectivos: ");
                int ataquesEfectivos = scanner.nextInt();
                System.out.print("Bloqueos efectivos: ");
                int bloqueosEfectivos = scanner.nextInt();
                System.out.print("Bloqueos fallidos: ");
                int bloqueosFallidos = scanner.nextInt();
                jugador = new Auxiliar(nombre, pais, errores, aces, totalServicios, ataquesEfectivos, bloqueosEfectivos, bloqueosFallidos);
                break;
            default:
                System.out.println("Tipo de jugador no válido.");
        }
        if (jugador != null) {
            agregarJugador(jugador);
            System.out.println("Jugador agregado al catálogo.");
        }
    }

    public void mostrarJugadores() {
        System.out.println("Lista de jugadores:");
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.toString());
        }
    }

    public List<Libero> obtenerMejoresLiberos(int cantidad) {
        List<Libero> mejoresLiberos = new ArrayList<>();
        List<Libero> listaLiberos = new ArrayList<>();

        for (Jugador jugador : jugadores) {
            if (jugador instanceof Libero) {
                listaLiberos.add((Libero) jugador);
            }
        }

        Collections.sort(listaLiberos, new Comparator<Libero>() {
            @Override
            public int compare(Libero libero1, Libero libero2) {
                return Double.compare(libero2.calcularEfectividad(), libero1.calcularEfectividad());
            }
        });

        for (int i = 0; i < Math.min(cantidad, listaLiberos.size()); i++) {
            mejoresLiberos.add(listaLiberos.get(i));
        }

        return mejoresLiberos;
    }

    public int contarPasadoresConEfectividadMayorA80() {
        int contador = 0;

        for (Jugador jugador : jugadores) {
            if (jugador instanceof Pasador) {
                Pasador pasador = (Pasador) jugador;
                double efectividad = pasador.calcularEfectividad();
                if (efectividad > 80.0) {
                    contador++;
                }
            }
        }

        return contador;
    }

    public void mostrarMejoresLiberos(int cantidad) {
        List<Libero> mejoresLiberos = obtenerMejoresLiberos(cantidad);
        System.out.println("Los " + cantidad + " mejores líberos:");
        for (Libero libero : mejoresLiberos) {
            System.out.println(libero.toString());
        }
    }

    public void contarPasadoresConEfectividad() {
        int cantidad = contarPasadoresConEfectividadMayorA80();
        System.out.println("Cantidad de pasadores con efectividad mayor al 80%: " + cantidad);
    }

    public void guardarCSV(String archivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Jugador jugador : jugadores) {
                writer.write(jugador.toCSV());
                writer.newLine();
            }
            System.out.println("Catálogo guardado en archivo '" + archivo + "'.");
        } catch (IOException e) {
            System.err.println("Error al guardar el catálogo en archivo: " + e.getMessage());
        }
    }
}

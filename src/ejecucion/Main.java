package ejecucion;

import estructuras.ColaPrioridad;
import estructuras.ListaEnlazada;
import modelo.Ticket;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    private static ColaPrioridad colaPendientes = new ColaPrioridad();
    private static ListaEnlazada listaResueltos = new ListaEnlazada();
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;
        while (opcion != 3) {
            System.out.println("Sistema de Ticket");
            System.out.println("1. Menú de Usuario");
            System.out.println("2. Menú de Administrador");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            if (opcion == 1) {
                menuUsuario();
            } else if (opcion == 2) {
                menuAdministrador();
            } else if (opcion != 3) {
                System.out.println("Opción inválida.\n");
            }
        }
        System.out.println("Programa terminado.");
    }

    private static void menuUsuario() {
        int opcion = 0;
        while (opcion != 3) {
            System.out.println("\nMenú de usuario");
            System.out.println("1. Crear Ticket");
            System.out.println("2. Buscar Ticket Resuelto");
            System.out.println("3. Volver");
            System.out.print("Opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            if (opcion == 1) {
                System.out.print("Nombre completo: ");
                String nombre = teclado.nextLine();
                System.out.print("Descripción del problema: ");
                String desc = teclado.nextLine();
                System.out.print("Prioridad (1: Alta, 2: Media, 3: Baja): ");
                int prio = teclado.nextInt();
                teclado.nextLine();

                Ticket nuevo = new Ticket(desc, nombre, prio);
                colaPendientes.ingresar(nuevo); // Sincronizado con ingresar()
                System.out.println("Ticket creado. Guarde su ID: " + nuevo.getId() + "\n");

            } else if (opcion == 2) {
                System.out.print("Ingrese el ID a buscar: ");
                int idBuscar = teclado.nextInt();
                teclado.nextLine();

                Ticket buscado = listaResueltos.buscar(idBuscar);
                if (buscado != null) {
                    System.out.println("\nTicket Encontrado");
                    System.out.println(buscado);
                }
            }
        }
    }

    private static void menuAdministrador() {
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("\nMenú de administrador");
            System.out.println("1. Ver próximo ticket");
            System.out.println("2. Resolver próximo ticket");
            System.out.println("3. Mostrar todos los resueltos");
            System.out.println("4. Volver");
            System.out.print("Opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            if (opcion == 1) {
                Ticket alFrente = colaPendientes.verFrente();
                if (alFrente != null) {
                    System.out.println("\nPróximo Ticket por atender");
                    System.out.println(alFrente);
                }
            } else if (opcion == 2) {
                Ticket aResolver = colaPendientes.eliminar();
                if (aResolver != null) {
                    aResolver.setFechaResolucion(LocalDateTime.now());
                    listaResueltos.insertarFinal(aResolver);
                    System.out.println("Ticket resuelto con éxito y movido al historial.\n");
                }
            } else if (opcion == 3) {
                System.out.println("\nHistorial de Tickets Resueltos");
                listaResueltos.mostrar();
            }
        }
    }
}
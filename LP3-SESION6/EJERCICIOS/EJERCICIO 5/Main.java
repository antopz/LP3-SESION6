package EJERCICIO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibroVista vista = new LibroVista();
        Biblioteca biblioteca = new Biblioteca();
        Controlador controlador = new Controlador(vista, biblioteca);

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n===== MENÚ BIBLIOTECA =====");
            System.out.println("1. Agregar libro");
            System.out.println("2. Mostrar libros");
            System.out.println("3. Buscar libro");
            System.out.println("4. Prestar libro");
            System.out.println("5. Devolver libro");
            System.out.println("6. Mostrar préstamos");
            System.out.println("7. Agregar persona a lista de espera");
            System.out.println("8. Mostrar lista de espera");
            System.out.println("9. Atender siguiente en espera");
            System.out.println("10. Deshacer último libro agregado");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            while (!sc.hasNextInt()) {
                System.out.print("Ingresa un número válido: ");
                sc.next();
            }
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    controlador.agregarLibro(titulo, autor);
                    break;

                case 2:
                    controlador.mostrarLibros();
                    break;

                case 3:
                    System.out.print("Título a buscar: ");
                    controlador.buscarLibro(sc.nextLine());
                    break;

                case 4:
                    System.out.print("Título del libro: ");
                    String tPrestar = sc.nextLine();
                    System.out.print("Nombre de la persona: ");
                    String nombre = sc.nextLine();
                    System.out.print("Código de la persona: ");
                    String codigo = sc.nextLine();
                    controlador.prestarLibro(tPrestar, nombre, codigo);
                    break;

                case 5:
                    System.out.print("Título del libro a devolver: ");
                    controlador.devolverLibro(sc.nextLine());
                    break;

                case 6:
                    controlador.mostrarPrestamos();
                    break;

                case 7:
                    System.out.print("Nombre: ");
                    String nEspera = sc.nextLine();
                    System.out.print("Código: ");
                    String cEspera = sc.nextLine();
                    controlador.agregarListaEspera(nEspera, cEspera);
                    break;

                case 8:
                    controlador.mostrarListaEspera();
                    break;

                case 9:
                    controlador.atenderSiguiente();
                    break;

                case 10:
                    controlador.eliminarUltimoAgregado();
                    break;

                case 0:
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}
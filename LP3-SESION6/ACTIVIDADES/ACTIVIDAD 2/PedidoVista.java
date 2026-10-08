package actividad1;

import java.util.List;
import java.util.Scanner;

public class PedidoVista {

    private Scanner scanner;

    public PedidoVista() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {

        System.out.println("\n===== GESTIÓN DE PEDIDOS =====");
        System.out.println("1. Agregar pedido");
        System.out.println("2. Mostrar pedidos");
        System.out.println("3. Salir");
    }

    public String solicitarNombrePlato() {

        System.out.print("Introduce el nombre del plato: ");

        return scanner.nextLine();
    }

    public String solicitarOpcion() {

        System.out.print("Selecciona una opción: ");

        return scanner.nextLine();
    }

    public void mostrarPedidos(
            List<PedidoModelo.Pedido> pedidos) {

        if (pedidos.isEmpty()) {

            System.out.println(
                    "No hay pedidos en la lista."
            );

            return;
        }

        System.out.println("\n===== LISTA DE PEDIDOS =====");

        for (int i = 0; i < pedidos.size(); i++) {

            System.out.println(
                    (i + 1)
                            + ". "
                            + pedidos.get(i).getNombrePlato()
            );
        }
    }

    public void mostrarMensaje(String mensaje) {

        System.out.println(mensaje);
    }

    public void cerrarScanner() {

        scanner.close();
    }
}
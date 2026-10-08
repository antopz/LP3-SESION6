package ejercicio1;

import java.util.List;
import java.util.Scanner;

public class CarritoVista {

    private Scanner scanner;

    public CarritoVista() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {

        System.out.println("\n===== CARRITO DE COMPRAS =====");
        System.out.println("1. Agregar producto");
        System.out.println("2. Listar productos");
        System.out.println("3. Agregar producto al carrito");
        System.out.println("4. Ver carrito");
        System.out.println("5. Eliminar producto del carrito");
        System.out.println("6. Aplicar descuento");
        System.out.println("7. Calcular envío");
        System.out.println("8. Ver total");
        System.out.println("9. Realizar compra");
        System.out.println("10. Ver historial");
        System.out.println("0. Salir");
    }

    public int solicitarEntero(String mensaje) {

        while (true) {

            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        }
    }

    public double solicitarDouble(String mensaje) {

        while (true) {

            try {
                System.out.print(mensaje);
                return Double.parseDouble(scanner.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        }
    }

    public String solicitarTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public void mostrarProductos(List<CarritoModelo.Producto> productos) {

        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        System.out.println("\n===== PRODUCTOS =====");

        for (CarritoModelo.Producto producto : productos) {
            System.out.println(producto);
        }
    }

    public void mostrarCarrito(List<CarritoModelo.Producto> carrito) {

        if (carrito.isEmpty()) {
            System.out.println("El carrito está vacío.");
            return;
        }

        System.out.println("\n===== CARRITO =====");

        for (int i = 0; i < carrito.size(); i++) {
            System.out.println((i + 1) + ". " + carrito.get(i));
        }
    }

    public void mostrarHistorial(List<CarritoModelo.Compra> historial) {

        if (historial.isEmpty()) {
            System.out.println("No hay compras realizadas.");
            return;
        }

        System.out.println("\n===== HISTORIAL DE COMPRAS =====");

        for (int i = 0; i < historial.size(); i++) {
            System.out.println((i + 1) + ". " + historial.get(i));
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrar() {
        scanner.close();
    }
}
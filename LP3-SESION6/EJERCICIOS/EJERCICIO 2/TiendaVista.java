package ejercicio2;

import java.util.List;
import java.util.Scanner;

public class TiendaVista {

    private Scanner scanner;

    public TiendaVista() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenuPrincipal() {

        System.out.println("\n===== SISTEMA DE USUARIOS =====");
        System.out.println("1. Registrarse");
        System.out.println("2. Iniciar sesión");
        System.out.println("0. Salir");
    }

    public void mostrarMenuTienda(String usuario) {

        System.out.println("\n===== TIENDA =====");
        System.out.println("Usuario: " + usuario);

        System.out.println("1. Agregar producto");
        System.out.println("2. Listar productos");
        System.out.println("3. Agregar producto al carrito");
        System.out.println("4. Ver carrito");
        System.out.println("5. Eliminar producto del carrito");
        System.out.println("6. Aplicar descuento");
        System.out.println("7. Calcular envío");
        System.out.println("8. Ver total");
        System.out.println("9. Realizar compra");
        System.out.println("10. Ver historial de compras");
        System.out.println("11. Crear reseña y calificación");
        System.out.println("12. Ver reseñas");
        System.out.println("13. Cerrar sesión");
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

    public void mostrarProductos(
            List<TiendaModelo.Producto> productos) {

        if (productos.isEmpty()) {

            System.out.println("No hay productos registrados.");
            return;
        }

        System.out.println("\n===== PRODUCTOS =====");

        for (TiendaModelo.Producto producto : productos) {
            System.out.println(producto);
        }
    }

    public void mostrarCarrito(
            List<TiendaModelo.Producto> carrito) {

        if (carrito.isEmpty()) {

            System.out.println("El carrito está vacío.");
            return;
        }

        System.out.println("\n===== CARRITO =====");

        for (int i = 0; i < carrito.size(); i++) {

            System.out.println(
                    (i + 1) + ". " + carrito.get(i)
            );
        }
    }

    public void mostrarCompras(
            List<TiendaModelo.Compra> compras) {

        if (compras.isEmpty()) {

            System.out.println("No existen compras realizadas.");
            return;
        }

        System.out.println("\n===== HISTORIAL =====");

        for (int i = 0; i < compras.size(); i++) {

            System.out.println(
                    (i + 1) + ". " + compras.get(i)
            );
        }
    }

    public void mostrarResenas(
            List<TiendaModelo.Resena> resenas) {

        if (resenas.isEmpty()) {

            System.out.println("No existen reseñas.");
            return;
        }

        System.out.println("\n===== RESEÑAS =====");

        for (TiendaModelo.Resena resena : resenas) {
            System.out.println(resena);
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrar() {
        scanner.close();
    }
}
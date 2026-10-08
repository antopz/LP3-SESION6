package ejercicio1;

public class CarritoControlador {

    private CarritoModelo modelo;
    private CarritoVista vista;

    public CarritoControlador() {
        modelo = new CarritoModelo();
        vista = new CarritoVista();
    }

    public void iniciar() {

        int opcion;

        do {

            vista.mostrarMenu();
            opcion = vista.solicitarEntero("Seleccione una opción: ");

            switch (opcion) {

                case 1:
                    agregarProducto();
                    break;

                case 2:
                    listarProductos();
                    break;

                case 3:
                    agregarAlCarrito();
                    break;

                case 4:
                    verCarrito();
                    break;

                case 5:
                    eliminarDelCarrito();
                    break;

                case 6:
                    aplicarDescuento();
                    break;

                case 7:
                    calcularEnvio();
                    break;

                case 8:
                    mostrarTotal();
                    break;

                case 9:
                    realizarCompra();
                    break;

                case 10:
                    mostrarHistorial();
                    break;

                case 0:
                    vista.mostrarMensaje("Programa finalizado.");
                    break;

                default:
                    vista.mostrarMensaje("Opción incorrecta.");
            }

        } while (opcion != 0);

        vista.cerrar();
    }

    public void agregarProducto() {

        int id = vista.solicitarEntero("ID: ");
        String nombre = vista.solicitarTexto("Nombre: ");
        double precio = vista.solicitarDouble("Precio: ");

        if (modelo.agregarProducto(id, nombre, precio)) {
            vista.mostrarMensaje("Producto agregado correctamente.");
        } else {
            vista.mostrarMensaje("No se pudo agregar el producto.");
        }
    }

    public void listarProductos() {
        vista.mostrarProductos(modelo.getProductos());
    }

    public void agregarAlCarrito() {

        vista.mostrarProductos(modelo.getProductos());

        int id = vista.solicitarEntero("ID del producto: ");

        if (modelo.agregarAlCarrito(id)) {
            vista.mostrarMensaje("Producto agregado al carrito.");
        } else {
            vista.mostrarMensaje("Producto no encontrado.");
        }
    }

    public void verCarrito() {
        vista.mostrarCarrito(modelo.getCarrito());
    }

    public void eliminarDelCarrito() {

        vista.mostrarCarrito(modelo.getCarrito());

        int posicion = vista.solicitarEntero(
                "Número del producto que desea eliminar: "
        );

        if (modelo.eliminarDelCarrito(posicion - 1)) {
            vista.mostrarMensaje("Producto eliminado.");
        } else {
            vista.mostrarMensaje("Posición incorrecta.");
        }
    }

    public void aplicarDescuento() {

        double descuento = vista.solicitarDouble(
                "Ingrese porcentaje de descuento: "
        );

        if (modelo.aplicarDescuento(descuento)) {
            vista.mostrarMensaje("Descuento aplicado.");
        } else {
            vista.mostrarMensaje("Descuento incorrecto.");
        }
    }

    public void calcularEnvio() {

        vista.mostrarMensaje(
                "Costo de envío: S/ "
                        + String.format("%.2f", modelo.calcularEnvio())
        );
    }

    public void mostrarTotal() {

        vista.mostrarMensaje(
                "Subtotal: S/ "
                        + String.format("%.2f", modelo.calcularSubtotal())
        );

        vista.mostrarMensaje(
                "Descuento: S/ "
                        + String.format("%.2f", modelo.calcularDescuento())
        );

        vista.mostrarMensaje(
                "Envío: S/ "
                        + String.format("%.2f", modelo.calcularEnvio())
        );

        vista.mostrarMensaje(
                "Total: S/ "
                        + String.format("%.2f", modelo.calcularTotal())
        );
    }

    public void realizarCompra() {

        if (modelo.realizarCompra()) {
            vista.mostrarMensaje("Compra realizada correctamente.");
        } else {
            vista.mostrarMensaje("El carrito está vacío.");
        }
    }

    public void mostrarHistorial() {
        vista.mostrarHistorial(modelo.getHistorial());
    }
}
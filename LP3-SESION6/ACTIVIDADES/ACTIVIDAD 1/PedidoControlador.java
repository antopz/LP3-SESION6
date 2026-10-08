package actividad1;

public class PedidoControlador {

    private PedidoModelo modelo;
    private PedidoVista vista;

    public PedidoControlador() {

        modelo = new PedidoModelo();

        vista = new PedidoVista();
    }

    public void iniciar() {

        String opcion;

        do {

            vista.mostrarMenu();

            opcion = vista.solicitarOpcion();

            switch (opcion) {

                case "1":

                    agregarPedido();

                    break;

                case "2":

                    mostrarPedidos();

                    break;

                case "3":

                    vista.mostrarMensaje(
                            "Saliendo del sistema..."
                    );

                    break;

                default:

                    vista.mostrarMensaje(
                            "Opción no válida."
                    );
            }

        } while (!opcion.equals("3"));

        vista.cerrarScanner();
    }

    public void agregarPedido() {

        String nombrePlato =
                vista.solicitarNombrePlato();

        if (modelo.agregarPedido(nombrePlato)) {

            vista.mostrarMensaje(
                    "Pedido agregado: "
                            + nombrePlato
            );

        } else {

            vista.mostrarMensaje(
                    "El nombre del plato no puede estar vacío."
            );
        }
    }

    public void mostrarPedidos() {

        vista.mostrarPedidos(
                modelo.getPedidos()
        );
    }
}
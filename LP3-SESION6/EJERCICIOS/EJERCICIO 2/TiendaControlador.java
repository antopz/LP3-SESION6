package ejercicio2;

public class TiendaControlador {

    private TiendaModelo modelo;
    private TiendaVista vista;

    public TiendaControlador() {
        modelo = new TiendaModelo();
        vista = new TiendaVista();
    }

    public void iniciar() {

        int opcion;

        do {

            vista.mostrarMenuPrincipal();

            opcion = vista.solicitarEntero(
                    "Seleccione una opción: "
            );

            switch (opcion) {

                case 1:
                    registrarUsuario();
                    break;

                case 2:
                    iniciarSesion();
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

    public void registrarUsuario() {

        String nombre = vista.solicitarTexto(
                "Nombre: "
        );

        String correo = vista.solicitarTexto(
                "Correo: "
        );

        String contrasena = vista.solicitarTexto(
                "Contraseña: "
        );

        if (modelo.registrarUsuario(
                nombre,
                correo,
                contrasena)) {

            vista.mostrarMensaje(
                    "Usuario registrado correctamente."
            );

        } else {

            vista.mostrarMensaje(
                    "No se pudo registrar el usuario."
            );
        }
    }

    public void iniciarSesion() {

        String correo = vista.solicitarTexto(
                "Correo: "
        );

        String contrasena = vista.solicitarTexto(
                "Contraseña: "
        );

        if (modelo.iniciarSesion(
                correo,
                contrasena)) {

            vista.mostrarMensaje(
                    "Inicio de sesión correcto."
            );

            menuTienda();

        } else {

            vista.mostrarMensaje(
                    "Correo o contraseña incorrectos."
            );
        }
    }

    public void menuTienda() {

        int opcion;

        do {

            vista.mostrarMenuTienda(
                    modelo.getUsuarioActual().getNombre()
            );

            opcion = vista.solicitarEntero(
                    "Seleccione una opción: "
            );

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

                case 11:
                    crearResena();
                    break;

                case 12:
                    mostrarResenas();
                    break;

                case 13:
                    cerrarSesion();
                    break;

                default:
                    vista.mostrarMensaje(
                            "Opción incorrecta."
                    );
            }

        } while (opcion != 13);
    }

    public void agregarProducto() {

        int id = vista.solicitarEntero("ID: ");

        String nombre = vista.solicitarTexto(
                "Nombre: "
        );

        double precio = vista.solicitarDouble(
                "Precio: "
        );

        if (modelo.agregarProducto(
                id,
                nombre,
                precio)) {

            vista.mostrarMensaje(
                    "Producto agregado correctamente."
            );

        } else {

            vista.mostrarMensaje(
                    "No se pudo agregar el producto."
            );
        }
    }

    public void listarProductos() {
        vista.mostrarProductos(
                modelo.getProductos()
        );
    }

    public void agregarAlCarrito() {

        vista.mostrarProductos(
                modelo.getProductos()
        );

        int id = vista.solicitarEntero(
                "ID del producto: "
        );

        if (modelo.agregarAlCarrito(id)) {

            vista.mostrarMensaje(
                    "Producto agregado al carrito."
            );

        } else {

            vista.mostrarMensaje(
                    "Producto no encontrado."
            );
        }
    }

    public void verCarrito() {

        vista.mostrarCarrito(
                modelo.getCarrito()
        );
    }

    public void eliminarDelCarrito() {

        vista.mostrarCarrito(
                modelo.getCarrito()
        );

        int posicion = vista.solicitarEntero(
                "Número del producto que desea eliminar: "
        );

        if (modelo.eliminarDelCarrito(
                posicion - 1)) {

            vista.mostrarMensaje(
                    "Producto eliminado."
            );

        } else {

            vista.mostrarMensaje(
                    "Posición incorrecta."
            );
        }
    }

    public void aplicarDescuento() {

        double descuento = vista.solicitarDouble(
                "Porcentaje de descuento: "
        );

        if (modelo.aplicarDescuento(descuento)) {

            vista.mostrarMensaje(
                    "Descuento aplicado."
            );

        } else {

            vista.mostrarMensaje(
                    "Descuento incorrecto."
            );
        }
    }

    public void calcularEnvio() {

        vista.mostrarMensaje(
                "Costo de envío: S/ "
                        + String.format(
                                "%.2f",
                                modelo.calcularEnvio()
                        )
        );
    }

    public void mostrarTotal() {

        vista.mostrarMensaje(
                "Subtotal: S/ "
                        + String.format(
                                "%.2f",
                                modelo.calcularSubtotal()
                        )
        );

        vista.mostrarMensaje(
                "Descuento: S/ "
                        + String.format(
                                "%.2f",
                                modelo.calcularDescuento()
                        )
        );

        vista.mostrarMensaje(
                "Envío: S/ "
                        + String.format(
                                "%.2f",
                                modelo.calcularEnvio()
                        )
        );

        vista.mostrarMensaje(
                "TOTAL: S/ "
                        + String.format(
                                "%.2f",
                                modelo.calcularTotal()
                        )
        );
    }

    public void realizarCompra() {

        if (modelo.realizarCompra()) {

            vista.mostrarMensaje(
                    "Compra realizada correctamente."
            );

        } else {

            vista.mostrarMensaje(
                    "No se pudo realizar la compra."
            );
        }
    }

    public void mostrarHistorial() {

        vista.mostrarCompras(
                modelo.getComprasUsuario()
        );
    }

    public void crearResena() {

        vista.mostrarProductos(
                modelo.getProductos()
        );

        int id = vista.solicitarEntero(
                "ID del producto comprado: "
        );

        if (!modelo.usuarioComproProducto(id)) {

            vista.mostrarMensaje(
                    "Solo puede reseñar productos que haya comprado."
            );

            return;
        }

        int calificacion = vista.solicitarEntero(
                "Calificación del 1 al 5: "
        );

        String comentario = vista.solicitarTexto(
                "Comentario: "
        );

        if (modelo.agregarResena(
                id,
                calificacion,
                comentario)) {

            vista.mostrarMensaje(
                    "Reseña registrada correctamente."
            );

        } else {

            vista.mostrarMensaje(
                    "No se pudo registrar la reseña."
            );
        }
    }

    public void mostrarResenas() {

        vista.mostrarResenas(
                modelo.getResenas()
        );
    }

    public void cerrarSesion() {

        modelo.cerrarSesion();

        vista.mostrarMensaje(
                "Sesión cerrada correctamente."
        );
    }
}
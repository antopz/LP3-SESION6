package ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class TiendaModelo {

    public static class Producto {

        private int id;
        private String nombre;
        private double precio;

        public Producto(int id, String nombre, double precio) {
            this.id = id;
            this.nombre = nombre;
            this.precio = precio;
        }

        public int getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public double getPrecio() {
            return precio;
        }

        @Override
        public String toString() {
            return id + " - " + nombre
                    + " - S/ "
                    + String.format("%.2f", precio);
        }
    }

    public static class Usuario {

        private String nombre;
        private String correo;
        private String contrasena;

        public Usuario(String nombre, String correo, String contrasena) {
            this.nombre = nombre;
            this.correo = correo;
            this.contrasena = contrasena;
        }

        public String getNombre() {
            return nombre;
        }

        public String getCorreo() {
            return correo;
        }

        public String getContrasena() {
            return contrasena;
        }
    }

    public static class Compra {

        private Usuario usuario;
        private List<Producto> productos;
        private double total;

        public Compra(
                Usuario usuario,
                List<Producto> productos,
                double total) {

            this.usuario = usuario;
            this.productos = productos;
            this.total = total;
        }

        public Usuario getUsuario() {
            return usuario;
        }

        public List<Producto> getProductos() {
            return productos;
        }

        public double getTotal() {
            return total;
        }

        public boolean contieneProducto(int id) {

            for (Producto producto : productos) {

                if (producto.getId() == id) {
                    return true;
                }
            }

            return false;
        }

        @Override
        public String toString() {
            return "Productos: "
                    + productos.size()
                    + " | Total: S/ "
                    + String.format("%.2f", total);
        }
    }

    public static class Resena {

        private Usuario usuario;
        private Producto producto;
        private int calificacion;
        private String comentario;

        public Resena(
                Usuario usuario,
                Producto producto,
                int calificacion,
                String comentario) {

            this.usuario = usuario;
            this.producto = producto;
            this.calificacion = calificacion;
            this.comentario = comentario;
        }

        @Override
        public String toString() {

            return producto.getNombre()
                    + " | Usuario: "
                    + usuario.getNombre()
                    + " | Calificación: "
                    + calificacion
                    + "/5 | "
                    + comentario;
        }
    }

    private List<Usuario> usuarios;
    private List<Producto> productos;
    private List<Producto> carrito;
    private List<Compra> compras;
    private List<Resena> resenas;

    private Usuario usuarioActual;
    private double porcentajeDescuento;

    public TiendaModelo() {

        usuarios = new ArrayList<>();
        productos = new ArrayList<>();
        carrito = new ArrayList<>();
        compras = new ArrayList<>();
        resenas = new ArrayList<>();

        usuarioActual = null;
        porcentajeDescuento = 0;
    }

    public boolean registrarUsuario(
            String nombre,
            String correo,
            String contrasena) {

        if (nombre.isEmpty()
                || correo.isEmpty()
                || contrasena.isEmpty()) {

            return false;
        }

        if (buscarUsuario(correo) != null) {
            return false;
        }

        usuarios.add(
                new Usuario(
                        nombre,
                        correo,
                        contrasena
                )
        );

        return true;
    }

    public Usuario buscarUsuario(String correo) {

        for (Usuario usuario : usuarios) {

            if (usuario.getCorreo().equalsIgnoreCase(correo)) {
                return usuario;
            }
        }

        return null;
    }

    public boolean iniciarSesion(
            String correo,
            String contrasena) {

        Usuario usuario = buscarUsuario(correo);

        if (usuario != null
                && usuario.getContrasena().equals(contrasena)) {

            usuarioActual = usuario;
            return true;
        }

        return false;
    }

    public void cerrarSesion() {
        usuarioActual = null;
        carrito.clear();
        porcentajeDescuento = 0;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public boolean haySesion() {
        return usuarioActual != null;
    }

    public boolean agregarProducto(
            int id,
            String nombre,
            double precio) {

        if (buscarProducto(id) != null
                || nombre.isEmpty()
                || precio <= 0) {

            return false;
        }

        productos.add(
                new Producto(
                        id,
                        nombre,
                        precio
                )
        );

        return true;
    }

    public Producto buscarProducto(int id) {

        for (Producto producto : productos) {

            if (producto.getId() == id) {
                return producto;
            }
        }

        return null;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public boolean agregarAlCarrito(int id) {

        Producto producto = buscarProducto(id);

        if (producto == null) {
            return false;
        }

        carrito.add(producto);
        return true;
    }

    public List<Producto> getCarrito() {
        return carrito;
    }

    public boolean eliminarDelCarrito(int posicion) {

        if (posicion < 0 || posicion >= carrito.size()) {
            return false;
        }

        carrito.remove(posicion);
        return true;
    }

    public double calcularSubtotal() {

        double subtotal = 0;

        for (Producto producto : carrito) {
            subtotal += producto.getPrecio();
        }

        return subtotal;
    }

    public boolean aplicarDescuento(double porcentaje) {

        if (porcentaje < 0 || porcentaje > 100) {
            return false;
        }

        porcentajeDescuento = porcentaje;
        return true;
    }

    public double calcularDescuento() {
        return calcularSubtotal() * porcentajeDescuento / 100;
    }

    public double calcularEnvio() {

        if (carrito.isEmpty()) {
            return 0;
        }

        return 10.00;
    }

    public double calcularTotal() {
        return calcularSubtotal() - calcularDescuento() + calcularEnvio();
    }

    public boolean realizarCompra() {

        if (usuarioActual == null || carrito.isEmpty()) {
            return false;
        }

        Compra compra = new Compra(
                usuarioActual,
                new ArrayList<>(carrito),
                calcularTotal()
        );

        compras.add(compra);

        carrito.clear();
        porcentajeDescuento = 0;

        return true;
    }

    public List<Compra> getComprasUsuario() {

        List<Compra> resultado = new ArrayList<>();

        if (usuarioActual == null) {
            return resultado;
        }

        for (Compra compra : compras) {

            if (compra.getUsuario()
                    .getCorreo()
                    .equalsIgnoreCase(
                            usuarioActual.getCorreo()
                    )) {

                resultado.add(compra);
            }
        }

        return resultado;
    }

    public boolean usuarioComproProducto(int idProducto) {

        if (usuarioActual == null) {
            return false;
        }

        for (Compra compra : compras) {

            if (compra.getUsuario()
                    .getCorreo()
                    .equalsIgnoreCase(
                            usuarioActual.getCorreo()
                    )
                    && compra.contieneProducto(idProducto)) {

                return true;
            }
        }

        return false;
    }

    public boolean agregarResena(
            int idProducto,
            int calificacion,
            String comentario) {

        if (usuarioActual == null) {
            return false;
        }

        Producto producto = buscarProducto(idProducto);

        if (producto == null) {
            return false;
        }

        if (!usuarioComproProducto(idProducto)) {
            return false;
        }

        if (calificacion < 1 || calificacion > 5) {
            return false;
        }

        if (comentario.isEmpty()) {
            return false;
        }

        Resena resena = new Resena(
                usuarioActual,
                producto,
                calificacion,
                comentario
        );

        resenas.add(resena);

        return true;
    }

    public List<Resena> getResenas() {
        return resenas;
    }
}
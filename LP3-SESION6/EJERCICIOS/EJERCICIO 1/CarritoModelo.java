package ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class CarritoModelo {

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
            return id + " - " + nombre + " - S/ " + String.format("%.2f", precio);
        }
    }

    public static class Compra {
        private List<Producto> productos;
        private double total;

        public Compra(List<Producto> productos, double total) {
            this.productos = productos;
            this.total = total;
        }

        public List<Producto> getProductos() {
            return productos;
        }

        public double getTotal() {
            return total;
        }

        @Override
        public String toString() {
            return "Productos: " + productos.size()
                    + " | Total: S/ "
                    + String.format("%.2f", total);
        }
    }

    private List<Producto> productos;
    private List<Producto> carrito;
    private List<Compra> historial;
    private double porcentajeDescuento;

    public CarritoModelo() {
        productos = new ArrayList<>();
        carrito = new ArrayList<>();
        historial = new ArrayList<>();
        porcentajeDescuento = 0;
    }

    public boolean agregarProducto(int id, String nombre, double precio) {

        if (buscarProducto(id) != null || nombre.isEmpty() || precio <= 0) {
            return false;
        }

        productos.add(new Producto(id, nombre, precio));
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

        if (carrito.isEmpty()) {
            return false;
        }

        Compra compra = new Compra(
                new ArrayList<>(carrito),
                calcularTotal()
        );

        historial.add(compra);

        carrito.clear();
        porcentajeDescuento = 0;

        return true;
    }

    public List<Compra> getHistorial() {
        return historial;
    }
}
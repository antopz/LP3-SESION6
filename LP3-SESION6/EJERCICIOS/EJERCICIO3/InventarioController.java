package inventario;

public class InventarioController {
    private InventarioModel modelo;
    private InventarioView vista;

    public InventarioController(InventarioModel modelo,InventarioView vista) {
        this.modelo=modelo;
        this.vista=vista;
    }

    public void agregarItem() {
        try {
            String nombre=vista.pedirNombre();
            int cantidad=vista.pedirCantidad();
            String tipo=vista.pedirTipo();
            String descripcion=vista.pedirDescripcion();

            if(nombre.isEmpty() || tipo.isEmpty() || descripcion.isEmpty()) {
                vista.mostrarMensaje("Los datos no pueden estar vacios.");
                return;
            }

            if(cantidad<0) {
                vista.mostrarMensaje("La cantidad no puede ser negativa.");
                return;
            }

            if(!tipo.equalsIgnoreCase("Arma") && !tipo.equalsIgnoreCase("Pocion")) {
                vista.mostrarMensaje("El tipo debe ser Arma o Pocion.");
                return;
            }

            modelo.agregarItem(nombre,cantidad,tipo,descripcion);
            vista.mostrarMensaje("Item agregado correctamente.");

        } catch(NumberFormatException e) {
            vista.mostrarMensaje("La cantidad debe ser un numero entero.");
        }
    }

    public void eliminarItem() {
        String nombre=vista.pedirNombreEliminar();
        InventarioModel.Item item=modelo.buscarItem(nombre);

        if(item==null) {
            vista.mostrarMensaje("No se encontro el item.");
            return;
        }

        modelo.eliminarItem(item);
        vista.mostrarMensaje("Item eliminado correctamente.");
    }

    public void verInventario() {
        vista.mostrarInventario(modelo.obtenerItems());
    }

    public void mostrarDetalles() {
        String nombre=vista.pedirNombreBuscar();
        InventarioModel.Item item=modelo.buscarItem(nombre);

        if(item==null) {
            vista.mostrarMensaje("No se encontro el item.");
            return;
        }

        vista.mostrarDetallesItem(item);
    }

    public void buscarItem() {
        String nombre=vista.pedirNombreBuscar();
        InventarioModel.Item item=modelo.buscarItem(nombre);

        if(item==null) {
            vista.mostrarMensaje("No se encontro el item.");
        } else {
            vista.mostrarMensaje("Item encontrado: "+item.getNombre());
        }
    }

    public void iniciar() {
        String opcion="";

        while(!opcion.equals("6")) {
            vista.mostrarMenu();
            opcion=vista.pedirOpcion();

            switch(opcion) {
                case "1":
                    agregarItem();
                    break;
                case "2":
                    eliminarItem();
                    break;
                case "3":
                    verInventario();
                    break;
                case "4":
                    mostrarDetalles();
                    break;
                case "5":
                    buscarItem();
                    break;
                case "6":
                    vista.mostrarMensaje("Programa finalizado.");
                    break;
                default:
                    vista.mostrarMensaje("Opcion incorrecta.");
            }
        }

        vista.cerrar();
    }
}

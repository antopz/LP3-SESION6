package inventario;

import java.util.List;
import java.util.Scanner;

public class InventarioView {
    private Scanner sc;

    public InventarioView() {
        sc=new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n--- SISTEMA DE INVENTARIO ---");
        System.out.println("1. Agregar item");
        System.out.println("2. Eliminar item");
        System.out.println("3. Ver inventario");
        System.out.println("4. Mostrar detalles de un item");
        System.out.println("5. Buscar item");
        System.out.println("6. Salir");
    }

    public String pedirOpcion() {
        System.out.print("Opcion: ");
        return sc.nextLine();
    }

    public String pedirNombre() {
        System.out.print("Nombre: ");
        return sc.nextLine();
    }

    public int pedirCantidad() {
        System.out.print("Cantidad: ");
        return Integer.parseInt(sc.nextLine());
    }

    public String pedirTipo() {
        System.out.print("Tipo (Arma o Pocion): ");
        return sc.nextLine();
    }

    public String pedirDescripcion() {
        System.out.print("Descripcion: ");
        return sc.nextLine();
    }

    public String pedirNombreEliminar() {
        System.out.print("Nombre del item a eliminar: ");
        return sc.nextLine();
    }

    public String pedirNombreBuscar() {
        System.out.print("Nombre del item a buscar: ");
        return sc.nextLine();
    }

    public void mostrarInventario(List<InventarioModel.Item> items) {
        if(items.size()==0) {
            System.out.println("El inventario esta vacio.");
            return;
        }

        System.out.println("\n--- INVENTARIO ---");

        for(int i=0;i<items.size();i++) {
            InventarioModel.Item item=items.get(i);
            System.out.println((i+1)+". "+item.getNombre()+" - "+item.getTipo()+" - Cantidad: "+item.getCantidad());
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarDetallesItem(InventarioModel.Item item) {
        System.out.println("\n--- DETALLES DEL ITEM ---");
        System.out.println("Nombre: "+item.getNombre());
        System.out.println("Cantidad: "+item.getCantidad());
        System.out.println("Tipo: "+item.getTipo());
        System.out.println("Descripcion: "+item.getDescripcion());
    }

    public void cerrar() {
        sc.close();
    }
}

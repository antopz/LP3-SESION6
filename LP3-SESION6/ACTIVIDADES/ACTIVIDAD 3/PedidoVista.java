package ACTIVIDAD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PedidoVista {
    private Scanner sc;

    public PedidoVista() {
        sc=new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n--- MENU DE PEDIDOS ---");
        System.out.println("1. Agregar pedido");
        System.out.println("2. Mostrar pedidos");
        System.out.println("3. Eliminar pedido");
        System.out.println("4. Actualizar pedido");
        System.out.println("5. Buscar pedido");
        System.out.println("6. Contar pedidos");
        System.out.println("7. Historial de pedidos");
        System.out.println("8. Salir");
    }

    public String pedirOpcion() {
        System.out.print("Opcion: ");
        return sc.nextLine();
    }

    public String pedirNombre() {
        System.out.print("Nombre del plato: ");
        return sc.nextLine();
    }

    public String pedirTipo() {
        System.out.print("Tipo del plato: ");
        return sc.nextLine();
    }

    public String pedirNombreEliminar() {
        System.out.print("Nombre del pedido a eliminar: ");
        return sc.nextLine();
    }

    public String pedirNombreActualizar() {
        System.out.print("Nombre del pedido a actualizar: ");
        return sc.nextLine();
    }

    public String pedirNuevoNombre() {
        System.out.print("Nuevo nombre: ");
        return sc.nextLine();
    }
    
    public String pedirNuevoTipo() {
    	System.out.println("Nuevo tipo: ");
    	return sc.nextLine();
    }

    public String pedirBusqueda() {
        System.out.print("Nombre o tipo a buscar: ");
        return sc.nextLine();
    }

    public String pedirEstado() {
    	System.out.println("Mostrar:");
    	System.out.println("1. Todos");
    	System.out.println("2. Pendientes");
    	System.out.println("3. Completados");
    	System.out.println("4. Solo eliminados");
    	System.out.println("Opcion: ");
    	
    	String op=sc.nextLine();
    	if(op.equals("1")) {
    		return "Todos";
    	}
    	if(op.equals("2")) {
    		return "Pendiente";
    	}
    	if(op.equals("3")) {
    		return "Completado";
    	}
    	if(op.equals("4")) {
    		return "Eliminado";
    	}
    	return null;
    }
    
    public boolean pedirMarcarComoCompletado() {
    	System.out.println("Marcar como Completado (s/n): ");
    	return sc.nextLine().equalsIgnoreCase("s");
    }
    
    public void mostrarPedidos(ArrayList<PedidoModelo.Pedido> pedidos, String titulo) {
    	if (pedidos.size()==0) {
    		System.out.println("No hay pedidos");
    		return;
    	}
    	
    	System.out.println("\n"+titulo);
    	for (int i=0; i<pedidos.size();i++) {
    		System.out.println("\n"+(i+1)+pedidos.get(i).getNombre()+
    				"\n"+pedidos.get(i).getTipo()+
    				"\n"+pedidos.get(i).getEstado());
    	}	
    }

    
    public void mostrarPedidos(ArrayList<PedidoModelo.Pedido> pedidos) {
        if(pedidos.size()==0) {
            System.out.println("No hay pedidos.");
            return;
        }

        System.out.println("\nPEDIDOS:");
        for(int i=0;i<pedidos.size();i++) {
            System.out.println((i+1)+". "+pedidos.get(i).getNombre()+
            		" - "+pedidos.get(i).getTipo()+
            		" ["+pedidos.get(i).getEstado()+"]");
        }
    }

    public void mostrarBusqueda(ArrayList<PedidoModelo.Pedido> pedidos) {
        if(pedidos.size()==0) {
            System.out.println("No se encontro ningun pedido.");
            return;
        }

        System.out.println("\nRESULTADOS:");
        for(int i=0;i<pedidos.size();i++) {
            System.out.println(pedidos.get(i).getNombre()+" - "+pedidos.get(i).getTipo());
        }
    }

    public void mostrarConteo(int total,HashMap<String,Integer> cantidades) {
        System.out.println("\nTotal de pedidos: "+total);
        System.out.println("Pedidos por tipo:");

        for(String tipo:cantidades.keySet()) {
            System.out.println(tipo+": "+cantidades.get(tipo));
        }
    }
    
    public void mostrarContadorPendientes(int pendientes) {
    	System.out.println("\n Pedidos pendientes:"+pendientes);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrar() {
        sc.close();
    }
}

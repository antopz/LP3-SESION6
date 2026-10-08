package ACTIVIDAD;

import java.util.ArrayList;
import java.util.HashMap;

public class PedidoControlador {
    private PedidoModelo modelo;
    private PedidoVista vista;

    public PedidoControlador(PedidoModelo modelo,PedidoVista vista) {
        this.modelo=modelo;
        this.vista=vista;
    }

    public void agregarPedido() {
        String nombre=vista.pedirNombre();
        String tipo=vista.pedirTipo();

        if(nombre.isEmpty() || tipo.isEmpty()) {
            vista.mostrarMensaje("El nombre y el tipo son obligatorios.");
            return;
        }

        modelo.agregarPedido(nombre,tipo);
        vista.mostrarMensaje("Pedido agregado.");
    }

    public void mostrarPedidos() {
        String estado=vista.pedirEstado();
        
        if (estado==null) {
        	vista.mostrarMensaje("Opcion no valida");
        	return;
        }
        
        ArrayList<PedidoModelo.Pedido> lista;
        if (estado.equals("Todos")) {
        	lista=modelo.getPedidos();
        	vista.mostrarPedidos(lista, "TODOS LOS PEDIDOS");
        	
        } else {
        	lista=modelo.getPedidosPorEstado(estado);
        	vista.mostrarPedidos(lista, "PEDIDOS EN ESTADO"+estado.toUpperCase());
        }
    	vista.mostrarContadorPendientes(modelo.contarPendientes());;
    }

    public void eliminarPedido() {
        String nombre=vista.pedirNombreEliminar();
        boolean eliminado=modelo.eliminarPedido(nombre);

        if(eliminado) {
            vista.mostrarMensaje("Pedido eliminado.");
        } else {
            vista.mostrarMensaje("No se encontro el pedido.");
        }
    }

    public void actualizarPedido() {
        String nombre=vista.pedirNombreActualizar();
        
        if (vista.pedirMarcarComoCompletado()) {
        	if (modelo.marcarComoCompletado(nombre)) {
        		vista.mostrarMensaje("Pedido marcado como COMPLETADO");
        		
        	} else {
        		vista.mostrarMensaje("No se puedo completar");
        	}
        	return;
        }
  
        
        String nuevoNombre=vista.pedirNuevoNombre();
        String nuevoTipo=vista.pedirNuevoTipo();
        boolean actualizado=modelo.actualizarPedido(nombre,nuevoNombre, nuevoTipo);

        if(actualizado) {
            vista.mostrarMensaje("Pedido actualizado.");
        } else {
            vista.mostrarMensaje("No se encontro el pedido.");
        }
        return;
    }
    
    public void mostrarHistorial() {
    	vista.mostrarPedidos(modelo.getHistorial(), "\nHISTORIAL");
    }

    public void buscarPedido() {
        String dato=vista.pedirBusqueda();
        ArrayList<PedidoModelo.Pedido> encontrados=modelo.buscarPedido(dato);
        vista.mostrarBusqueda(encontrados);
    }

    public void contarPedidos() {
        int total=modelo.contarPedidos();
        HashMap<String,Integer> cantidades=modelo.contarPorTipo();
        vista.mostrarConteo(total,cantidades);
    }

    public void iniciar() {
        String opcion="";

        while(!opcion.equals("8")) {
            vista.mostrarMenu();
            opcion=vista.pedirOpcion();

            switch(opcion) {
                case "1":
                    agregarPedido();
                    break;
                case "2":
                    mostrarPedidos();
                    break;
                case "3":
                    eliminarPedido();
                    break;
                case "4":
                    actualizarPedido();
                    break;
                case "5":
                    buscarPedido();
                    break;
                case "6":
                    contarPedidos();
                    break;
                case "7":
                    mostrarHistorial();
                    break;
                case "8":
                	vista.mostrarMensaje("Programa finalizado");
                	break;
                default:
                    vista.mostrarMensaje("Opcion incorrecta.");
            }
        }
        vista.cerrar();
    }
}

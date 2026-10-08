package ACTIVIDAD;

import java.util.ArrayList;
import java.util.HashMap;

public class PedidoModelo {

    public class Pedido {
        private String nombre;
        private String tipo;
        private String estado;

        public Pedido(String nombre,String tipo) {
            this.nombre=nombre;
            this.tipo=tipo;
            this.estado="Pendiente";
         }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre=nombre;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo=tipo;
        }
        
        public String getEstado() {
        	return estado;
        }
        
        public void setEstado(String estado) {
        	this.estado=estado;
        }
        
    }

    private ArrayList<Pedido> pedidos;

    public PedidoModelo() {
        pedidos=new ArrayList<>();
    }

    public void agregarPedido(String nombre,String tipo) {
        Pedido pedido=new Pedido(nombre,tipo);
        pedidos.add(pedido);
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public boolean eliminarPedido(String nombre) {
        for(int i=0;i<pedidos.size();i++) {
            if(pedidos.get(i).getNombre().equalsIgnoreCase(nombre)) {
                pedidos.get(i).setEstado("Eliminado");;
                return true;
            }
        }
        return false;
    }

    public boolean actualizarPedido(String nombre,String nuevoNombre, String nuevoTipo) {
        for(int i=0;i<pedidos.size();i++) {
            if(pedidos.get(i).getNombre().equalsIgnoreCase(nombre)) {
            	if (nuevoNombre!= null && !nuevoNombre.isEmpty()) {
            		pedidos.get(i).setNombre(nuevoNombre);
            	}
	            if (nuevoTipo !=null && !nuevoTipo.isEmpty()) {
	            	pedidos.get(i).setTipo(nuevoTipo);
	            }
	            return true;
            }
        }
        return false;
    }

    public ArrayList<Pedido> buscarPedido(String dato) {
        ArrayList<Pedido> encontrados=new ArrayList<>();

        for(int i=0;i<pedidos.size();i++) {
            Pedido p=pedidos.get(i);

            if(p.getNombre().toLowerCase().contains(dato.toLowerCase()) ||
               p.getTipo().toLowerCase().contains(dato.toLowerCase())) {
                encontrados.add(p);
            }
        }
        return encontrados;
    }

    public int contarPedidos() {
        return pedidos.size();
    }

    public HashMap<String,Integer> contarPorTipo() {
        HashMap<String,Integer> cantidades=new HashMap<>();

        for(int i=0;i<pedidos.size();i++) {
            String tipo=pedidos.get(i).getTipo();

            if(cantidades.containsKey(tipo)) {
                cantidades.put(tipo,cantidades.get(tipo)+1);
            } else {
                cantidades.put(tipo,1);
            }
        }
        return cantidades;
    }
    
    public boolean marcarComoCompletado(String nombre) {
    	for (int i=0;  i<pedidos.size();i++) {
    		Pedido p = pedidos.get(i);
    		if(p.getNombre().equalsIgnoreCase(nombre)) {
    			if(p.getEstado().equalsIgnoreCase("Pendiente")) {
    				p.setEstado("Completado");
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    public ArrayList<Pedido> getPedidosPorEstado(String estado){
    	ArrayList<Pedido> resultado=new ArrayList<>();
    	for (int i=0; i<pedidos.size();i++) {
    		if(pedidos.get(i).getEstado().equalsIgnoreCase(estado)) {
    			resultado.add(pedidos.get(i));
    			
    		}
    	}
    	return resultado;
    }
    
    public int contarPendientes() {
    	int contador=0;
    	for (int i=0; i<pedidos.size(); i++) {
    		if(pedidos.get(i).getEstado().equals("Pendiente")) {
    			contador++;
    		}
    	}
    	return contador;
    }
    
    public ArrayList<Pedido> getHistorial(){
    	ArrayList<Pedido> resultado=new ArrayList<>();
    	for (int i=0; i<pedidos.size(); i++) {
    		String est= pedidos.get(i).getEstado();
    		if(est.equals("Completado") || est.equals("Eliminado")) {
    			resultado.add(pedidos.get(i));
    		}
    	}
    	return resultado;
    }
}

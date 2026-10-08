package inventario;

import java.util.ArrayList;
import java.util.List;

public class InventarioModel {

    public class Item {
        private String nombre;
        private int cantidad;
        private String tipo;
        private String descripcion;

        public Item(String nombre,int cantidad,String tipo,String descripcion) {
            this.nombre=nombre;
            this.cantidad=cantidad;
            this.tipo=tipo;
            this.descripcion=descripcion;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre=nombre;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad=cantidad;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo=tipo;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion=descripcion;
        }

        public boolean usarItem() {
            if(cantidad>0) {
                cantidad--;
                return true;
            }
            return false;
        }
    }

    private List<Item> items;

    public InventarioModel() {
        items=new ArrayList<>();
    }

    public void agregarItem(String nombre,int cantidad,String tipo,String descripcion) {
        Item item=new Item(nombre,cantidad,tipo,descripcion);
        items.add(item);
    }

    public boolean eliminarItem(Item item) {
        return items.remove(item);
    }

    public List<Item> obtenerItems() {
        return new ArrayList<>(items);
    }

    public Item buscarItem(String nombre) {
        for(int i=0;i<items.size();i++) {
            Item item=items.get(i);

            if(item.getNombre().equalsIgnoreCase(nombre)) {
                return item;
            }
        }
        return null;
    }
}

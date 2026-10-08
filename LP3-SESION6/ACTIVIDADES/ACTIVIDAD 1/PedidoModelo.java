package actividad1;

import java.util.ArrayList;
import java.util.List;

public class PedidoModelo {

    public static class Pedido {

        private String nombrePlato;

        public Pedido(String nombrePlato) {
            this.nombrePlato = nombrePlato;
        }

        public String getNombrePlato() {
            return nombrePlato;
        }

        public void setNombrePlato(String nombrePlato) {
            this.nombrePlato = nombrePlato;
        }

        @Override
        public String toString() {
            return nombrePlato;
        }
    }

    private List<Pedido> pedidos;

    public PedidoModelo() {
        pedidos = new ArrayList<>();
    }

    public boolean agregarPedido(String nombrePlato) {

        if (nombrePlato == null || nombrePlato.trim().isEmpty()) {
            return false;
        }

        Pedido pedido = new Pedido(nombrePlato);

        pedidos.add(pedido);

        return true;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}
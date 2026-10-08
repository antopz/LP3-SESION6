package ejercicio4;

import java.util.ArrayList;
import java.util.List;

public class JuegoModelo {

    public static class Objeto {

        private String nombre;
        private String tipo;
        private int valor;

        public Objeto(String nombre, String tipo, int valor) {
            this.nombre = nombre;
            this.tipo = tipo;
            this.valor = valor;
        }

        public String getNombre() {
            return nombre;
        }

        public String getTipo() {
            return tipo;
        }

        public int getValor() {
            return valor;
        }

        @Override
        public String toString() {
            return nombre + " | Tipo: " + tipo + " | Valor: " + valor;
        }
    }

    public static class Jugador {

        private String nombre;
        private int salud;
        private int saludMaxima;
        private int nivel;
        private List<Objeto> inventario;
        private Objeto objetoEquipado;

        public Jugador(String nombre, int salud, int nivel) {
            this.nombre = nombre;
            this.salud = salud;
            this.saludMaxima = salud;
            this.nivel = nivel;
            this.inventario = new ArrayList<>();
            this.objetoEquipado = null;
        }

        public String getNombre() {
            return nombre;
        }

        public int getSalud() {
            return salud;
        }

        public int getNivel() {
            return nivel;
        }

        public List<Objeto> getInventario() {
            return inventario;
        }

        public Objeto getObjetoEquipado() {
            return objetoEquipado;
        }

        public void agregarObjeto(Objeto objeto) {
            inventario.add(objeto);
        }

        public boolean equiparObjeto(int posicion) {

            if (posicion < 0 || posicion >= inventario.size()) {
                return false;
            }

            Objeto objeto = inventario.get(posicion);

            if (!objeto.getTipo().equalsIgnoreCase("ARMA")) {
                return false;
            }

            objetoEquipado = objeto;
            return true;
        }

        public int atacar(Enemigo enemigo) {

            if (objetoEquipado == null) {
                return 0;
            }

            int danio = objetoEquipado.getValor();

            enemigo.recibirDanio(danio);

            return danio;
        }

        public int usarObjeto(int posicion) {

            if (posicion < 0 || posicion >= inventario.size()) {
                return 0;
            }

            Objeto objeto = inventario.get(posicion);

            if (!objeto.getTipo().equalsIgnoreCase("CURACION")) {
                return 0;
            }

            int saludAnterior = salud;

            salud += objeto.getValor();

            if (salud > saludMaxima) {
                salud = saludMaxima;
            }

            inventario.remove(posicion);

            return salud - saludAnterior;
        }

        public void recibirDanio(int danio) {

            salud -= danio;

            if (salud < 0) {
                salud = 0;
            }
        }

        public boolean estaVivo() {
            return salud > 0;
        }
    }

    public static class Enemigo {

        private String nombre;
        private int salud;
        private int nivel;
        private String tipo;

        public Enemigo(
                String nombre,
                int salud,
                int nivel,
                String tipo) {

            this.nombre = nombre;
            this.salud = salud;
            this.nivel = nivel;
            this.tipo = tipo;
        }

        public String getNombre() {
            return nombre;
        }

        public int getSalud() {
            return salud;
        }

        public int getNivel() {
            return nivel;
        }

        public String getTipo() {
            return tipo;
        }

        public int atacar(Jugador jugador) {

            int danio = nivel * 3;

            jugador.recibirDanio(danio);

            return danio;
        }

        public void recibirDanio(int danio) {

            salud -= danio;

            if (salud < 0) {
                salud = 0;
            }
        }

        public boolean estaVivo() {
            return salud > 0;
        }

        @Override
        public String toString() {

            return nombre
                    + " | Salud: " + salud
                    + " | Nivel: " + nivel
                    + " | Tipo: " + tipo;
        }
    }

    private Jugador jugador;
    private List<Enemigo> enemigos;

    public JuegoModelo() {

        jugador = new Jugador(
                "Jugador",
                100,
                1
        );

        enemigos = new ArrayList<>();

        jugador.agregarObjeto(
                new Objeto(
                        "Espada",
                        "ARMA",
                        20
                )
        );

        jugador.agregarObjeto(
                new Objeto(
                        "Hacha",
                        "ARMA",
                        30
                )
        );

        jugador.agregarObjeto(
                new Objeto(
                        "Poción",
                        "CURACION",
                        25
                )
        );

        enemigos.add(
                new Enemigo(
                        "Goblin",
                        50,
                        1,
                        "Bestia"
                )
        );

        enemigos.add(
                new Enemigo(
                        "Orco",
                        80,
                        2,
                        "Guerrero"
                )
        );

        enemigos.add(
                new Enemigo(
                        "Esqueleto",
                        60,
                        2,
                        "No muerto"
                )
        );
    }

    public Jugador getJugador() {
        return jugador;
    }

    public List<Enemigo> getEnemigos() {
        return enemigos;
    }

    public Enemigo obtenerEnemigo(int posicion) {

        if (posicion < 0 || posicion >= enemigos.size()) {
            return null;
        }

        return enemigos.get(posicion);
    }
}
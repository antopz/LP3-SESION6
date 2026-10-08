package ejercicio4;

import java.util.Random;

public class JuegoControlador {

    private JuegoModelo modelo;
    private JuegoVista vista;
    private Random random;

    public JuegoControlador() {

        modelo = new JuegoModelo();

        vista = new JuegoVista();

        random = new Random();
    }

    public void iniciar() {

        int opcion;

        do {

            vista.mostrarMenuPrincipal();

            opcion = vista.solicitarEntero(
                    "Seleccione una opción: "
            );

            switch (opcion) {

                case 1:
                    mostrarInventario();
                    break;

                case 2:
                    equiparObjeto();
                    break;

                case 3:
                    usarObjeto();
                    break;

                case 4:
                    mostrarEnemigos();
                    break;

                case 5:
                    iniciarCombate();
                    break;

                case 0:
                    vista.mostrarMensaje(
                            "Programa finalizado."
                    );
                    break;

                default:
                    vista.mostrarMensaje(
                            "Opción incorrecta."
                    );
            }

        } while (opcion != 0);

        vista.cerrar();
    }

    public void mostrarInventario() {

        vista.mostrarInventario(
                modelo.getJugador().getInventario(),
                modelo.getJugador().getObjetoEquipado()
        );
    }

    public void equiparObjeto() {

        mostrarInventario();

        int posicion = vista.solicitarEntero(
                "Seleccione el objeto a equipar: "
        );

        if (modelo
                .getJugador()
                .equiparObjeto(posicion - 1)) {

            vista.mostrarMensaje(
                    "Arma equipada correctamente."
            );

        } else {

            vista.mostrarMensaje(
                    "No se puede equipar ese objeto."
            );
        }
    }

    public void usarObjeto() {

        mostrarInventario();

        int posicion = vista.solicitarEntero(
                "Seleccione el objeto a utilizar: "
        );

        int recuperado =
                modelo
                        .getJugador()
                        .usarObjeto(posicion - 1);

        if (recuperado > 0) {

            vista.mostrarMensaje(
                    "Se recuperaron "
                            + recuperado
                            + " puntos de salud."
            );

        } else {

            vista.mostrarMensaje(
                    "El objeto no puede utilizarse."
            );
        }
    }

    public void mostrarEnemigos() {

        vista.mostrarEnemigos(
                modelo.getEnemigos()
        );
    }

    public void iniciarCombate() {

        if (!modelo.getJugador().estaVivo()) {

            vista.mostrarMensaje(
                    "El jugador no tiene salud suficiente para combatir."
            );

            return;
        }

        mostrarEnemigos();

        int posicion = vista.solicitarEntero(
                "Seleccione un enemigo: "
        );

        JuegoModelo.Enemigo enemigo =
                modelo.obtenerEnemigo(
                        posicion - 1
                );

        if (enemigo == null) {

            vista.mostrarMensaje(
                    "Enemigo no válido."
            );

            return;
        }

        if (!enemigo.estaVivo()) {

            vista.mostrarMensaje(
                    "El enemigo seleccionado ya fue derrotado."
            );

            return;
        }

        gestionarCombate(enemigo);
    }

    public void gestionarCombate(
            JuegoModelo.Enemigo enemigo) {

        int opcion;

        boolean huir = false;

        vista.mostrarMensaje(
                "\nComienza el combate contra "
                        + enemigo.getNombre()
                        + "."
        );

        while (modelo.getJugador().estaVivo()
                && enemigo.estaVivo()
                && !huir) {

            vista.mostrarEstadoCombate(
                    modelo.getJugador(),
                    enemigo
            );

            vista.mostrarMenuCombate();

            opcion = vista.solicitarEntero(
                    "Seleccione una acción: "
            );

            switch (opcion) {

                case 1:
                    atacarEnemigo(enemigo);
                    break;

                case 2:
                    usarObjeto();
                    break;

                case 3:
                    huir = true;

                    vista.mostrarMensaje(
                            "El jugador huyó del combate."
                    );
                    break;

                default:
                    vista.mostrarMensaje(
                            "Opción incorrecta."
                    );
                    continue;
            }

            if (!huir
                    && enemigo.estaVivo()
                    && modelo.getJugador().estaVivo()) {

                accionEnemigo(enemigo);
            }
        }

        if (!enemigo.estaVivo()) {

            vista.mostrarMensaje(
                    enemigo.getNombre()
                            + " ha sido derrotado."
            );
        }

        if (!modelo.getJugador().estaVivo()) {

            vista.mostrarMensaje(
                    "El jugador ha sido derrotado."
            );
        }
    }

    public void atacarEnemigo(
            JuegoModelo.Enemigo enemigo) {

        int danio =
                modelo
                        .getJugador()
                        .atacar(enemigo);

        if (danio == 0) {

            vista.mostrarMensaje(
                    "No existe un arma equipada."
            );

        } else {

            vista.mostrarMensaje(
                    modelo.getJugador().getNombre()
                            + " atacó a "
                            + enemigo.getNombre()
                            + " causando "
                            + danio
                            + " puntos de daño."
            );
        }
    }

    public void accionEnemigo(
            JuegoModelo.Enemigo enemigo) {

        int accion = random.nextInt(3);

        switch (accion) {

            case 0:

                int danio =
                        enemigo.atacar(
                                modelo.getJugador()
                        );

                vista.mostrarMensaje(
                        enemigo.getNombre()
                                + " atacó y causó "
                                + danio
                                + " puntos de daño."
                );

                break;

            case 1:

                vista.mostrarMensaje(
                        enemigo.getNombre()
                                + " observa al jugador y no ataca."
                );

                break;

            case 2:

                int segundoDanio =
                        enemigo.atacar(
                                modelo.getJugador()
                        );

                vista.mostrarMensaje(
                        enemigo.getNombre()
                                + " realizó un ataque y causó "
                                + segundoDanio
                                + " puntos de daño."
                );

                break;
        }
    }
}
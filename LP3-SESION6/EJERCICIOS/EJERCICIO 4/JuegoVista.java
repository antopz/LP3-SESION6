package ejercicio4;

import java.util.List;
import java.util.Scanner;

public class JuegoVista {

    private Scanner scanner;

    public JuegoVista() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenuPrincipal() {

        System.out.println("\n===== SISTEMA DE JUEGO =====");
        System.out.println("1. Ver inventario");
        System.out.println("2. Equipar objeto");
        System.out.println("3. Usar objeto");
        System.out.println("4. Ver enemigos");
        System.out.println("5. Iniciar combate");
        System.out.println("0. Salir");
    }

    public void mostrarMenuCombate() {

        System.out.println("\n===== COMBATE =====");
        System.out.println("1. Atacar");
        System.out.println("2. Usar objeto");
        System.out.println("3. Huir");
    }

    public int solicitarEntero(String mensaje) {

        while (true) {

            try {

                System.out.print(mensaje);

                return Integer.parseInt(
                        scanner.nextLine()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Ingrese un número válido."
                );
            }
        }
    }

    public void mostrarInventario(
            List<JuegoModelo.Objeto> inventario,
            JuegoModelo.Objeto equipado) {

        if (inventario.isEmpty()) {

            System.out.println(
                    "El inventario está vacío."
            );

            return;
        }

        System.out.println("\n===== INVENTARIO =====");

        for (int i = 0; i < inventario.size(); i++) {

            JuegoModelo.Objeto objeto =
                    inventario.get(i);

            System.out.println(
                    (i + 1)
                            + ". "
                            + objeto
            );
        }

        if (equipado != null) {

            System.out.println(
                    "Objeto equipado: "
                            + equipado.getNombre()
            );

        } else {

            System.out.println(
                    "No existe un arma equipada."
            );
        }
    }

    public void mostrarEnemigos(
            List<JuegoModelo.Enemigo> enemigos) {

        System.out.println("\n===== ENEMIGOS =====");

        for (int i = 0; i < enemigos.size(); i++) {

            System.out.println(
                    (i + 1)
                            + ". "
                            + enemigos.get(i)
            );
        }
    }

    public void mostrarEstadoCombate(
            JuegoModelo.Jugador jugador,
            JuegoModelo.Enemigo enemigo) {

        System.out.println(
                "\n===== ESTADO DEL COMBATE ====="
        );

        System.out.println(
                jugador.getNombre()
                        + " | Salud: "
                        + jugador.getSalud()
                        + " | Nivel: "
                        + jugador.getNivel()
        );

        System.out.println(
                enemigo.getNombre()
                        + " | Salud: "
                        + enemigo.getSalud()
                        + " | Nivel: "
                        + enemigo.getNivel()
                        + " | Tipo: "
                        + enemigo.getTipo()
        );

        if (jugador.getObjetoEquipado() != null) {

            System.out.println(
                    "Arma equipada: "
                            + jugador
                            .getObjetoEquipado()
                            .getNombre()
            );
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrar() {
        scanner.close();
    }
}
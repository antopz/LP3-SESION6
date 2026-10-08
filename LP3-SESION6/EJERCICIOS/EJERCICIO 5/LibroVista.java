package EJERCICIO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LibroVista {

	public void imprimirLibros(List<Libro> libros) {
		if (libros.isEmpty()) {
			System.out.println("No hay libros");
		} else {
			for (int i = 0; i < libros.size(); i++) {
				Libro b = libros.get(i);
				System.out.println((i + 1) + ". Titulo: " + b.getTitulo() + "- Autor: " + b.getAutor());
			}
		}
	}

	public void imprimirPrestamos(Map<Libro, Persona> prestamos) {
		if (prestamos.isEmpty()) {
			System.out.println("No hay prestamos");
			return;
		}

		List<Map.Entry<Libro, Persona>> lista = new ArrayList<>(prestamos.entrySet());

		for (int i = 0; i < lista.size(); i++) {
			Map.Entry<Libro, Persona> entry = lista.get(i);
			Libro l = entry.getKey();
			Persona p = entry.getValue();
			System.out.println("\n" + (i + 1) + ". Titulo:" + l.getTitulo() + "\n Prestado a: " + p.getNombre());
		}
	}

	public void imprimirMensaje(String mensaje) {
		System.out.println("\n" + mensaje);
	}

	public void imprimirListaEspera(Queue<Persona> listaEspera) {
		if (listaEspera.isEmpty()) {
			System.out.println("No hay nadie en la lista de espera");
			return;
		}
		List<Persona> lista = new ArrayList<>(listaEspera);

		for (int i = 0; i < lista.size(); i++) {
			Persona p = lista.get(i);
			System.out.println("\n" + p.getNombre() + " (" + p.getCodigo() + ")");
		}
	}
}

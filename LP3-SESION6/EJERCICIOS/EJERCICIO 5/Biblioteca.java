package EJERCICIO;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

public class Biblioteca {
	private List<Libro> libros;
	private Stack<Libro> historial;
	private Queue<Persona> listaEspera;
	private Map<Libro, Persona> prestamos;
	public Biblioteca() {
		this.libros=new ArrayList<>();
		this.historial=new Stack<>();
		this.listaEspera=new LinkedList<>();
		this.prestamos=new HashMap<>();
	}

	public void agregarLibro(Libro libro) {
		libros.add(libro);
		historial.push(libro);
	}
	
	public Libro buscarTitulo(String titulo) {
		for(int i=0; i<libros.size();i++) {
			if(libros.get(i).getTitulo().equalsIgnoreCase(titulo)) {
				return libros.get(i);
			}
		}
		return null;
	}
	
	public Libro eliminarUltimo() {
		if(!historial.isEmpty()) {
			Libro ultimo=historial.pop();
			libros.remove(ultimo);
			return ultimo;
		}
		return null;
	}
	
	public boolean prestarLibro(Libro libro, Persona persona) {
		if (libro==null || !libro.isDisponible()) {
			return false;
		}
		libro.setDisponible(false);
		prestamos.put(libro, persona);
		return true;
	}
	
	public boolean devolverLibro(Libro libro) {
		if (libro==null || !prestamos.containsKey(libro)) {
			return false;
		}
		prestamos.remove(libro);
		libro.setDisponible(true);
		return true;
		
	}
	
	
	
	
	
	public Map<Libro, Persona> getPrestamos(){
		return new HashMap<>(prestamos);
	}
	
	public void agregarListaEspera(Persona persona) {
		listaEspera.add(persona);
	}
	
	public Persona siguienteEspera() {
		return listaEspera.poll();
	}
	
	public List<Libro> getLibros() {
		return new ArrayList<>(libros);
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
	public Queue<Persona> getListaEspera(){
		return new LinkedList<>(listaEspera);
	}
	
	
}

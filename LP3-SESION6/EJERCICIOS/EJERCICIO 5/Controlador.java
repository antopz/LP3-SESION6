package EJERCICIO;

public class Controlador {
	private LibroVista vista;
	private Biblioteca bibli;
	
	public Controlador(LibroVista vista, Biblioteca bibli) {
		this.vista=vista;
		this.bibli=bibli;
	}
	
	public void agregarLibro(String titulo, String autor) {
		Libro libro=new Libro(titulo, autor);
		bibli.agregarLibro(libro);
	}
	public void mostrarLibros() {
		vista.imprimirLibros(bibli.getLibros());
	}
	
	public void eliminarUltimoAgregado() {
		Libro eliminado=bibli.eliminarUltimo();
		if (eliminado!= null) {
			vista.imprimirMensaje("Se elimino "+eliminado.getTitulo());
		} else {
			vista.imprimirMensaje("No hay nada que deshacer");
		}
	}
	
	public void buscarLibro(String titulo) {
		Libro f=bibli.buscarTitulo(titulo);
		if (f==null) {
			vista.imprimirMensaje("Libro no encontrado");
		} else {
			vista.imprimirMensaje("\nLibro encontrado"+"\n"+f.getTitulo()+"-"+f.getAutor());
		}
	}
	
	
	public void prestarLibro(String titulo, String nombre, String codigo) {
		Libro lib=bibli.buscarTitulo(titulo);
		if (lib==null) {
			vista.imprimirMensaje("Libro no encontrado");
			return;
		}
		
		Persona pers=new Persona(nombre, codigo);
		if(bibli.prestarLibro(lib, pers)) {
			vista.imprimirMensaje("Prestamo exitoso");
		} else {
			vista.imprimirMensaje("Libro no disponible. Agregado a la lista de espera");
			bibli.agregarListaEspera(pers);
		}
	}
	
	public void devolverLibro(String titulo) {
		Libro lib=bibli.buscarTitulo(titulo);
		if (bibli.devolverLibro(lib)) {
			vista.imprimirMensaje("Devolucion exitosa");
		} else {
			vista.imprimirMensaje("Libro no prestado");
		}
	}
	
	public void mostrarPrestamos() {
		vista.imprimirPrestamos(bibli.getPrestamos());
	}
	
	public void agregarListaEspera(String nombre, String codigo) {
		Persona p = new Persona(nombre, codigo);
		bibli.agregarListaEspera(p);
		vista.imprimirMensaje(nombre+" agregado a la lista de espera");
	}
	public void mostrarListaEspera() {
		vista.imprimirListaEspera(bibli.getListaEspera());
	}
	
	public void atenderSiguiente() {
		Persona sig = bibli.siguienteEspera();
		if (sig!=null) {
			vista.imprimirMensaje("Atendiendo: "+sig.getNombre());
		} else {
			vista.imprimirMensaje("Nadie en espera");
		}
	}
	
}

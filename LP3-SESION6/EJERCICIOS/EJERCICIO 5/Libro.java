package EJERCICIO;

public class Libro {
	private String autor;
	private String titulo;
	private boolean disponible;
	
	public Libro(String titulo, String autor) {
		this.autor=autor;
		this.titulo=titulo;
		this.disponible=true;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
}

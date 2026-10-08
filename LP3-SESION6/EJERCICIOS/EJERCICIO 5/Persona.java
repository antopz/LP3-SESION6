package EJERCICIO;

public class Persona {
	private String nombre;
	private String codigo;
	
	public Persona(String nombre, String codigo) {
		this.setNombre(nombre);
		this.setCodigo(codigo);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}

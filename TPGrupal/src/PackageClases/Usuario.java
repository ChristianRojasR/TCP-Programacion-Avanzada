package PackageClases;

public class Usuario implements Comparable<Usuario>{
	private String nombre;
	
	private String tipo;
	
	private int plata;
	
	private double tiempo;

	public Usuario(String nombre, String tipo, int plata, double tiempo) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.plata = plata;
		this.tiempo = tiempo;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", tipo=" + tipo + ", plata=" + plata + ", tiempo=" + tiempo + "]";
	}

	@Override
	public int compareTo(Usuario o) {
		return this.nombre.equals(o.nombre) ? 0 : 1;
	}
	
}

package PackageClases;

public abstract class Producto implements Comparable<Producto>{
	protected String nombre;	
	protected String tipo;
	protected int precio;
	protected double tiempo;
	protected int cupo;
	protected boolean esValido = true;

	public Producto(String nombre, String tipo) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return nombre + "\n" + tipo+ "\n" + precio + " $\n" + tiempo + " hs\n" + cupo + " personas";
	}
	
	@Override
	public int compareTo(Producto o) {
		int resultado;
		if((resultado = this.tipo.compareTo(o.tipo)) == 0) {
			if((resultado = o.precio - this.precio) == 0)
				return (int) (o.tiempo - this.tiempo);
		}
		return resultado;
	}

	public void visit() {
		this.esValido = false;
	}
}

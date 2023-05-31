package PackageClases;

import java.util.Objects;

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
		if((resultado = this.tipo.charAt(0) - o.tipo.charAt(0)) == 0) {
			if((resultado = o.precio - this.precio) == 0)
				return (int) (o.tiempo - this.tiempo);
		}
		return resultado;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cupo, esValido, nombre, precio, tiempo, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return cupo == other.cupo && esValido == other.esValido && Objects.equals(nombre, other.nombre)
				&& precio == other.precio && Double.doubleToLongBits(tiempo) == Double.doubleToLongBits(other.tiempo)
				&& Objects.equals(tipo, other.tipo);
	}

	public void visit() {
		this.esValido = false;
	}
}

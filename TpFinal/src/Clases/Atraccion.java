package Clases;

import java.util.List;

public class Atraccion extends ProductosOfrecidos implements Comparable<Atraccion> {
	protected Integer cupo;

	public Atraccion(String nombre, String tipo, int precioOriginal, Double duracion, Integer cupo) {
		super(nombre, tipo, precioOriginal, duracion);
		this.cupo = cupo;
	}

	/// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

	@Override
	public String toString() {
		return "-Atraccion: \"" + nombre + "\"\n  * Tipo    : " + tipo + "\n  * Precio  : $" + precioOriginal
				+ "\n  * Duracion: " + duracion + " hs" + "\n";
	}

	static public String toStringNombres(List<Atraccion> atracciones) {
		String cad = null;
		boolean flag = true;

		cad = "[";
		for (Atraccion a : atracciones) {

			if (flag) {
				flag = false;
				cad += a.getNombre();
			} else
				cad += ", " + a.getNombre();

		}

		return cad += "]";
	}

	@Override
	public int compareTo(Atraccion other) {
		int res = 0;
		if ((res = other.precioOriginal - this.precioOriginal) == 0)
				res = (int) (other.duracion - this.duracion);

		return res;
	}

	public static void eliminarDuplicadosPorNombre(List<Atraccion> lista) {

		for (int i = 0; i < lista.size() - 1; i++) {
			for (int j = i + 1; j < lista.size(); j++) {
				if (lista.get(i).getNombre().equalsIgnoreCase(lista.get(j).getNombre())) {
					lista.remove(j);
					j--;
				}
			}
		}
	}

	@Override
	public void visit() {
		this.cupo--;
	}

	public Integer getCupo() {
		return cupo;
	}

	public boolean existsAttractionInCarrito(List<Atraccion> attractionsUser) {
		for (Atraccion attractionUser : attractionsUser) {
			if (this.nombre.equalsIgnoreCase(attractionUser.getNombre()))
				return true;
		}
		return false;
	}

}

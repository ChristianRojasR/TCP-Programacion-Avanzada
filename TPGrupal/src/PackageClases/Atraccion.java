package PackageClases;

public class Atraccion extends ProductosOfrecidos{
	private int costo;
	
	private double duracion;

	private int cupo;

	public Atraccion(String nombre, String tipo, int costo, double duracion, int cupo) {
		super(nombre, tipo);
		this.costo = costo;
		this.duracion = duracion;
		this.cupo = cupo;
	}

	@Override
	public String toString() {
		return "Atraccion [" + super.toString() + " costo=" + costo + ", duracion=" + duracion + ", cupo=" + cupo + "]";
	}

	public int getCosto() {
		return costo;
	}

	@Override
	public int compareTo(ProductosOfrecidos o) {
		return this.nombre.equals(o.nombre)?0:1;
	}
}

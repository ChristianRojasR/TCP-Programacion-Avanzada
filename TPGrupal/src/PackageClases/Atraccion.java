package PackageClases;

public class Atraccion extends ProductosOfrecidos{

	public Atraccion(String nombre, String tipo, int precio, double tiempo, int cupo) {
		super(nombre, tipo);
		this.precio = precio;
		this.tiempo = tiempo;
		this.cupo = cupo;
	}

	@Override
	public String toString() {
		return "Atraccion:" + super.toString() + "\n" + precio + " $\n" + tiempo + " hs\n" + cupo + " personas\n==========================";
	}

	public int getCosto() {
		return precio;
	}

	@Override
	public int compareTo(ProductosOfrecidos o) {
		return this.nombre.equals(o.nombre)?0:1;
	}
}

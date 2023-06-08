package PackageClases;

public class Atraccion extends Producto{

	public Atraccion(String nombre, String tipo, int precio, double tiempo, int cupo) {
		super(nombre, tipo);
		this.precio = precio;
		this.tiempo = tiempo;
		this.cupo = cupo;
	}
	
	public Atraccion() {
		super(null,null);
	}

	@Override
	public String toString() {
		return "ATRACCION\n-Nombre: " + nombre + "\n-Precio: " + precio + 
				"$\n-Duracion: " + tiempo + "hs\n";
	}

	public int getCosto() {
		return precio;
	}
}

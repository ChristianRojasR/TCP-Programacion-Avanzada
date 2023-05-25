package PackageClases;

import java.util.Set;

public abstract class Promocion {
	public Promocion() {
		super();
	}

	public int calcularPrecioOriginal(Set<Atraccion> atracciones) {
		int precioPromocion = 0;
		for (Atraccion atraccion : atracciones) {
			precioPromocion += atraccion.getCosto();
		}
		return precioPromocion;
	}
	
	abstract public int calcularPrecioPromocion(Set<Atraccion> atracciones);
}

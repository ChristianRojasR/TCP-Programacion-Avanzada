package PackageClases;

import java.util.Set;

public class Absoluta extends Promocion{
	private int precioFinal;

	public Absoluta(int precioFinal) {
		super();
		this.precioFinal = precioFinal;
	}

	@Override
	public String toString() {
		return "Absoluta ,precioFinal=" + precioFinal;
	}
	
	@Override
	public int calcularPrecioPromocion(Set<Atraccion> atracciones) {
		return precioFinal;
	}
}

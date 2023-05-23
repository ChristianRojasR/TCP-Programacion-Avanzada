package PackageClases;

import java.util.Set;

public class AxB extends Promocion{
	private String gratis;

	public AxB(String gratis) {
		super();
		this.gratis = gratis;
	}

	@Override
	public String toString() {
		return "AxB ,gratis=" + gratis;
	}
	
	@Override
	public int calcularPrecioPromocion(Set<Atraccion> atracciones) {
		int precioTotal = super.calcularPrecioPromocion(atracciones);
		for (Atraccion atraccion : atracciones) {
			if(atraccion.nombre.equals(gratis))
				precioTotal -= atraccion.getCosto();
		}
		return precioTotal;
	}
}

package PackageClases;

import java.util.Set;

public class AxB extends Promocion{
	private Atraccion gratis;

	public AxB(Atraccion atraccion) {
		super();
		this.gratis = atraccion;
	}

	@Override
	public String toString() {
		return "AxB\ngratis: " + gratis.nombre;
	}
	
	@Override
	public int calcularPrecioOriginal(Set<Atraccion> atracciones) {
		atracciones.add(gratis);
		return super.calcularPrecioOriginal(atracciones);
	}
	
	@Override
	public int calcularPrecioPromocion(Set<Atraccion> atracciones) {
		int precioTotal = super.calcularPrecioOriginal(atracciones);
		for (Atraccion atraccion : atracciones) {
			if(atraccion.equals(gratis))
				precioTotal -= atraccion.getCosto();
		}
		return precioTotal;
	}
}

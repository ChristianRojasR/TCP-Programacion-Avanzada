package PackageClases;

import java.util.Set;

public class Porcentual extends Promocion{
	private double porcentaje;

	public Porcentual(double porcentaje) {
		super();
		this.porcentaje = porcentaje;
	}

	@Override
	public String toString() {
		return "Porcentual ,precioFinal=" + porcentaje;
	}
	
	@Override
	public int calcularPrecioPromocion(Set<Atraccion> atracciones) {
		return (int)(super.calcularPrecioPromocion(atracciones) * porcentaje);
	}
	
}

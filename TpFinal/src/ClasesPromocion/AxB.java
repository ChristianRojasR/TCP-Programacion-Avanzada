package ClasesPromocion;

import Clases.*;

public class AxB extends Promocion {
	private Atraccion atraccionGratis;

	public AxB(Atraccion atraccionGratis) {
		this.atraccionGratis = atraccionGratis;
	}

	@Override
	public int calcularPrecioPromocion(int precioOriginal) {
		return precioOriginal - atraccionGratis.getPrecio();
	}

	@Override
	public String toString() {
		return "Atraccion gratis: " + atraccionGratis.getNombre();
	}

}

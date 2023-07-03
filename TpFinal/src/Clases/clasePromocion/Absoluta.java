package Clases.clasePromocion;

public class Absoluta extends Promocion{

	private Integer precioPromocion;
	
	public Absoluta(int precioPromocion) {
		this.precioPromocion = precioPromocion;
	}
	
	@Override
	public int calcularPrecioPromocion(int precioOriginal) {
		return this.precioPromocion;
	}

	@Override
	public String toString() {
		return " * Precio Absoluto     : $" + precioPromocion;
	}

}

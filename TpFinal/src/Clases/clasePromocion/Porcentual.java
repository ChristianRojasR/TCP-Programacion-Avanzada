package Clases.clasePromocion;

public class Porcentual extends Promocion{

	private double descuento;
	
	
	public Porcentual(double descuento) {
		this.descuento = descuento;
	}

	@Override
	public int calcularPrecioPromocion(int precioOriginal) {
		return (int)(precioOriginal * (100 - descuento)/100);
	}

	@Override
	public String toString() {
		return "La promocion es porcentual, tendra un " + descuento + "% de descuento";
	}

}

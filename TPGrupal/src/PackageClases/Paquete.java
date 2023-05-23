package PackageClases;

import java.util.List;
import java.util.Set;
import java.util.LinkedList;

public class Paquete extends ProductosOfrecidos{
	private Set<Atraccion> atracciones;
	
	private Promocion promocion;

	public Paquete(String nombre, String tipo, Set<Atraccion> atracciones, Promocion promocion) {
		super(nombre, tipo);
		this.atracciones = atracciones;
		this.promocion = promocion;
	}

	@Override
	public String toString() {
		return "Paquete [" + super.toString() +" atracciones=" + verAtracciones() + ", promocion=" + promocion + 
				", Precio=" + promocion.calcularPrecioPromocion(atracciones) +"]";
	}
	
	private String verAtracciones() {
		List<String> nombres = new LinkedList<String>();
		for (Atraccion atraccion : atracciones) {
			nombres.add(atraccion.nombre);
		}
		return String.join(" ", nombres);
	}

	@Override
	public int compareTo(ProductosOfrecidos o) {
		return this.nombre.equals(o.nombre)?0:1;
	}
	
}

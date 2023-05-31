package PackageClases;

import java.util.List;
import java.util.Set;
import java.util.LinkedList;

public class Paquete extends Producto{
	private Set<Atraccion> atracciones;	
	private Promocion promocion;

	public Paquete(String nombre, String tipo, Set<Atraccion> set, Promocion promocion) {
		super(nombre, tipo);
		this.atracciones = set;
		this.promocion = promocion;
		this.precio = promocion.calcularPrecioPromocion(set);
		this.tiempo = calcularTiempo(set);
		this.cupo = calcularCupo(set);
	}
	
	private double calcularTiempo(Set<Atraccion> atracciones) {
		double tiempoTotal = 0;
		for (Atraccion atraccion : atracciones) {
			tiempoTotal += atraccion.tiempo;
		}
		return tiempoTotal;
	}
	
	private int calcularCupo(Set<Atraccion> atracciones) {
		boolean flagInicial = true;
		int cupoMin = 0;
		for (Atraccion atraccion : atracciones) {
			if(flagInicial || cupoMin < atraccion.cupo) {				
				cupoMin = atraccion.cupo;
				flagInicial = false;
			}
		}
		return cupoMin;
	}

	@Override
	public String toString() {
		return nombre + "\nAtracciones: " + verAtracciones() + "\nPromo: " + promocion +
				"\nPrecio Original: " + promocion.calcularPrecioOriginal(atracciones) + " $\nAhora: " + precio +" $\n========================";
	}
	
	private String verAtracciones() {
		List<String> nombres = new LinkedList<String>();
		for (Atraccion atraccion : atracciones) {
			nombres.add(atraccion.nombre);
		}
		return String.join(", ", nombres);
	}

	public Set<Atraccion> getAtracciones() {
		return atracciones;
	}

	public void visit(Set<Producto> productos) {
		super.visit();
		for (Producto producto : productos) {
			for (Atraccion atraccion : atracciones) {
				if(producto.equals(atraccion))
					producto.visit();
			}
		}
	}
	
}

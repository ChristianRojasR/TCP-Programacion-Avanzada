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
		this.precio = promocion.calcularPrecioPromocion(atracciones);
		this.tiempo = calcularTiempo(atracciones);
		this.cupo = calcularCupo(atracciones);
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
		return "Paquete [" + super.toString() +" atracciones=" + verAtracciones() + ", promocion=" + promocion + 
				", Precio=" + precio +"]";
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
		int resultado;
		if((resultado = this.tipo.charAt(0) - o.tipo.charAt(0)) == 0) {
			if((resultado = this.precio - o.precio) == 0)
				return (int) (this.tiempo - o.tiempo);
		}
		return resultado;
	}
	
}

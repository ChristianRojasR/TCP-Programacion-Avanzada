package Clases;

import java.util.*;

import ClasesPromocion.Promocion;

public class Paquete extends ProductosOfrecidos implements Comparable<Paquete> {

	protected List<Atraccion> atracciones;
	protected Promocion promocion;
	protected Integer precioFinal;

	public Paquete(String nombre, String tipo, List<Atraccion> atracciones, Promocion promocion) {
		super(nombre, tipo);

		Atraccion.eliminarDuplicadosPorNombre(atracciones);
		this.atracciones = atracciones;
		this.promocion = promocion;

		this.precioOriginal = this.calcularPrecioOriginal();
		this.duracion = this.calcularDuracionTotal();

		this.precioFinal = promocion.calcularPrecioPromocion(precioOriginal);
	}

	// -------------------------------------------------------------------

	public Integer calcularPrecioOriginal() {
		Integer suma = 0;

		for (Atraccion atraccion : atracciones) {
			suma += atraccion.getPrecio();
		}
		return suma;
	}

	public Double calcularDuracionTotal() {
		Double suma = 0.0;

		for (Atraccion atraccion : atracciones) {
			suma += atraccion.getDuracion();
		}

		return suma;
	}

	@Override
	public String toString() {
		return "-Paquete: \"" + nombre + "\"\n * Atracciones         : " + Atraccion.toStringNombres(atracciones)
				+ "\n * Tipo                : " + tipo + "\n * Duracion total      : " + this.duracion + "hs"
				+ "\n * Precio original     : $" + this.precioOriginal + "\n * Precio Final     : $" + this.precioFinal
				+ "\n" + promocion.toString() + "\n\n";
	}

	public String[] nombresAtraccionesIncluidas() {
		String[] res = new String[atracciones.size()];
		int pos = 0;

		for (Atraccion a : atracciones) {
			res[pos] = a.getNombre();
			pos++;
		}
		return res;
	}

	@Override
	public int compareTo(Paquete other) {
		int res;
		
		if ((res = other.precioOriginal - this.precioOriginal) == 0)
			res = (int) (other.duracion - this.duracion);

		return res;
	}

	// -------------------------------------------------------------------

	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

	public Promocion getPromocion() {
		return promocion;
	}

	public Integer getPrecioFinal() {
		return precioFinal;
	}

	// -------------------------------------------------------------------

	@Override
	public void visit() {
		for (Atraccion atraccion : atracciones) {
			atraccion.visit();
		}
	}

	public boolean hayCupo() {
		for (Atraccion atraccion : atracciones) {
			if (atraccion.getCupo() == 0)
				return false;
		}
		return true;
	}
	
	public boolean existsAttractionInPackage(List<Atraccion> attractionsUser) {
        for(Atraccion attractionUser: attractionsUser) {
            for(Atraccion attractionPackage: this.getAtracciones()) {
                if(attractionPackage.getNombre().equals(attractionUser.getNombre())) {
                    return true;
                }
            }
        }
        return false;
    }

	// -------------------------------------------------------------------

}



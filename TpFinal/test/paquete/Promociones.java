package paquete;

import Clases.*;
import Clases.clasePromocion.*;

import java.util.*;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class Promociones {
	private static List<Atraccion> atraccionesList = new ArrayList<Atraccion>();
	private static Integer sumaPreciosIniciales = 0;

	@BeforeClass
	public static void setup() {
		Atraccion mordor = new Atraccion("Mordor", "Aventura", 800, 3.5, 12);
		Atraccion abismo = new Atraccion("Abismo de Helm", "Aventura", 900, 3.5, 10);
		Atraccion moria = new Atraccion("Moria", "Aventura", 700, 3.2, 15);

		atraccionesList.add(mordor);
		atraccionesList.add(abismo);
		atraccionesList.add(moria);

		sumaPreciosIniciales = (mordor.getPrecio() + abismo.getPrecio() + moria.getPrecio());
	}

	@Test
	public void paquetes_promocionAbsoluta() {

		Promocion descuentoAbsoluto = new Absoluta(300);
		Paquete paquete = new Paquete("paquete", "standard", atraccionesList, descuentoAbsoluto);
		Integer precioEsperado = 300;

		assertEquals(precioEsperado, paquete.getPrecioFinal());
	}

	@Test
	public void paquetes_promocionPorcentual() {

		Promocion descuentoPorcentual = new Porcentual(10);
		Paquete paquete = new Paquete("paquete", "standard", atraccionesList, descuentoPorcentual);
		Integer precioEsperado = (int) (sumaPreciosIniciales * 0.9);

		assertEquals(precioEsperado, paquete.getPrecioFinal());
	}

	@Test
	public void paquetes_promocionAxB() {

		Atraccion atraccion = atraccionesList.get(0);
		Promocion atraccionGratis = new AxB(atraccion);
		Paquete paquete = new Paquete("paquete", "standard", atraccionesList, atraccionGratis);
		Integer precioEsperado = sumaPreciosIniciales - atraccion.getPrecio();

		assertEquals(precioEsperado, paquete.getPrecioFinal());
	}

	@Test
	public void creacionSinDuplicados() {

		Atraccion atraccion = atraccionesList.get(0);

		List<Atraccion> listaConDupl = new ArrayList<Atraccion>(atraccionesList);
		listaConDupl.add(atraccion);

		Promocion descuentoNulo = new Porcentual(0);
		Paquete paquete = new Paquete("paquete", "standard", listaConDupl, descuentoNulo);
		
		assertEquals(atraccionesList.size(), paquete.getAtracciones().size());
	}
}



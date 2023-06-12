package Pruebas;

import Clases.*;
import ClasesPromocion.*;
import java.util.*;

import static org.junit.Assert.*;

import org.junit.Test;

@SuppressWarnings("unused")
public class Pruebas_Paquetes {

	@Test
	public void creacionSinDuplicados() {

		Atraccion mordor = new Atraccion("Mordor", "Aventura", 800, 3.5, 12);
		Atraccion abismo = new Atraccion("Abismo de Helm", "Aventura", 900, 3.5, 10);

		// Prueba de que no ingresen duplicados
		Atraccion moria = new Atraccion("Moria", "Aventura", 700, 3.2, 15);
		Atraccion moria2 = new Atraccion("Moria", "Aventura", 800, 4.2, 15);

		List<Atraccion> atraccionesAventura = new ArrayList<Atraccion>();
		atraccionesAventura.add(moria);
		atraccionesAventura.add(moria2);

		atraccionesAventura.add(mordor);
		atraccionesAventura.add(abismo);

		Promocion descuentoNulo = new Porcentual(0);

		Paquete adventure = new Paquete("Adventure", "Aventura", atraccionesAventura, descuentoNulo);
		// Con esto comprobamos que no se ingreso una atraccion duplicada
		assertEquals(3, adventure.getAtracciones().size());

		Integer precioEsperado = (moria.getPrecio() + mordor.getPrecio() + abismo.getPrecio());

		assertEquals(precioEsperado, adventure.getPrecioFinal());

		System.out.println(adventure);
	}

	@Test
	public void paquetesYPromociones() {
		
		Atraccion minas = new Atraccion("Minas Tirith", "Paisaje", 200, 2.5, 25);
		Atraccion comarca = new Atraccion("La Comarca", "Paisaje", 250, 1.5, 24);

		List<Atraccion> atraccionesPaisaje = new ArrayList<Atraccion>();
		atraccionesPaisaje.add(minas);
		atraccionesPaisaje.add(comarca);
		
		Promocion descuentoAbsoluto = new Absoluta(300);
		Paquete vistas = new Paquete("Vistas", "Paisaje", atraccionesPaisaje, descuentoAbsoluto);

		System.out.println(vistas);
		//------------------------------------------------------------------------//
		Atraccion mordor = new Atraccion("Mordor", "Aventura", 800, 3.5, 12);
		Atraccion abismo = new Atraccion("Abismo de Helm", "Aventura", 900, 3.5, 10);
		Atraccion moria = new Atraccion("Moria", "Aventura", 700, 3.2, 15);
		
		List<Atraccion> atraccionesAventura = new ArrayList<Atraccion>();
		atraccionesAventura.add(mordor);
		atraccionesAventura.add(abismo);
		atraccionesAventura.add(moria);
		
		Promocion descuentoPorcentual = new Porcentual(10);
		Paquete adventure = new Paquete("Adventure", "Aventura", atraccionesAventura, descuentoPorcentual);

		System.out.println(adventure);

		
		//------------------------------------------------------------------------//
		Atraccion montaña = new Atraccion("Montaña de la muerte", "Vertigo", 1300, 0.5, 50);
		Atraccion globo = new Atraccion("Globo", "Vertigo", 1000, 0.3, 40);
		
		List<Atraccion> atraccionesVertigo = new ArrayList<Atraccion>();
		atraccionesVertigo.add(montaña);
		atraccionesVertigo.add(globo);
		
		Promocion atraccionGratis = new AxB(globo);
		Paquete vertigo = new Paquete("Alturas", "Vertigo", atraccionesVertigo, atraccionGratis);

		System.out.println(vertigo);
	}

}



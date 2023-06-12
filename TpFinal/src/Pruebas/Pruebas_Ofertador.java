package Pruebas;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Clases.Atraccion;
import Clases.Paquete;
import Clases.Visitante;
import ClasesPromocion.Absoluta;
import ClasesPromocion.Promocion;

public class Pruebas_Ofertador {
	@Test
	public void ofertas() { 
		
		Atraccion minas = new Atraccion("Minas Tirith", "Paisaje", 200, 2.5, 25);
		Atraccion comarca = new Atraccion("La Comarca", "Paisaje", 250, 1.5, 24);
		Atraccion cantina = new Atraccion("La Cantina", "Paisaje", 100, 1.5, 24);
		Atraccion cocina = new Atraccion("La Cocina", "Paisaje", 200, 1.5, 24);

		List<Atraccion> atraccionesPaisaje = new ArrayList<Atraccion>();
		atraccionesPaisaje.add(minas);
		atraccionesPaisaje.add(comarca);
		Promocion descuentoAbsoluto = new Absoluta(300);
		Paquete vistas = new Paquete("Vistas", "Paisaje", atraccionesPaisaje, descuentoAbsoluto);
		Visitante random = new Visitante("Random","Paisaje",500,6.0);
		if(random.puedeLLevarPaquete(vistas)) {
			random.llevarPaquete(vistas);
		}
		assertFalse(random.puedeLLevarAtraccion(minas)); // verificando que no se pueda llevar minas porque esta dentro del paquete vistas
		assertTrue(random.puedeLLevarAtraccion(cantina));// verificando que se puede llevar cantina porque tiene plata
		if(random.puedeLLevarAtraccion(cantina)) {
			random.llevarAtraccion(cantina);
		}
		assertFalse(random.puedeLLevarAtraccion(cocina)); // verificando que no se puede llevar cocina porque no tiene plata suficiente
	
		

		
	}

}

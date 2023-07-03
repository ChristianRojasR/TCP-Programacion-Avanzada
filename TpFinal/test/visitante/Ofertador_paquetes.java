package visitante;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import Clases.*;
import Clases.clasePromocion.*;


public class Ofertador_paquetes {

	private static List<Atraccion> atraccionesList = new ArrayList<Atraccion>();
	
	@BeforeClass
	public static void setup() {
		Atraccion mordor = new Atraccion("Mordor", "Aventura", 100, 2.0, 999);
		Atraccion abismo = new Atraccion("Abismo de Helm", "Aventura", 100, 2.0, 999);
		Atraccion moria = new Atraccion("Moria", "Aventura", 100, 2.0, 999);

		atraccionesList.add(mordor);
		atraccionesList.add(abismo);
		atraccionesList.add(moria);	
	}
	
	@Test
	public void usuario_puedeLlevarPaquete() {

		Promocion descuentoNulo = new Porcentual(0);
		Paquete paquete = new Paquete("paquete", "standard", atraccionesList, descuentoNulo);

		Visitante visitante = new Visitante("Usuario", "Aventura", 500, 100.0);
		
		assertTrue(visitante.llevarPaquete(paquete));
	}
	
	@Test
	public void usuario_sinDinero_NopuedeLlevarPaquete() {

		Promocion descuentoNulo = new Porcentual(0);
		Paquete paquete = new Paquete("paquete", "standard", atraccionesList, descuentoNulo);

		Visitante visitante = new Visitante("Usuario", "Aventura", 10, 100.0);
		
		assertFalse(visitante.llevarPaquete(paquete));
	}
	
	@Test
	public void usuario_sinTiempo_NopuedeLlevarPaquete() {

		Promocion descuentoNulo = new Porcentual(0);
		Paquete paquete = new Paquete("paquete", "standard", atraccionesList, descuentoNulo);

		Visitante visitante = new Visitante("Usuario", "Aventura", 1000, 1.0);
		
		assertFalse(visitante.llevarPaquete(paquete));
	}

}







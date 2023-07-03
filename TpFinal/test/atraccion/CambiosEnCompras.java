package atraccion;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Clases.*;
import Clases.clasePromocion.*;


public class CambiosEnCompras{
	
	@Test
	public void compraAtraccion_reduceCupo() {
		Atraccion atraccion = new Atraccion("Nombre", "Tipo", 100, 2.0, 10);
		Visitante visitante = new Visitante("Usuario", "Aventura", 500, 100.0);
		Integer cupoEsperado = atraccion.getCupo() - 1;

		visitante.llevarAtraccion(atraccion);
		assertEquals(cupoEsperado, atraccion.getCupo());

	}

	@Test
	public void compraPaquete_reduceCupo() {

		Visitante visitante = new Visitante("Usuario", "Aventura", 500, 100.0);

		
		Atraccion mordor = new Atraccion("Mordor", "Aventura", 100, 2.0, 10);
		Atraccion abismo = new Atraccion("Abismo de Helm", "Aventura", 100, 2.0, 10);
		Atraccion moria = new Atraccion("Moria", "Aventura", 100, 2.0, 10);
		List<Atraccion> atraccionesList = new ArrayList<Atraccion>();
		atraccionesList.add(mordor);
		atraccionesList.add(abismo);
		atraccionesList.add(moria);
		
		Integer cupoEsperado = atraccionesList.get(0).getCupo() - 1;
		
		Promocion descuentoNulo = new Porcentual(0);
		Paquete paquete = new Paquete("Paquete", "Aventura", atraccionesList, descuentoNulo);
		
		visitante.llevarPaquete(paquete);
		
		assertEquals(cupoEsperado, paquete.getAtracciones().get(0).getCupo());
	}

}







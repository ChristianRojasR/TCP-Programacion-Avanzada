package visitante;

import static org.junit.Assert.*;
import org.junit.Test;

import Clases.*;

public class Ofertador_atracciones {

	static Atraccion atraccion = new Atraccion("Nombre", "Default", 100, 2.0, 999);

	@Test
	public void usuario_puedeLlevarAtraccion() {
		Visitante visitante = new Visitante("Usuario", "Aventura", 500, 100.0);
		assertTrue(visitante.llevarAtraccion(atraccion));
	}

	@Test
	public void usuario_sinDinero_noPuedeLlevarAtraccion() {
		Visitante visitante = new Visitante("Usuario", "Aventura", 1, 100.0);
		assertFalse(visitante.llevarAtraccion(atraccion));
	}

	@Test
	public void usuario_sinTiempo_noPuedeLlevarAtraccion() {
		Visitante visitante = new Visitante("Usuario", "Aventura", 1000, 0.5);
		assertFalse(visitante.llevarAtraccion(atraccion));
	}
	
}



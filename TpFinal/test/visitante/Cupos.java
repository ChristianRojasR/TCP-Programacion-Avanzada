package visitante;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Clases.Atraccion;
import Clases.Paquete;
import Clases.Visitante;
import Clases.clasePromocion.Porcentual;
import Clases.clasePromocion.Promocion;

public class Cupos {
	static Atraccion atraccionSinCupo = new Atraccion("Nombre", "Default", 100, 2.0, 0);

	@Test
	public void atraccion_sinCupo_noPuedeLlevarse() {
		Visitante visitante = new Visitante("Usuario", "Aventura", 1000, 100.0);

		assertFalse(visitante.llevarAtraccion(atraccionSinCupo));
	}

	@Test
	public void paquete_sinCupo_noPuedeLlevarse() {
		Visitante visitante = new Visitante("Usuario", "Aventura", 1000, 100.0);

		List<Atraccion> atraccionesList = new ArrayList<Atraccion>();
		atraccionesList.add(atraccionSinCupo);
		Promocion descuentoNulo = new Porcentual(0);
		Paquete paquete = new Paquete("paquete", "standard", atraccionesList, descuentoNulo);

		assertFalse(visitante.llevarPaquete(paquete));

	}

}






package BloquePrincipal;

import Clases.*;
import java.util.*;

public class Sistema {
	public List<Paquete> listaPaquetes;
	public List<Atraccion> listaAtracciones;
	public List<Visitante> clientes;
	private Scanner teclado;

	public Sistema(List<Paquete> listaPaquetes, List<Atraccion> listaAtracciones, List<Visitante> clientes) {
		this.listaPaquetes = listaPaquetes;
		this.listaAtracciones = listaAtracciones;
		this.clientes = clientes;
	}

	public void compras() {
		this.teclado = new Scanner(System.in);
		Collections.sort(listaPaquetes);
		List<Paquete> listaPreferidos = new ArrayList<Paquete>();
		List<Paquete> listaOtros = new ArrayList<Paquete>();

		Collections.sort(listaAtracciones);
		List<Atraccion> listaAtraccionesPreferidas = new ArrayList<Atraccion>();
		List<Atraccion> listaOtrasAtracciones = new ArrayList<Atraccion>();

		for (Visitante cliente : clientes) {
			listaPreferidos.clear();
			listaOtros.clear();
			for (Paquete auxiliar : listaPaquetes) {
				if (auxiliar.getTipo().equalsIgnoreCase(cliente.getTipoPref())) {
					listaPreferidos.add(auxiliar);
				} else {
					listaOtros.add(auxiliar);
				}
			}

			for (Paquete paquete : listaPreferidos) {
				ofertarPaquete(paquete, cliente,"PAQUETE OFRECIDO SEGUN SUS PREFERENCIAS");
			}
			for (Paquete paquete : listaOtros) {
				ofertarPaquete(paquete, cliente,"OTRO PAQUETE");
			}

			listaAtraccionesPreferidas.clear();
			listaOtrasAtracciones.clear();
			for (Atraccion auxiliar : listaAtracciones) {
				if (auxiliar.getTipo().equalsIgnoreCase(cliente.getTipoPref())) {
					listaAtraccionesPreferidas.add(auxiliar);
				} else {
					listaOtrasAtracciones.add(auxiliar);
				}
			}

			for (Atraccion atraccion : listaAtraccionesPreferidas) {
				ofertarAtraccion(atraccion, cliente,"ATRACCION OFRECIDA SEGUN SUS PREFERENCIAS");
			}

			for (Atraccion atraccion : listaOtrasAtracciones) {
				ofertarAtraccion(atraccion, cliente,"OTRO PAQUETE");
			}
			
		}
		teclado.close();
	}

	private void ofertarPaquete(Paquete paquete, Visitante cliente , String mensaje) {
		if (cliente.puedeLLevarPaquete(paquete)) {
			System.out.println("\n===================================================");
			System.out.println(cliente);
			System.out.println("\n "+ mensaje + "\n");
			paquete.mostrarProducto();
			System.out.println("DESEA COMPRAR? <SI> <NO> : ");
			String input = teclado.nextLine();
			while (!input.equalsIgnoreCase("SI") && !input.equalsIgnoreCase("NO")) {
				System.out.println("DESEA COMPRAR? <SI> <NO> : ");
				input = teclado.nextLine();
			}
			if (input.equalsIgnoreCase("SI")) {
				cliente.llevarPaquete(paquete);
			}
		}
	}

	private void ofertarAtraccion(Atraccion atraccion, Visitante cliente,String mensaje) {
		if (cliente.puedeLLevarAtraccion(atraccion)) {
			System.out.println("\n===================================================");
			System.out.println(cliente);
			System.out.println("\n"+ mensaje+"\n");
			atraccion.mostrarProducto();
			System.out.println("DESEA COMPRAR? <SI> <NO> : ");
			String input = teclado.nextLine();
			while (!input.equalsIgnoreCase("SI") && !input.equalsIgnoreCase("NO")) {
				System.out.println("DESEA COMPRAR? <SI> <NO> : ");
				input = teclado.nextLine();
			}
			if (input.equalsIgnoreCase("SI")) {
				cliente.llevarAtraccion(atraccion);
			}
		}
	}

}

package BloquePrincipal;

import java.util.*;

import Clases.*;
import LecturaDeArchivos.Archivo;

public class Sistema {
	public List<Paquete> listaPaquetes;
	public List<Atraccion> listaAtracciones;
	public List<Visitante> clientes;
	private Scanner teclado;

	public Sistema() {
		// CARGA DE DATOS A MEMORIA
		Archivo lecturaUsuarios = new Archivo("Lista de Usuarios");
		this.clientes = lecturaUsuarios.leerArchivoUsuario();

		Archivo lecturAtracciones = new Archivo("Lista de Atracciones");
		this.listaAtracciones = lecturAtracciones.leerArchivoAtraccion();

		Archivo lecturaPaquetes = new Archivo("Lista de Paquetes");
		this.listaPaquetes = lecturaPaquetes.leerArchivoPaquete(this.listaAtracciones);
	}

	public void compras() {
		this.teclado = new Scanner(System.in);

		Collections.sort(listaPaquetes);
		Collections.sort(listaAtracciones);

		List<Paquete> listaPaquetesPreferidos = null;
		List<Atraccion> listaAtraccionesPreferidas = null;

		for (Visitante cliente : clientes) {

			listaPaquetesPreferidos = ordenarPaquetes(listaPaquetes, cliente.getTipoPref());

			for (Paquete paquete : listaPaquetesPreferidos) {
				ofertarPaquete(paquete, cliente, "PAQUETE OFRECIDO SEGUN SUS PREFERENCIAS");
			}

			listaAtraccionesPreferidas = ordenarAtracciones(listaAtracciones, cliente.getTipoPref());

			for (Atraccion atraccion : listaAtraccionesPreferidas) {
				ofertarAtraccion(atraccion, cliente, "ATRACCION OFRECIDA SEGUN SUS PREFERENCIAS");
			}
		}
		teclado.close();

		Archivo guardarCompras = new Archivo("Listado De Ventas");
		guardarCompras.guardarArchivo(this.clientes);
	}

	private void ofertarPaquete(Paquete paquete, Visitante cliente, String mensaje) {
		
		if (cliente.puedeLLevarPaquete(paquete)) {
			System.out.println("\n===================================================");
			System.out.println(cliente);
			System.out.println("\n " + mensaje + "\n");
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

	private void ofertarAtraccion(Atraccion atraccion, Visitante cliente, String mensaje) {
		if (cliente.puedeLLevarAtraccion(atraccion)) {
			System.out.println("\n===================================================");
			System.out.println(cliente);
			System.out.println("\n" + mensaje + "\n");
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

	private List<Paquete> ordenarPaquetes(List<Paquete> listaPaquetes, String tipo) {
		List<Paquete> listaOrdenada = new ArrayList<Paquete>();

		List<Paquete> listaAuxiliar = new ArrayList<Paquete>();

		for (Paquete auxiliar : listaPaquetes) {
			if (auxiliar.getTipo().equalsIgnoreCase(tipo))
				listaOrdenada.add(auxiliar);
			else
				listaAuxiliar.add(auxiliar);
		}

		for (Paquete auxiliar : listaAuxiliar) {
			listaOrdenada.add(auxiliar);
		}

		return listaOrdenada;
	}

	private List<Atraccion> ordenarAtracciones(List<Atraccion> listaAtracciones, String tipo) {
		List<Atraccion> listaOrdenada = new ArrayList<Atraccion>();
		List<Atraccion> listaAuxiliar = new ArrayList<Atraccion>();

		for (Atraccion auxiliar : listaAtracciones) {
			if (auxiliar.getTipo().equalsIgnoreCase(tipo))
				listaOrdenada.add(auxiliar);
			else
				listaAuxiliar.add(auxiliar);
		}

		for (Atraccion auxiliar : listaAuxiliar) {
			listaOrdenada.add(auxiliar);
		}

		return listaOrdenada;
	}

}

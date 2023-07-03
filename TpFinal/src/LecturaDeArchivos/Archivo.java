package LecturaDeArchivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Clases.Atraccion;
import Clases.Paquete;
import Clases.Visitante;
import Clases.clasePromocion.Absoluta;
import Clases.clasePromocion.AxB;
import Clases.clasePromocion.Porcentual;
import Clases.clasePromocion.Promocion;

import java.util.*;

public class Archivo {
	private String nombre;

	public Archivo(String nombre) {
		super();
		this.nombre = nombre;
	}

	public List<Visitante> leerArchivoUsuario() {

		Scanner scanner = null;
		List<Visitante> usuarios = null;

		try {
			File file = new File("files/in/" + this.nombre + ".txt");
			scanner = new Scanner(file);
			scanner.useLocale(Locale.ENGLISH);

			usuarios = new ArrayList<Visitante>();
			while (scanner.hasNext()) {
				String linea = scanner.nextLine();
				String[] vec = linea.split("\\|");

				usuarios.add(new Visitante(vec[0], vec[3], Integer.parseInt(vec[1]), Double.parseDouble(vec[2])));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		return usuarios;
	}

	public List<Atraccion> leerArchivoAtraccion() {

		Scanner scanner = null;
		List<Atraccion> atracciones = null;

		try {

			File file = new File("files/in/" + this.nombre + ".txt");
			scanner = new Scanner(file);
			scanner.useLocale(Locale.ENGLISH);
			atracciones = new ArrayList<Atraccion>();

			while (scanner.hasNext()) {
				String linea = scanner.nextLine();
				String[] vec = linea.split("\\|");

				atracciones.add(new Atraccion(vec[0], vec[4], Integer.parseInt(vec[1]), Double.parseDouble(vec[2]),
						Integer.parseInt(vec[3])));

			}
			// ORDENO EL LISTADO DE ATRACCIONES
			Atraccion.eliminarDuplicadosPorNombre(atracciones);
			Collections.sort(atracciones);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}

		return atracciones;
	}

	public List<Paquete> leerArchivoPaquete(List<Atraccion> atracciones) {
		Scanner scanner = null;
		List<Paquete> paquetes = null;

		try {
			File file = new File("files/in/" + this.nombre + ".txt");
			scanner = new Scanner(file);
			scanner.useLocale(Locale.ENGLISH);

			paquetes = new ArrayList<>();

			while (scanner.hasNext()) {
				String linea = scanner.nextLine();
				String[] vec = linea.split("\\|");
				String[] nombreAtracciones = vec[2].split(",");

				paquetes.add(new Paquete(vec[0], vec[1], guardarAtraccionesDelPaquete(atracciones, nombreAtracciones),
						instanciarObjetoPromocion(vec[3], vec[4], atracciones)));

			}

			// ORDENO LOS PAQUETES
			Collections.sort(paquetes);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}

		return paquetes;
	}

	private List<Atraccion> guardarAtraccionesDelPaquete(List<Atraccion> atracciones, String[] nombres) {
		List<Atraccion> atraccionesPaquete = new ArrayList<Atraccion>();

		for (int i = 0; i < nombres.length; i++) {

			for (Atraccion a : atracciones) {

				if (a.getNombre().equalsIgnoreCase(nombres[i])) {
					atraccionesPaquete.add(a);
					break;
				}
			}
		}
		return atraccionesPaquete;
	}

	private Promocion instanciarObjetoPromocion(String tipoDePromocion, String dato, List<Atraccion> atracciones) {

		if (tipoDePromocion.equalsIgnoreCase("Porcentual"))
			return new Porcentual(Integer.parseInt(dato));

		if (tipoDePromocion.equalsIgnoreCase("Absoluta"))
			return new Absoluta(Integer.parseInt(dato));

		if (tipoDePromocion.equalsIgnoreCase("Free")) {

			for (Atraccion a : atracciones)
				if (a.getNombre().equalsIgnoreCase(dato))
					return new AxB(a);

		}

		return null;
	}

	public void guardarArchivo(List<Visitante> clientes) {
		FileWriter file = null;
		PrintWriter imprimir = null;

		try {
			file = new FileWriter("files/out/" + this.nombre + ".txt");

			imprimir = new PrintWriter(file);

			for (Visitante cliente : clientes) {
				if (cliente.getCarrito().size() != 0) {
					imprimir.println("\nRESUMEN DE COMPRA DEL CLIENTE: " + cliente.getNombre());
					imprimir.println("============================= ");
					Double tiempoTotal = 0.0;
					imprimir.println("Atracciones reservadas: ");
					for (Atraccion atraccion : cliente.getCarrito()) {
						imprimir.println(atraccion.getNombre());
						tiempoTotal += atraccion.getDuracion();
					}

					imprimir.println("Tiempo Total ---> " + tiempoTotal + " hs");
					imprimir.println("Precio Total  ---> $" + cliente.getGasto() + "\n");
				} else {
					System.out.println(cliente.getNombre() + " no ha realizado compras\n");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

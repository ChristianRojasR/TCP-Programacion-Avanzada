package PackageClases;

import java.util.List;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Archivo lectorArchivoU = new Archivo("pruebaUsuarios");
		List<Usuario> usuarios = lectorArchivoU.leerArchivoUsuario();
		usuarios.sort(null);
//		for (Usuario usuario : users) {
//			System.out.println(usuario);
//		}
		
		Archivo lectorArchivoA = new Archivo("pruebaAtracciones0");
		Set<Atraccion> atracciones = lectorArchivoA.leerArchivoAtraccion();
//		for (Atraccion atraccion : atracciones) {
//			System.out.println(atraccion);
//		}
		
		Archivo lectorArchivoP = new Archivo("pruebaPaquetes0");
		Set<Paquete> paquetes = lectorArchivoP.leerArchivoPaquete(atracciones);
//		for (Paquete paquete : paquetes) {
//			System.out.println(paquete);
//		}
		System.out.println("Bienvenido/a a Turismo en la Tierra Media\n"
				+ "--------------------------------------------------------");
		
		ProductoManager productoManager = ProductoManager.getInstance();
		
		productoManager.agregarAtracciones(atracciones);
		productoManager.agregarPaquetes(paquetes);
		int i = 0;
		for (Usuario usuario : usuarios) {
			Archivo salida = new Archivo("prueba_" + i);
			salida.guardarArchivo(productoManager.sugerirPaquetesUsuario(usuario), usuario);
			i++;
		}
		System.out.println("Muchas gracias por elegirnos!");
	}
}

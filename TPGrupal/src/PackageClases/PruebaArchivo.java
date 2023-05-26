package PackageClases;

import java.util.List;
import java.util.Set;

public class PruebaArchivo {
	public static void main(String[] args) {
		Archivo lectorArchivoU = new Archivo("pruebaUsuarios");
		List<Usuario> users = lectorArchivoU.leerArchivoUsuario();
		users.sort(null);
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
		
		ProductoManager productoManager = ProductoManager.getInstance();
		
		productoManager.agregarAtracciones(atracciones);
		productoManager.agregarPaquetes(paquetes);
		System.out.println(productoManager);
		
	}
}

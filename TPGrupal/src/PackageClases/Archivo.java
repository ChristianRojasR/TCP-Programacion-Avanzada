package PackageClases;

import java.io.File;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Archivo {
	private String nombre;

	public Archivo(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public Set<Usuario> leerArchivoUsuario(){
		
		Scanner scanner = null;
		Set<Usuario> usuarios = null;
		
		try {
			File file = new File("casos-de-prueba/in/" + this.nombre + ".in");
			scanner = new Scanner(file);
			
			scanner.useLocale(Locale.ENGLISH);
			
			//Aca comienza la lectura del archivo
			//Inicializo el Set como TreeSet para optimizar la busqueda
			usuarios = new TreeSet<Usuario>();
			int cantUsuarios = scanner.nextInt();
			for (int i = 0; i < cantUsuarios; i++) {
				usuarios.add(new Usuario(scanner.next(), scanner.next(), scanner.nextInt(), scanner.nextDouble()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		return usuarios;
	}
	
	public Set<Atraccion> leerArchivoAtraccion(){
		
		Scanner scanner = null;
		Set<Atraccion> atracciones = null;
		
		try {
			File file = new File("casos-de-prueba/in/" + this.nombre + ".in");
			scanner = new Scanner(file);
			
			scanner.useLocale(Locale.ENGLISH);
			
			//Aca comienza la lectura del archivo
			//Inicializo el Set como TreeSet para optimizar la busqueda
			atracciones = new TreeSet<Atraccion>();
			int cantAtracciones = scanner.nextInt();
			for (int i = 0; i < cantAtracciones; i++) {
				atracciones.add(new Atraccion(scanner.next(), scanner.next(), scanner.nextInt(),
						scanner.nextDouble(), scanner.nextInt()));
			}
		} catch (Exception e) {    
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		
		return atracciones;
	}

	public Set<Paquete> leerArchivoPaquete(Set<Atraccion> atracciones){
		
		Scanner scanner = null;
		Set<Paquete> paquetes = null;
		
		try {
			File file = new File("casos-de-prueba/in/" + this.nombre + ".in");
			scanner = new Scanner(file);
			
			scanner.useLocale(Locale.ENGLISH);
			
			//Aca comienza la lectura del archivo
			//Inicializo el Set como TreeSet para optimizar la busqueda
			paquetes = new TreeSet<Paquete>();
			int cantPaquetes = scanner.nextInt();
			for (int i = 0; i < cantPaquetes; i++) {
				paquetes.add(new Paquete(scanner.next(), scanner.next(),
						guardarAtraccionesDelPaquete(scanner.nextInt(),scanner, atracciones),
						instanciarObjetoPromocion(scanner.next(), scanner)));
			}
		} catch (Exception e) {    
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		
		return paquetes;
	}
	
	private Set<Atraccion> guardarAtraccionesDelPaquete(int cantAtracciones,Scanner scanner, Set<Atraccion> atracciones){
		Set<Atraccion> atraccionesPaquete = new TreeSet<Atraccion>();
		
		for (int i = 0; i < cantAtracciones; i++) {
			String nombreAtraccion = scanner.next();
			
			for (Atraccion atraccion : atracciones) {
				if(atraccion.nombre.equals(nombreAtraccion)) {
					atraccionesPaquete.add(atraccion);
					break;
				}
			}
		}
		return atraccionesPaquete;
	}
	
	private Promocion instanciarObjetoPromocion(String tipoDePromocion, Scanner scanner) {
		if(tipoDePromocion.equals("Porcentual"))
			return new Porcentual(scanner.nextDouble());
		if(tipoDePromocion.equals("Absoluta"))
			return new Absoluta(scanner.nextInt());
		return new AxB(scanner.next());
	}
}

package PackageClases;

import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;

public class ProductoManager {
	private static ProductoManager instance;
	private Set<Producto> paquetes;
	private Set<Producto> atracciones;
	
	private ProductoManager() {
		this.paquetes = new TreeSet<Producto>();
		this.atracciones = new TreeSet<Producto>();
	}
	
	public static ProductoManager getInstance() {
		if(instance == null) {
			instance = new ProductoManager();
		}
		return instance;
	}
	
	public void agregarAtracciones(Set<Atraccion> atracciones) {
		this.atracciones.addAll(atracciones);
	}
	
	public void agregarPaquetes(Set<Paquete> paquetes) {
		this.paquetes.addAll(paquetes);
	}

	public List<Producto> sugerirPaquetesUsuario(Usuario usuario) {
		Scanner scanner = new Scanner(System.in);
		List<Producto> productosElegidos = new LinkedList<Producto>();
		
		resetEsValido();
		
		productosElegidos.addAll(productosConPreferencia(paquetes, usuario, scanner));
		productosElegidos.addAll(productosSinPreferencia(paquetes, usuario, scanner));
		productosElegidos.addAll(productosConPreferencia(atracciones,usuario, scanner));
		productosElegidos.addAll(productosSinPreferencia(atracciones,usuario, scanner));
		
		scanner.close();
		return productosElegidos;
	}
	
	private boolean leerRespuesta(Producto producto, Scanner scanner) {
		int respuesta = 0;
		do {
			System.out.println(producto + "\n1. Si desea contratar el producto\n0. Si no lo desea\n");
			respuesta = scanner.nextInt();
		}while(respuesta != 1 && respuesta != 0);
		return respuesta == 1 ? true : false;
	}
	
	private List<Producto> productosConPreferencia(Set<Producto> productos, Usuario usuario, Scanner scanner){
		List<Producto> productosElegidos = new LinkedList<Producto>();
		
		for (Producto producto : productos) {
			if(producto.tipo.equals(usuario.getTipo())&&
			   producto.tiempo <= usuario.getTiempo() &&
			   producto.precio <= usuario.getPlata() &&
			   producto.cupo > 0 && producto.esValido) {
				if(leerRespuesta(producto, scanner)) {
					productosElegidos.add(producto);
					producto.cupo --;
					producto.esValido = false;
					usuario.setPlata(producto.precio);
					usuario.setTiempo(producto.tiempo);
					
					if(producto instanceof Paquete) 
						((Paquete)producto).visit(atracciones);
					else
						producto.visit();
				}
			}
		}
		return productosElegidos;
	}
	
	private List<Producto> productosSinPreferencia(Set<Producto> productos, Usuario usuario, Scanner scanner){
		List<Producto> productosElegidos = new LinkedList<Producto>();
		
		for (Producto producto : productos) {
			if(!producto.tipo.equals(usuario.getTipo())&&
			   producto.tiempo <= usuario.getTiempo() &&
			   producto.precio <= usuario.getPlata() &&
			   producto.cupo > 0 && producto.esValido) {
				if(leerRespuesta(producto, scanner)) {
					productosElegidos.add(producto);
					producto.cupo --;
					producto.esValido = false;
					usuario.setPlata(producto.precio);
					usuario.setTiempo(producto.tiempo);
					
					if(producto instanceof Paquete) 
						((Paquete)producto).visit(atracciones);
					else
						producto.visit();
				}
			}
		}
		return productosElegidos;
	}
	
	private void resetEsValido() {
		for(Producto atraccion : this.atracciones)
			atraccion.esValido = true;
		for (Producto paquete : this.paquetes) {
			paquete.esValido = true;
		}
	}
}

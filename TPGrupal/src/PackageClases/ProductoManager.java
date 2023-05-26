package PackageClases;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.LinkedList;

public class ProductoManager {
	private static ProductoManager instance;
	private Set<Producto> productos;
	
	private ProductoManager() {
		this.productos = new TreeSet<Producto>();
	}
	
	public static ProductoManager getInstance() {
		if(instance == null) {
			instance = new ProductoManager();
		}
		return instance;
	}
	
	public void agregarAtracciones(Set<Atraccion> atracciones) {
		this.productos.addAll(atracciones);
	}
	
	public void agregarPaquetes(Set<Paquete> paquetes) {
		this.productos.addAll(paquetes);
	}

	@Override
	public String toString() {
		List<String> nombres = new LinkedList<String>();
		for (Producto producto : productos) {
			nombres.add(producto.toString());
		}
		return String.join("\n", nombres);
	}
	
}

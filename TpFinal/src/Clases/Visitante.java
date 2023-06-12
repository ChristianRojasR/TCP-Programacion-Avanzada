package Clases;
import java.util.*;

public class Visitante {
	private String nombre;
	private String tipoPref;
	private Integer presupuesto;
	private Double tiempoDisp;
	private List<Atraccion> carrito;
	private Integer gasto = 0;
	
	public Visitante(String nombre, String tipoPref, Integer presupuesto, Double tiempoDisp) {
		this.nombre = nombre;
		this.tipoPref = tipoPref;
		this.presupuesto = presupuesto;
		this.tiempoDisp = tiempoDisp;
		this.carrito = new LinkedList<Atraccion>();
	}

	///<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

	public List<Atraccion> getCarrito() {
		return carrito;
	}

	public Integer getGasto() {
		return gasto;
	}

	public void añadirACarrito(Atraccion atraccion)
	{
		this.carrito.add(atraccion);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getTipoPref() {
		return tipoPref;
	}

	public Integer getPresupuesto() {
		return presupuesto;
	}

	public Double getTiempoDisp() {
		return tiempoDisp;
	}
	
	@Override
	public String toString() {
		return "Nombre de visitante: " + nombre + "\n * Preferencia: " + tipoPref + "\n * Presupuesto: $" + presupuesto
				+ "\n * Tiempo disp: " + tiempoDisp + " hs" ;
	}

	///<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

	
	public boolean puedeLLevarAtraccion(Atraccion atraccion) {
		if (atraccion.existsAttractionInCarrito(this.carrito)|| atraccion.getCupo() == 0 || this.presupuesto < atraccion.getPrecio()
				|| this.tiempoDisp < atraccion.getDuracion())
			return false;

		return true;
	}

	public boolean llevarAtraccion(Atraccion atraccion) {
		if (!puedeLLevarAtraccion(atraccion))
			return false;

		atraccion.visit();
		presupuesto -= atraccion.getPrecio();
		tiempoDisp -= atraccion.getDuracion();
		this.carrito.add(atraccion);
		this.gasto += atraccion.getPrecioOriginal();
		
		return true;
	}
	
	public boolean puedeLLevarPaquete(Paquete paquete) {
		if (paquete.existsAttractionInPackage(this.carrito)||!paquete.hayCupo() || this.presupuesto < paquete.getPrecioFinal()
				|| this.tiempoDisp < paquete.getDuracion())
			return false;

		return true;
	}
	
	
	public boolean llevarPaquete(Paquete paquete) {
		if (!puedeLLevarPaquete(paquete))
			return false;

		paquete.visit();
		presupuesto -= paquete.getPrecioFinal();
		this.gasto += paquete.getPrecioFinal();
		
		tiempoDisp -= paquete.getDuracion();
		
		for(Atraccion atraccion : paquete.getAtracciones())
		{
			this.carrito.add(atraccion);
		}
		
		return true;
	}	
	
}

package Clases;

public abstract class ProductosOfrecidos {
	protected String nombre;
	protected String tipo;
	protected int precioOriginal;
	protected Double duracion;
	
	
	public ProductosOfrecidos(String nombre, String tipo, int precioOriginal, Double duracion) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.precioOriginal = precioOriginal;
		this.duracion = duracion;
	}

	
	public ProductosOfrecidos(String nombre, String tipo) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
	}

	
	///<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

	public void mostrarProducto() {
		System.out.println(this.toString());
	}

	
	public abstract void visit();
	
	
	
	///<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

	
	public int getPrecio() {
		return precioOriginal;
	}

	public Double getDuracion() {
		return duracion;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public int getPrecioOriginal() {
		return precioOriginal;
	}

}



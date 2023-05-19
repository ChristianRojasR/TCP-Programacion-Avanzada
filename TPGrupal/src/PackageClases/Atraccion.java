package PackageClases;

public class Atraccion {
	private Integer tipoAtraccion;
	
	private Integer precioEnMiles;
	
	private Double duracion;
	
	private Integer cupos;

	public Atraccion(Integer tipoAtraccion, Integer precioEnMiles, Double duracion, Integer cupos) {
		this.tipoAtraccion = tipoAtraccion;
		this.precioEnMiles = precioEnMiles;
		this.duracion = duracion;
		this.cupos = cupos;
	}
	
}

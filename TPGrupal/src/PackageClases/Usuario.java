package PackageClases;

public class Usuario implements Comparable<Usuario>{
	private String nombre;
	
	private String tipo;
	
	private int plata;
	
	private double tiempo;

	public Usuario(String nombre, String tipo, int plata, double tiempo) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.plata = plata;
		this.tiempo = tiempo;
	}

	@Override
	public String toString() {
		return  nombre + "\n" + tipo + "\n" + plata + " $\n" + tiempo + " hs\n=====================";
	}

	@Override
	public int compareTo(Usuario o) {
		int resultado;
		if((resultado = this.tipo.charAt(0) - o.tipo.charAt(0)) == 0) {
			if((resultado = this.plata - o.plata) == 0)
				return (int) (this.tiempo - o.tiempo);
		}
		return resultado;
	}
	
}

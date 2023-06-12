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
		return nombre.toUpperCase() + "\n-Plata: " + plata + " $\n-Tiempo: " + tiempo + " hs\n";
	}

	@Override
	public int compareTo(Usuario o) {
		int resultado;
		if((resultado = this.tipo.compareTo(o.tipo)) == 0) {
			if((resultado = o.plata - this.plata) == 0)
				return (int) (this.tiempo - o.tiempo);
		}
		return resultado;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public int getPlata() {
		return plata;
	}

	public double getTiempo() {
		return tiempo;
	}

	public void setPlata(int plata) {
		this.plata -= plata;
	}

	public void setTiempo(double tiempo) {
		this.tiempo -= tiempo;
	}
}

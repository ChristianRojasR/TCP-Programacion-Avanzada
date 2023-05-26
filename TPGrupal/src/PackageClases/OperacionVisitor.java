package PackageClases;

public class OperacionVisitor implements Visitor{

	@Override
	public void visitarAtraccion(Atraccion atraccion) {
		atraccion.esValido = false;
	}

	@Override
	public void visitarPaquete(Paquete paquete) {
		for (Atraccion atraccion : paquete.getAtracciones()) {
			atraccion.esValido = false;
		}
		paquete.esValido = false;
	}
	
}

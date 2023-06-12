package BloquePrincipal;

import java.util.List;

import Clases.*;
import LecturaDeArchivos.*;

public class Main {

	public static void main(String[] args) {

		// CARGA DE DATOS A MEMORIA
		Archivo lecturaUsuarios = new Archivo("Lista_de_Usuarios");
		List<Visitante> visitantes;
		visitantes = lecturaUsuarios.leerArchivoUsuario();

		Archivo lecturAtracciones = new Archivo("Lista_de_Atracciones");
		List<Atraccion> atracciones;
		atracciones = lecturAtracciones.leerArchivoAtraccion();

		Archivo lecturaPaquetes = new Archivo("Lista_de_Paquetes");
		List<Paquete> paquetes;
		paquetes = lecturaPaquetes.leerArchivoPaquete(atracciones);
		
		Sistema sistema = new Sistema(paquetes, atracciones, visitantes);
		sistema.compras();
		
		Archivo guardarCompras = new Archivo("Lista_De_Ventas");
		guardarCompras.guardarArchivo(visitantes);
	}
}










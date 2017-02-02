package ejercicioEmpresaAgroalimentaria;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Producto {
	private String nombre;
	private Date fechaCaducidad;
	private int numeroLote;
	
	public Producto(String nombre, Date fechaCaducidad, int numeroLote){
		this.nombre = nombre;
		this.fechaCaducidad = fechaCaducidad;
		this.numeroLote = numeroLote;
	}

	@Override
	public String toString() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return "Nombre: "+this.nombre+"\n"+
				"Fecha Caducidad: "+format.format(this.fechaCaducidad)+"\n"+
				"Numero de lote: "+this.numeroLote;
	}
	
}

package ejercicioEmpresaAgroalimentaria;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Frescos extends Producto{
	private Date fechaEnvasada;
	private String paisOrigen;
	
	public Frescos(String nombre, Date fechaCaducidad, int numeroLote,
			Date fechaEnvasada, String paisOrigen){
		super(nombre, fechaCaducidad, numeroLote);
		this.fechaEnvasada = fechaEnvasada;
		this.paisOrigen = paisOrigen;
	}

	@Override
	public String toString() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return super.toString()+"\n"+
				"Fecha de envasado: "+format.format(this.fechaEnvasada)+"\n"+
				"Pais de origen: "+this.paisOrigen;
	}
	
}

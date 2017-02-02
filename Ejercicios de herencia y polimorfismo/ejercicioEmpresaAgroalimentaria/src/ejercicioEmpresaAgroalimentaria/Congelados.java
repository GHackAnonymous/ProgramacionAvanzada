package ejercicioEmpresaAgroalimentaria;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Congelados extends Producto{
	private Date fechaEnvasada;
	private String paisOrigen;
	private int temperatura;
	
	public Congelados(String nombre, Date fechaCaducidad, int numeroLote, 
			Date fechaEnvasada, String paisOrigen,
			int temperatura){
		super(nombre, fechaCaducidad, numeroLote);
		this.fechaEnvasada = fechaEnvasada;
		this.paisOrigen = paisOrigen;
		this.temperatura = temperatura;
	}
	@Override
	public String toString() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return super.toString()+"\n"+
				"Fecha de envasado: "+format.format(this.fechaEnvasada)+"\n"+
				"Pais de origen: "+this.paisOrigen+"\n"+
				"Temperatura: "+this.temperatura+"C";
	}
	
}

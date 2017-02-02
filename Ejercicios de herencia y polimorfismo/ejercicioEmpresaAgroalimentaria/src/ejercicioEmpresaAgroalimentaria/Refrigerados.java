package ejercicioEmpresaAgroalimentaria;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Refrigerados extends Producto{
	private int codigoOrganico;
	private Date fechaEnvasada;
	private int temperatura;
	private String paisOrigen;
	
	public Refrigerados(String nombre, Date fechaCaducidad, int numeroLote, 
			int codigoOrganico, Date fechaEnvasada,
			int temperatura, String paisOrigen){
		super(nombre, fechaCaducidad, numeroLote);
		this.codigoOrganico = codigoOrganico;
		this.fechaEnvasada = fechaEnvasada;
		this.temperatura = temperatura;
		this.paisOrigen = paisOrigen;
		
	}

	@Override
	public String toString() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return super.toString()+"\n"+
				"Codigo organico: "+this.codigoOrganico+"\n"+
				"Fecha de envasado: "+format.format(this.fechaEnvasada)+"\n"+
				"Temperatura: "+this.temperatura+"C \n"+
				"Pais de Origen: "+this.paisOrigen;
	}
	
}

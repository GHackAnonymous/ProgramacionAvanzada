package ejercicioEmpresaAgroalimentaria;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Nitrogeno extends Congelados{
	private String metodo;
	private Date tiempoExpuesto;
	
	public Nitrogeno(String nombre, Date fechaCaducidad, int numeroLote, 
			Date fechaEnvasada, String paisOrigen,
			int temperatura,String metodo, Date tiempoExpuesto){
		super(nombre, fechaCaducidad, numeroLote, 
				fechaEnvasada, paisOrigen,
				temperatura);
		this.metodo = metodo;
		this.tiempoExpuesto = tiempoExpuesto;
	}
	@Override
	public String toString() {
		DateFormat format = new SimpleDateFormat("HH:mm:ss");
		return super.toString()+"\n"+
				"Metodo de congelacion: "+this.metodo+"\n"+
				"Tiempo expuesto: "+format.format(this.tiempoExpuesto);
	}
	
}

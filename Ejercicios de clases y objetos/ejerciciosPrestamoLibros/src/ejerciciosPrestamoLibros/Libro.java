package ejerciciosPrestamoLibros;

import java.util.Date;

public class Libro {
	private int id;
	private String nombre;
	private String nombrePersonaPrestado;
	private Date fechaPresatamo;
	
	public Libro(int id, String nombre){
		this.id = id;
		this.nombre = nombre;
	}
	
	public void hacerPrestamo( String nombrePersonaPrestado){
		fechaPresatamo = new Date();
		this.fechaPresatamo.toInstant();
		this.nombrePersonaPrestado = nombrePersonaPrestado;
	}
	public void devolver(){
		this.fechaPresatamo = null;
		this.nombrePersonaPrestado = null;
	}
	@Override
	public String toString() {
		return "Id: "+this.id+"\n"+
				"Nombre: "+this.nombre;
	}
	public Date getFechaPresatamo() {
		return fechaPresatamo;
	}
	public String getNombrePersonaPrestado() {
		return nombrePersonaPrestado;
	}
}

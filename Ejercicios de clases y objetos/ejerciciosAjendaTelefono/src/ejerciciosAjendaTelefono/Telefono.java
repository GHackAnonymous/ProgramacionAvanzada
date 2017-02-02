package ejerciciosAjendaTelefono;

import java.util.Arrays;

public class Telefono {
	private int[] numero;
	private String nombre;
	
	public Telefono(int[] numero, String nombre){
		this.nombre = nombre;
		this.numero = numero;
	}

	public int[] getNumero() {
		return numero;
	}

	public void setNumero(int[] numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Nombre: "+this.nombre+"\n"+
				"Numero: "+Arrays.toString(numero);
	}
}

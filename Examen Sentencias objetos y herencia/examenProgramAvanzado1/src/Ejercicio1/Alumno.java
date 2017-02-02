package Ejercicio1;

public class Alumno {
	private int id;
	private String nombre;
	private String apellido;
	private String poblacion;
	private String sexo;
	private double nota;
	
	public Alumno(int id, String nombre, String apellido, String poblacion, String sexo, double nota){
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.poblacion = poblacion;
		this.sexo = sexo;
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "ID: "+this.id+"\n"+
				"Nombre: "+this.nombre+" "+this.apellido+"\n"+
				"Sexo: "+this.sexo+"\n"+
				"Poblacion: "+this.poblacion+"\n"+
				"Nota: "+this.nota;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public String getSexo() {
		return sexo;
	}

	public double getNota() {
		return nota;
	}
	
	
}

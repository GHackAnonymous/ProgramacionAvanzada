package ejercicio2;

public class Alumno {
	private int id;
	private String nombre;
	private String apellido;
	private String poblacion;
	private String sexo;
	private double nota;
	
	public Alumno(int id, String nombre, String apellido, String poblacion,
	String sexo, double nota){
		
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.poblacion = poblacion;
		this.sexo = sexo;
		this.nota = nota;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public String toStringPoblacion() {
		return this.poblacion;
	}
	public String toStringSexo() {
		return this.sexo;
	}
	public String toStringNotas() {
		return ""+this.nota;
	}
}

package notasAlumnoClaseFicheros;

public class Alumno {
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String nombreAsig1;
	private double notaAsig1;
	private String nombreAsig2;
	private double notaAsig2;
	private String nombreAsig3;
	private double notaAsig3;
	private String nombreAsig4;
	private double notaAsig4;
	
	public Alumno(String nombre, String apellido1, String apellido2){
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
	}
	public Alumno(String nombre, String apellido1, String apellido2, String nombreAsig1,
	double notaAsig1, String nombreAsig2, double notaAsig2, String nombreAsig3, double notaAsig3,
	String nombreAsig4, double notaAsig4){
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.nombreAsig1 = nombreAsig1;
		this.notaAsig1 = notaAsig1;
		this.nombreAsig2 = nombreAsig2;
		this.notaAsig2 = notaAsig2;
		this.nombreAsig3 = nombreAsig3;
		this.notaAsig3 = notaAsig3;
		this.nombreAsig4 = nombreAsig4;
		this.notaAsig4 = notaAsig4;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getNombreAsig1() {
		return nombreAsig1;
	}
	public void setNombreAsig1(String nombreAsig1) {
		this.nombreAsig1 = nombreAsig1;
	}
	public double getNotaAsig1() {
		return notaAsig1;
	}
	public void setNotaAsig1(double notaAsig1) {
		this.notaAsig1 = notaAsig1;
	}
	public String getNombreAsig2() {
		return nombreAsig2;
	}
	public void setNombreAsig2(String nombreAsig2) {
		this.nombreAsig2 = nombreAsig2;
	}
	public double getNotaAsig2() {
		return notaAsig2;
	}
	public void setNotaAsig2(double notaAsig2) {
		this.notaAsig2 = notaAsig2;
	}
	public String getNombreAsig3() {
		return nombreAsig3;
	}
	public void setNombreAsig3(String nombreAsig3) {
		this.nombreAsig3 = nombreAsig3;
	}
	public double getNotaAsig3() {
		return notaAsig3;
	}
	public void setNotaAsig3(double notaAsig3) {
		this.notaAsig3 = notaAsig3;
	}
	public String getNombreAsig4() {
		return nombreAsig4;
	}
	public void setNombreAsig4(String nombreAsig4) {
		this.nombreAsig4 = nombreAsig4;
	}
	public double getNotaAsig4() {
		return notaAsig4;
	}
	public void setNotaAsig4(int notaAsig4) {
		this.notaAsig4 = notaAsig4;
	}
	@Override
	public String toString() {
		return this.apellido1+" "+this.apellido2+", "+this.nombre;
	}
	public String escribirParaFichero() {
		return this.nombre+"$"+this.apellido1+"$"+this.apellido2+"\n"
				+this.nombreAsig1+"$"+this.notaAsig1+"\n"
				+this.nombreAsig2+"$"+this.notaAsig2+"\n"
				+this.nombreAsig3+"$"+this.notaAsig3+"\n"
				+this.nombreAsig4+"$"+this.notaAsig4+"\n";
	}
}

public class Alumno {
	final int NUMCAMPOS = 6;
	String nombre;
	String apellido1;
	String apellido2;
	String poblacion;
	int edad;
	double nota;
	
	public Alumno(String nombre, String apellido1, String apellido2, String poblacion, int edad, double nota){
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.poblacion = poblacion;
		this.edad = edad;
		this.nota = nota;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public int getEdad() {
		return edad;
	}

	public double getNota() {
		return nota;
	}
	
	public Class<?> getFieldClass(int indice){
		switch (indice){
			case 4: 
				return Integer.class;
			case 5:
				return Double.class;
			default: 
				return String.class; 
		}
	}

	public Object getFieldAt(int columna) {
		switch (columna){
			case 0: 
				return this.nombre;
			case 1: 
				return this.apellido1;
			case 2: 
				return this.apellido2;
			case 3: 
				return this.poblacion;
			case 4: 
				return new Integer(edad);
			case 5: 
				return new Double(nota);
			default: 
				return null; 
		}
	}
}

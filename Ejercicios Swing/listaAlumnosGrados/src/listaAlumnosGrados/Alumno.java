package listaAlumnosGrados;

public class Alumno {

	int id;
	String nombre;
	String apellido1;
	String apellido2;
	ListaResultadosAprendizaje notas;
	
	public Alumno (int id, String nombre, String  apellido1,String apellido2,ListaResultadosAprendizaje notas){
		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.notas = notas;
	}

	public ListaResultadosAprendizaje getNotas() {
		return notas;
	}

	public boolean tieneTodosAprobados() {
		boolean aprobado = true;
		for (int i = 0; i<notas.getSize(); i++){
			double nota = notas.get(i).getNota();
			if (nota<5.0){
				aprobado = false;
				break;
			}
		}
		return aprobado;
	}

	@Override
	public String toString() {
		
		return id + " "+ nombre + " "+ apellido1+ " "+ apellido2;
	}

	public String escribir() {
		String linea;
		linea = id+"$"+nombre+"$"+apellido1+"$"+apellido2+"$"+notas.escribir();
		
		return linea;
		
		
		
	}
				
}

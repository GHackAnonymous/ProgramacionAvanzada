package listaAlumnosGrados;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.DefaultListModel;

public class Clase extends DefaultListModel<Alumno>{
	final String FICH_ALUMNOS = "clase.txt";
	String nombre;
	
	public Clase (String nombre){
		this.nombre = nombre;	
	}

	public void inicializar() {

		String linea = null;
		String valoresAlumno [];
		String valoresNotas[];
		try (BufferedReader in = new BufferedReader(new FileReader(this.FICH_ALUMNOS))){
			
			while ((linea = in.readLine())!=null){
				valoresAlumno = linea.split("[$]");
				ListaResultadosAprendizaje resultados = new ListaResultadosAprendizaje();
				Alumno alumno = new Alumno (Integer.parseInt(valoresAlumno[0]),valoresAlumno[1],valoresAlumno[2],
						valoresAlumno[3],resultados);
				valoresNotas = valoresAlumno[4].split("[&]");
				for (int i = 0; i<valoresNotas.length; i++){
					alumno.getNotas().getElementAt(i).setNota(Float.parseFloat(valoresNotas[i]));
				}
				this.addElement(alumno);
			}
		
		} catch (FileNotFoundException e) {e.printStackTrace();
		} catch (IOException e) {e.printStackTrace();
		}
	}

	public void guardarEnFichero() {
		try (PrintWriter out = new PrintWriter(new FileWriter (this.FICH_ALUMNOS))){
			
			for (int i = 0;i< this.size(); i++){
				out.println(this.getElementAt(i).escribir());
			}
			
		} catch (IOException e) {e.printStackTrace();
		}
	}
}

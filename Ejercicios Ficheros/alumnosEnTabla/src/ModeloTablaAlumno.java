import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.table.AbstractTableModel;

public class ModeloTablaAlumno extends AbstractTableModel {
	
	final static String NOMBRE_FICHERO = "files/listaclase.txt";
	ModeloColumnasTablaAlumnos columnas;
	List<Alumno> listaAlumnos;
	List<Alumno> alumnosFiltrados;
	
	public ModeloTablaAlumno(ModeloColumnasTablaAlumnos columnas){
		super();
		leerTablaFichero();
		this.columnas = columnas;	
	}
	
	private void leerTablaFichero() {
		String linea = null;
		listaAlumnos = new ArrayList<>();
		alumnosFiltrados = new ArrayList<>();
		Alumno alumno = null;
		
		try (BufferedReader in = new BufferedReader(new FileReader(NOMBRE_FICHERO))){
			
			while((linea = in.readLine())!=null){
				alumno = leerAlumno(linea);
				if (alumno!=null){
					listaAlumnos.add(alumno);
				}
			}
		} catch (FileNotFoundException e) {e.printStackTrace();
		} catch (IOException e) {e.printStackTrace();
		}
		
		for(Alumno al : listaAlumnos) {
			alumnosFiltrados.add(al);
		}
	}
	
	private Alumno leerAlumno(String linea) {
		String [] palabras = linea.split("[$]");
		Alumno alumno = new Alumno (palabras[0],palabras[1],palabras[2],palabras[3],
				Integer.parseInt(palabras[4]), Double.parseDouble(palabras[5]));
		return alumno;
	}

	@Override
	public int getColumnCount() {
		return columnas.getColumnCount();
	}

	@Override
	public int getRowCount() {
		return alumnosFiltrados.size();
	}

	@Override
	public Object getValueAt(int fila, int columna) {
		Alumno alumno = alumnosFiltrados.get(fila);
		return alumno.getFieldAt(columna);
	}
		
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return getValueAt(0,columnIndex).getClass();
	}

	public void filtrarPorPoblacion(String poblacion) {
		alumnosFiltrados.clear();
		alumnosFiltrados = listaAlumnos.stream()
				.filter(a->a.getPoblacion().equalsIgnoreCase(poblacion))
				.collect(Collectors.toList());	
		this.fireTableDataChanged();
	}

	public void todosLosAlumnos() {
		alumnosFiltrados.clear();
		for(Alumno al : listaAlumnos) {
			alumnosFiltrados.add(al);
		}
		this.fireTableDataChanged();
	}

	public void filtrarPorEdad(int edad) {
		alumnosFiltrados.clear();
		alumnosFiltrados = listaAlumnos.stream()
				.filter(a -> a.getEdad() == edad)
				.collect(Collectors.toList());	
		this.fireTableDataChanged();
		
	}

	public void filtrarPorNombre(String nombre) {
		alumnosFiltrados.clear();
		alumnosFiltrados = listaAlumnos.stream()
				.filter(a -> a.getNombre().equalsIgnoreCase(nombre))
				.collect(Collectors.toList());	
		this.fireTableDataChanged();
	}
	
	public void filtrarPorApellido(String apellido) {
		alumnosFiltrados.clear();
		alumnosFiltrados = listaAlumnos.stream()
				.filter(a -> a.getApellido1().equalsIgnoreCase(apellido))
				.collect(Collectors.toList());	
		this.fireTableDataChanged();
	}
}

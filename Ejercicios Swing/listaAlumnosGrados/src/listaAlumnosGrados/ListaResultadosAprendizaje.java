package listaAlumnosGrados;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.DefaultListModel;

public class ListaResultadosAprendizaje extends DefaultListModel<ResultadoAprendizaje>{

	final String FICHERORESULTADOS = "resultados.txt";

	public ListaResultadosAprendizaje(){
		super();
		inicializarListaResultados();
	}
	private void inicializarListaResultados() {
		BufferedReader in = null;
		String linea = null;
		String valores[] = null;
		try {
			in = new BufferedReader(new FileReader(this.FICHERORESULTADOS));
			while ((linea = in.readLine())!=null){
				valores = linea.split("[$]");
				ResultadoAprendizaje resultado = new ResultadoAprendizaje(valores[0],valores[1]);
				this.addElement(resultado);
			}
			
		} catch (FileNotFoundException e) {e.printStackTrace();
		} catch (IOException e) {e.printStackTrace();
		}finally{
			if (in!=null){
				try { in.close();} catch (IOException e) {}
			}
		}
		}
	public String escribir() {
		String linea;
		linea = String.valueOf(this.getElementAt(0).getNota());
		for (int i = 1; i<this.getSize();i++){
			linea += "&"+ String.valueOf(this.getElementAt(i).getNota());
		}
		return linea;
	}
}

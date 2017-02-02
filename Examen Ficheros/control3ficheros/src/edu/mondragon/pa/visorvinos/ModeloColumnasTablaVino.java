package edu.mondragon.pa.visorvinos;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

public class ModeloColumnasTablaVino extends DefaultTableColumnModel{
	
	TrazadorTablaVino trazador;
	
	public ModeloColumnasTablaVino(TrazadorTablaVino trazador){
		super();
		this.trazador = trazador;
		this.addColumn(crearColumna("Nombre",0,100));
		this.addColumn(crearColumna("Bodega",1,100));
		this.addColumn(crearColumna("Tipo Vino",2,100));
		this.addColumn(crearColumna("Anyo",3,200));
		this.addColumn(crearColumna("Precio",4,5));
		this.addColumn(crearColumna("",5,5));
	}

	private TableColumn crearColumna(String texto, int indice, int ancho) {
		TableColumn columna = new TableColumn(indice,ancho);

		columna.setHeaderValue(texto);
		columna.setPreferredWidth(ancho);
		columna.setCellRenderer(trazador);
		
		return columna;
	}

}

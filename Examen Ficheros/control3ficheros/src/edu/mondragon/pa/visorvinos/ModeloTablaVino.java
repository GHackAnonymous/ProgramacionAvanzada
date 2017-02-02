package edu.mondragon.pa.visorvinos;

import java.util.List;
import java.util.stream.Collectors;

import javax.swing.table.AbstractTableModel;

public class ModeloTablaVino extends AbstractTableModel {
	
	ModeloColumnasTablaVino columnas;
	
	List<Vino> listaVino;
	List<Vino> vinosFiltrados;
	
	public ModeloTablaVino(ModeloColumnasTablaVino columnas, List<Vino> lista){
		super();
		this.listaVino = lista;
		
		this.columnas = columnas;
		
	}
	@Override
	public int getColumnCount() {
		
		return columnas.getColumnCount();
	}

	@Override
	public int getRowCount() {
		
		return listaVino.size();
	}

	@Override
	public Object getValueAt(int fila, int columna) {
		Vino vino = listaVino.get(fila);
		return vino.getFieldAt(columna);
		
	}
		
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex == 3) return true;
		return false;
	}
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		
		return getValueAt(0,columnIndex).getClass();
	}
	public void filtrarPorBodega(String bodega) {
		if(vinosFiltrados != null){
			vinosFiltrados.clear();
		}
		vinosFiltrados = listaVino.stream()
				.filter(v->v.getBodega().equalsIgnoreCase(bodega))
				.collect(Collectors.toList());	
		this.fireTableDataChanged();
	}

	public void todosLosVinos() {
		if(vinosFiltrados != null){
			vinosFiltrados.clear();
		}
		for(Vino vino : listaVino) {
			vinosFiltrados.add(vino);
		}
		this.fireTableDataChanged();
	}

	public void filtrarPorTipo(String tipo) {
		if(vinosFiltrados != null){
			vinosFiltrados.clear();
		}
		vinosFiltrados = listaVino.stream()
				.filter(v -> v.getTipo() == tipo)
				.collect(Collectors.toList());	
		this.fireTableDataChanged();
		
	}

	public void filtrarPorAnio(int anio) {
		vinosFiltrados.clear();
		vinosFiltrados = listaVino.stream()
				.filter(v -> v.getAnio() == anio)
				.collect(Collectors.toList());	
		this.fireTableDataChanged();
	}
}

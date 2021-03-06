package edu.mondragon.pa.visorvinos;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TrazadorTablaVino extends DefaultTableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object valor,
			boolean isSelected, boolean hasFocus, int fila, int columna) {
		
		super.getTableCellRendererComponent(table, valor, isSelected, hasFocus, fila, columna);
		switch (columna ){
		case 0: 
		case 1:
		case 2: this.setHorizontalAlignment(LEFT);break;
		case 3: this.setHorizontalAlignment(CENTER);break;
		case 4: this.setHorizontalAlignment(RIGHT);break;
		case 5: return new JLabel("",new ImageIcon(((Boolean)valor)?"icons/estrella.png":"icons/star.png"),CENTER);
		}
		
		
		return this;
	}

}

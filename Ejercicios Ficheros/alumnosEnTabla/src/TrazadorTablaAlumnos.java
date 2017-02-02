import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TrazadorTablaAlumnos extends DefaultTableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object valor,
			boolean isSelected, boolean hasFocus, int fila, int columna) {
		
		super.getTableCellRendererComponent(table, valor, isSelected, hasFocus, fila, columna);
		switch (columna ){
		case 0: 
		case 1:
		case 2: 
			this.setHorizontalAlignment(LEFT);
			break;
		case 3: 
			this.setHorizontalAlignment(CENTER);
			break;
		case 4: 
			this.setHorizontalAlignment(RIGHT);
			break;
		case 5: 
			JLabel nota = new JLabel(""+(Double)valor, CENTER); 
			nota.setForeground((Double)valor < 5 ? Color.RED : Color.BLACK);
			return nota;
		}
		
		return this;
	}
}

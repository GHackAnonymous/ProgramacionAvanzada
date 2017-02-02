package listaAlumnosGrados;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class AdaptadorAlumnos extends JLabel implements ListCellRenderer<Alumno> {

	@Override
	public Component getListCellRendererComponent(JList<? extends Alumno> list,
	         Alumno a,int index,boolean isSelected,boolean cellHasFocus){
			 if (a.tieneTodosAprobados()){
				 setFont( new Font("Arial",Font.BOLD,16));
				 setForeground(Color.black);
				 setBackground((isSelected)?Color.GREEN:Color.WHITE);
			 }else{
				 setFont( new Font("Arial",Font.ITALIC,16));
				 setForeground(Color.RED);
				 setBackground((isSelected)?Color.GREEN:Color.WHITE);
			 }
			 this.setText(a.toString());
			 setOpaque(true);
	         return this;
	}
}

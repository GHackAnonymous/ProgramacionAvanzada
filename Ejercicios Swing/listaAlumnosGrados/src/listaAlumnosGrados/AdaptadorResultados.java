package listaAlumnosGrados;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class AdaptadorResultados extends JLabel implements ListCellRenderer<ResultadoAprendizaje> {

	@Override
	public Component getListCellRendererComponent(JList<? extends ResultadoAprendizaje> list,
	         ResultadoAprendizaje r,int index,boolean isSelected,boolean cellHasFocus){
		
			 if (r.getNota()>=5.0f){
				 setFont( new Font("Arial",Font.BOLD,16));
				 setForeground(Color.black);
			 }else{
				 setFont( new Font("Arial",Font.ITALIC,16));
				 setForeground(Color.RED);
			 }
			 this.setText(r.toString());
			 setOpaque(true);
	         return this;
	}
}
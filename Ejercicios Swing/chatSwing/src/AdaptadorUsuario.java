import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;

public class AdaptadorUsuario implements ListCellRenderer<Texto> {
	Usuario usuario;
	public AdaptadorUsuario (Usuario usuario){
		this.usuario = usuario;
	}
	@Override
	public Component getListCellRendererComponent(JList<? extends Texto> lista, Texto texto, 
			int indice, boolean seleccionado,boolean focus) {
		JLabel label = new JLabel ();
		label.setPreferredSize(new Dimension (50,25));
		if (texto.getUsuario()==usuario){
			label.setForeground(Color.blue);
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			
			label.setText(texto.getTexto());
		}else{
			label.setForeground(Color.ORANGE);
			label.setHorizontalTextPosition(SwingConstants.LEFT);
			
			label.setText(texto.getUsuario().getNombre()+": "+texto.getTexto());
		}
		return label;
	}
	

}

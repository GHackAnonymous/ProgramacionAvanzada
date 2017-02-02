
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Controlador implements ActionListener{
	Vista vista;
	Modelo modelo;
	
	public Controlador(Vista vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
	}
	private void salir(){
		System.exit(0);
	}
	private void reset() {
		this.vista.UserTextBox.setText("");
		this.vista.passTextBox.setText("");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
			case "ok":
				char[] arrayC = vista.passTextBox.getPassword(); 
				String pass = new String(arrayC); 

				if(vista.UserTextBox.getText().equalsIgnoreCase(modelo.getUSUARIO())
						&& pass.equalsIgnoreCase(modelo.getPASSWD())){
					JOptionPane.showMessageDialog(null, "Identificacion Corrcto");
					salir();
				}else{
					JOptionPane.showMessageDialog(null, "Identificacion Erronea", "Error!",
							JOptionPane.ERROR_MESSAGE);
					reset();
				}
				break;
			case "cancelar":
				reset();
				break;
			case "salir":
				salir();
				break;
			
		}
		
	}
}


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Controlador implements ActionListener{
	Vista vista;
	Modelo2 modelo;
	double result;
	
	public Controlador(Vista vista, Modelo2 modelo) {
		this.vista = vista;
		this.modelo = modelo;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		int valorPuntos = 0;
		if(!e.getActionCommand().equalsIgnoreCase("Salir")){
			int valorBoton = Integer.parseInt(e.getActionCommand());
			
			if(valorBoton != 0){
				valorPuntos = Integer.parseInt(vista.getUserPremio());
				valorPuntos += valorBoton;
				
				Object fuente = e.getSource();
				vista.visualizarBoton(fuente, ""+valorBoton+"");
			}else if(valorBoton == 0){
				JOptionPane.showMessageDialog(null, "Game Over", "Game Over!",
						JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
		}else{
			System.exit(0);
		}
		vista.setUserPremio(valorPuntos);
	}
	public int damePrimo() {
		return modelo.damePrimo();
	}	
}

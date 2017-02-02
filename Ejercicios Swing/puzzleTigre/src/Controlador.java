
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Controlador implements ActionListener{
	Vista vista;
	Modelo modelo;
	double result;
	JButton botonAMover;
	JButton botontigre12;
	
	public Controlador(Vista vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		//JButton fuente = (JButton) e.getSource();
		
		
		if(!e.getActionCommand().equalsIgnoreCase("tigre12")){
			modelo.saverPosicion(e.getActionCommand());
			botonAMover = (JButton) e.getSource();
		}else{
			boolean valida = modelo.validarMovimientoPuzzle();	
			botontigre12 = (JButton) e.getSource();
			if(valida == true){
				vista.moverBoton(botonAMover, botontigre12);
			}
			
			modelo.verTablero();
			//modelo
			if(modelo.comprobarTablero()){
				JOptionPane.showMessageDialog(null, "Ganador", "Ganador",
					JOptionPane.WARNING_MESSAGE);
				System.exit(0);
			}
		}
	}
	public String dameimagen() {
		return modelo.dameimagen();
	}	
}

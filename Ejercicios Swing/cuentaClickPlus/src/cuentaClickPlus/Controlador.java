package cuentaClickPlus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener{
	Vista vista;
	Modelo modelo;
	
	public Controlador(Vista vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
			case "1":
				modelo.setNumAument(1);
				break;
			case "3":
				modelo.setNumAument(3);
				break;
			case "5":
				modelo.setNumAument(5);
				break;
			case "Incrementar":
				modelo.incrementar();
				break;
			case "Decrementar":
				modelo.decrementar();
				break;
			case "Salir":
				System.exit(0);
				break;
		}
	}
}

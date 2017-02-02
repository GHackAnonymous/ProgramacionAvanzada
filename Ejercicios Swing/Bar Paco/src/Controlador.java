
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener{
	Vista vista;
	Modelo modelo;
	int result = 0;
	
	public Controlador(Vista vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
	}
	private void reset() {
		this.vista.getLabelCalculo().setText("0");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(!this.vista.getLabelCalculo().getText().equalsIgnoreCase("0")){
			reset();
		}
		
		switch(e.getActionCommand()){
			case "Cerveza":
				result += Integer.parseInt(this.vista.getLabelCalculo().getText()) + modelo.getCERVEZA();
				break;
			case "Pintxo":
				result += Integer.parseInt(this.vista.getLabelCalculo().getText()) + modelo.getPINTXO();
				break;
			case "Vino":
				result += Integer.parseInt(this.vista.getLabelCalculo().getText()) + modelo.getVINO();
				break;
			case "Total":
				valorTexto(result);
				result = 0;
				break;
		}
		
	}
	public void valorTexto(int result){
		this.vista.getLabelCalculo().setText(""+result+"");
	}
}

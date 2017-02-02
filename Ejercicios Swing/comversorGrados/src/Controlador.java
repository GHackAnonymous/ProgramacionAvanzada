
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener{
	Vista vista;
	Modelo modelo;
	double result;
	
	public Controlador(Vista vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("Comversion")){
			if(vista.getRadioBotonSelect().equalsIgnoreCase("celsius")){
				result = modelo.conversionCelsius(Double.parseDouble(vista.getUserGrados()));
			}else if(vista.getRadioBotonSelect().equalsIgnoreCase("farenheit")){
				result = modelo.conversionFarenheit(Double.parseDouble(vista.getUserGrados()));
			}
		}
		vista.setUserGrados(result);
	}
}

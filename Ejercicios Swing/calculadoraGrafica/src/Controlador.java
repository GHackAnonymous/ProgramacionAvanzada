import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

public class Controlador implements ActionListener{
	Vista vista;
	Modelo modelo;
	private List<Double> valores;
	private List<String> operadores;
	
	public Controlador(Vista vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
		valores = new ArrayList<>();
		operadores = new ArrayList<>();
	}

	@Override
	public void actionPerformed(ActionEvent e){
		switch(e.getActionCommand()){
			case "1":
				valores.add(1.0);
				//vista.valorEnPantalla(1);
				break;
			case "2":
				valores.add(2.0);
				//vista.valorEnPantalla(2);
				break;
			case "3":
				valores.add(3.0);
				//vista.valorEnPantalla(3);
				break;
			case "4":
				valores.add(4.0);
				//vista.valorEnPantalla(4);
				break;
			case "5":
				valores.add(5.0);
				//vista.valorEnPantalla(5);
				break;
			case "6":
				valores.add(6.0);
				//vista.valorEnPantalla(6);
				break;
			case "7":
				valores.add(7.0);
				//vista.valorEnPantalla(7);
				break;
			case "8":
				valores.add(8.0);
				//vista.valorEnPantalla(8);
				break;
			case "9":
				valores.add(9.0);
				//vista.valorEnPantalla(9);
				break;
			case "0":
				valores.add(0.0);
				//vista.valorEnPantalla(0);
				break;
			case "C":
				modelo.reset();
				vista.resetLabel();
				vista.desOHabilitar(true);
				break;
			case "+":
				operadores.add("+");
				break;
			case "-":
				operadores.add("-");
				break;
			case "*":
				operadores.add("*");
				break;
			case "/":
				operadores.add("/");
				break;
			case "=":
				try{
					if(vista.texto.getText().equalsIgnoreCase("") == false){
						modelo.setResultado(Double.parseDouble(vista.texto.getText()));
					}else{
						modelo.setResultado(valores.get(0));
						valores.remove(0);
					}
					for(int i=0; i<=valores.size();i++){
						if(!operadores.isEmpty()){
							modelo.calcular(valores.get(0), operadores.get(0));
							operadores.remove(0);
						}
						valores.remove(0);
					}
					
					vista.valorEnPantalla(modelo.getResultado());
				}catch(ArithmeticException ae){
					vista.texto.setText("No puedo dividir entre 0");
					vista.desOHabilitar(false);
				}
				break;
		}	
	}
}

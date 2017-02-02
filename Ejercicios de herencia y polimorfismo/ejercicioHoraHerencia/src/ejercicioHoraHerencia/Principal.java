package ejercicioHoraHerencia;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Principal {
	Scanner teclado;
	Horas horas;
	String horaFormato = "HH:mm";
	
	private Principal(){
		teclado = new Scanner(System.in);
		horas =new Horas();
	}
	private void pedirHora(){
		String opcion = "";
		do{
			System.out.println("Dame una hora [HH:mm]: ");
			horas.setListaHora(teclado.nextLine());
			System.out.println("Quieres meter mas horas: [S/n] ");
			opcion = teclado.nextLine();
		}while(opcion.equalsIgnoreCase("S"));
	}
	private Hora mostrarHoraMenor(){
		return horas.saberHoraMenor();
	}
	private void programa(){
		pedirHora();
		Hora horaMenor = mostrarHoraMenor();
		DateFormat hourdateFormat = new SimpleDateFormat("HH:mm");
		System.out.println("La hora menor es: "
				+hourdateFormat.format(horaMenor.getHh()));
	}
	public static void main(String[] args) {
		Principal primero = new Principal();
		primero.programa();
	}

}

package ejercicioHoraHerencia;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Principal2 {

	Scanner teclado;
	Horas horas;
	String horaFormato = "HH:mm:ss";
	
	private Principal2(){
		teclado = new Scanner(System.in);
		horas =new Horas();
	}
	private void pedirHora(){
		String opcion = "";
		int tipoHora = -1;
		do{
			System.out.println("1.-[HH:mm] ");
			System.out.println("2.-[HH:mm:ss] ");
			System.out.print("opcion >> ");
			tipoHora = teclado.nextInt();
			teclado.nextLine();
			switch(tipoHora){
				case 1:
					System.out.println("Dame una hora [HH:mm]: ");
					horas.setListaHora(teclado.nextLine());
					break;
				case 2:
					System.out.println("Dame una hora [HH:mm:ss]: ");
					horas.setListaHoraPrecisa(teclado.nextLine());
					break;
			}

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
		DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss");
		System.out.println("La hora menor es: "
				+hourdateFormat.format(horaMenor.getHh()));
	}
	public static void main(String[] args) {
		Principal2 primero = new Principal2();
		primero.programa();
	}

}

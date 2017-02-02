package ejerciciosZodiaco;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Principal {
	private Scanner teclado;
	private Date miFecha;
	private Zodiaco signoZodiaco;
	
	private Principal(){
		teclado = new Scanner(System.in);
	}
	private void pedirFecha(){
		System.out.print("Intoduceme una fecha (MM-dd): ");
		try {
			miFecha = new SimpleDateFormat("MM-dd").parse(teclado.nextLine());
			signoZodiaco = new Zodiaco(miFecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	private void Programa(){
		pedirFecha();
		String signo = signoZodiaco.saberSignoZodiaco();
		System.out.println("Tu signo es: "+signo);
	}
	public static void main(String[] args) {
		Principal primero = new Principal();
		primero.Programa();

	}

}

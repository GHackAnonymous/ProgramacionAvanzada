package ejercicioVidente;

import java.util.Random;
import java.util.Scanner;

public class Principal {

	Scanner teclado;
	Random rd;
	Respuestas responder;
	
	private Principal(){
		teclado = new Scanner(System.in);
		rd = new Random();
		responder = new Respuestas();
	}
	private void programa(){
		String opcion = "";
		do{
			System.out.print("Preguntame algo?? ");
			teclado.nextLine();
			String respuesta = responder.obtenerRespuestas(rd.nextInt(10));
			System.out.println(respuesta);
			System.out.print("Quieres preguntar algo mas (S/n): ");
			opcion = teclado.nextLine();
		}while(!opcion.equalsIgnoreCase("n"));
	}
	public static void main(String[] args) {
		Principal primero = new Principal();
		primero.programa();
	}

}

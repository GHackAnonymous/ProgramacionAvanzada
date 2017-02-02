package horasClases;

import java.util.Scanner;

public class Principal {

	public Principal(){}
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Reloj reloj = new Reloj();
		do{
			System.out.print("Introduceme una hora en "
					+ "horas. Ejemplo(12): ");
			reloj.setH1(teclado.nextInt());
		}while(reloj.getH1() < 0 || reloj.getH1() > 24);
		
		do{
			System.out.print("Introduceme otra hora: ");
			reloj.setH2(teclado.nextInt());
		}while(reloj.getH2() < 0 || reloj.getH2() > 24);
		
		System.out.println("Los minutos son: "+reloj.minutos());

	}

}

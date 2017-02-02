package bonolotoClases;

import java.util.Scanner;

public class Principal {
	
	Scanner teclado;
	Bonoloto bonoloto;
	final int NUMNUMBOLETOS = 6;
	
	private Principal(){
		teclado = new Scanner(System.in);
	}
	public void programa(){
		System.out.print("Intoduce Cuantos boletes has comprado: ");
		int cantidadBoletos = teclado.nextInt();
		teclado.nextLine();
		bonoloto = new Bonoloto(cantidadBoletos);
		
		Boleto[] boletos = new Boleto[cantidadBoletos]; 
		int[] boleto = new int [NUMNUMBOLETOS];
		for(int i = 0; i < cantidadBoletos; i++){
			Boleto b = new Boleto();
			System.out.print("Indrocuce el numero del boleto "
					+ "(6 numero separados por espacion): ");
			for(int x = 0; i < NUMNUMBOLETOS; x++){
				boleto[x] = teclado.nextInt();
			}
			b.setBoleto(boleto);
			boletos[i] = b;
			teclado.nextLine();
		}
		bonoloto.setBoletos(boletos);
	
		System.out.print("Indrocuce el numero del boleto ganador "
				+ "(6 numero separados por espacion): ");
		for(int i = 0; i < NUMNUMBOLETOS; i++){
			boleto[i] = teclado.nextInt();
		}
		
		bonoloto.setBoletoGanador(new Boleto(boleto));
		
		for(int i = 0; i < cantidadBoletos; i++){
			int numerosPremiados[] = bonoloto.comprobar(i);
			System.out.println("Acietos del Boleto: "+i);
			for(int copia : numerosPremiados){
				if(copia != -1){
					System.out.print(copia+" ");
				}
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Principal principal = new Principal();
		principal.programa();
	}
}

package buscaminasHerenciaSin;

import java.util.Scanner;

public class Principal {
	Tablero tablero;
	Scanner teclado;
	private Principal(){
		tablero = new Tablero();
		teclado = new Scanner(System.in);
	}
	private boolean menu(){
		boolean sigeJuego = true;
		//tablero.monstarTablero();
		System.out.print("Introduce casilla (x y) (m/n): ");
		int horizontal = teclado.nextInt();
		int vertical = teclado.nextInt();
		String siMina = teclado.next();
		teclado.nextLine();
		
		boolean mina = tablero.comprobarSiTieneMina(horizontal, vertical);
		
		if(siMina.equalsIgnoreCase("m")){
			if(mina == true){
				System.out.println("Mina desactivada");
				int numMinasQuedan = tablero.neutralizarMina(horizontal, vertical);
				if(numMinasQuedan == 0){
					System.out.println("HAS GANADO!!!");
					sigeJuego = false;
				}
			}
		}else{
			if(mina == true){
				System.out.println("Explota la Mina");
				System.out.println("GameOver");
				sigeJuego = false;
			}else{
				System.out.println("Minas cercanas: "
						+tablero.comprobarMinaCercanas(horizontal, vertical));
			}
		}
		return sigeJuego;
	}
	private void programa(){
		tablero.InicializarTableroA0();
		tablero.InicializarMinas();
		String continuar = "";
		boolean sigeJuego = true;
		do{
			sigeJuego = menu();
			if(sigeJuego == true){
				System.out.print("Continuar (s/n): ");
				continuar = teclado.nextLine();
			}
		}while(continuar.equalsIgnoreCase("s") && sigeJuego == true);
		
	}
	public static void main(String[] args) {
		Principal primero = new Principal();
		primero.programa();
	}

}

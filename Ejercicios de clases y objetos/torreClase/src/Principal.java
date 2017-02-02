import java.util.Scanner;

public class Principal {
	
	public Principal(){}
	
	public static void main(String[] args) {
		final int MAXCASILLASTABLERO = 8;
		Scanner teclado = new Scanner(System.in);
		Tablero tablero = new Tablero();
		Torre torre = new Torre();
		String opcion = "";
		int opcionMenu = 0;
		int numCasillas = 0;
		
		do{
			System.out.println("En que direcion te quieres mover.");
			System.out.println("Pulsa 1 si te quieres mover de arriba a abajo.");
			System.out.println("Pulsa 2 si te quieres mover de abajo a arriba.");
			System.out.println("Pulsa 3 si te quieres mover de izquierda a derecha.");
			System.out.println("Pulsa 4 si te quieres mover de derecha a izquierda.");
			System.out.print("Opcion =>");
			opcionMenu = teclado.nextInt();
			
			System.out.print("Cuantas casillas te quieres mover: ");
			numCasillas = teclado.nextInt();
			
			
			boolean validez = torre.movimientoValido(opcionMenu, numCasillas, tablero.cordenadasActuales());
			
			if(validez == true){
				tablero.mover(opcionMenu, numCasillas);
				int copia[][] = tablero.mostar();
				
				for (int i1= 0; i1 < MAXCASILLASTABLERO; i1++){
					for(int i2 = 0; i2 < MAXCASILLASTABLERO; i2++){
						System.out.print(copia[i1][i2]+" ");
					}
					System.out.println();
				}
				
			}else{
				System.err.println("Movimiento no valido");
			}
			teclado.nextLine();
			System.out.print("Quieres mover la torre (S/N): ");
			opcion = teclado.nextLine();
		}while(opcion.equalsIgnoreCase("s"));
		
	}

}

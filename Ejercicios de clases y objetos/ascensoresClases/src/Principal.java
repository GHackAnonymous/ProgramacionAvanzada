import java.util.Scanner;

public class Principal {
	Scanner teclado;
	Ascensor[] ascensor;
	int totalPisos = 4;
	private final int NUMASCENSORES = 3;
	
	/**
	 * 1.- No honer numeros nunca tipo ascensor[0]
	 * 2.- separar en mas funciones para que sea mas corto 
	 * 3.- algoritmo de control ascensores mas eficiente en menos lineas
	 * 
	 * */
	
	private Principal(){
		teclado = new Scanner(System.in);
		ascensor = new Ascensor [NUMASCENSORES];
		for(int i = 0; i<NUMASCENSORES; i++){
			ascensor[i] = new Ascensor(i);
		}
	}
	private int menu(){
		System.out.println("1.-Mover un Ascensor");
		System.out.println("2.-Llamar desde piso");
		System.out.println("0.-Salir");
		System.out.print("opcion =>");
		int opcion = teclado.nextInt();
		teclado.nextLine();
		return opcion;
	}
	private int queAscensor(){
		int queAscensor;
		do{
			System.out.print("Que Ascensor (0 al 2): ");
			queAscensor = teclado.nextInt();
			teclado.nextLine();
		}while(queAscensor < 0 || queAscensor > 3);
		return queAscensor;
	}
	private int aQuePiso(){
		int quePiso;
		do{
			System.out.print("A que piso quieres ir (0 al 3): ");
			quePiso = teclado.nextInt();
			teclado.nextLine();
		}while(quePiso < 0 || quePiso > 3);
		return quePiso;
	}
	private void puertas(int queAscensorSeleciono){
		boolean pueraAbierta = ascensor[queAscensorSeleciono].conprobarPuerta();
		if(pueraAbierta == true){
			System.out.println("Se cierra la pueta");
		}
	}
	private void mover(int queAscensorSeleciono, int quePisoSeleciono){
		boolean ascensorMoviendose = ascensor[queAscensorSeleciono].moverAscesor(quePisoSeleciono);
		if(ascensorMoviendose == true){
			System.out.println("Ascensor "+queAscensorSeleciono+" al piso "+quePisoSeleciono);
			System.out.println("Se habre la puerta");
		}
	}
	private int desdeQuePiso(){
		int desdeQuePiso;
		do{
			System.out.print("Desde que peso (0 al 3): ");
			desdeQuePiso = teclado.nextInt();
			teclado.nextLine();
		}while(desdeQuePiso < 0 || desdeQuePiso > 3);
		return desdeQuePiso;
	}
	private int[] ascensorMasCercano(int desdeQuePisoLlama){
		int cercanos[] = new int[desdeQuePisoLlama];
		for(int i = 0; i < NUMASCENSORES; i++){
			cercanos[i] = Math.abs(ascensor[i].getPiso() - desdeQuePisoLlama);
		}
		return cercanos;
	}
	private void cualEsMasCercanoYMover(int[] cercanos,int desdeQuePisoLlamo){
		int iNumeroMenor, iPosicion;
		iNumeroMenor = cercanos[0];
		iPosicion = 0;
		for(int i = 0; i < NUMASCENSORES; i++){
			if (cercanos[i]<iNumeroMenor){
				iNumeroMenor = cercanos[i];
				iPosicion = i;
			} 
		}
		mover(iPosicion,desdeQuePisoLlamo);
	}
	private void opcionMenu(int opcion){
		switch(opcion){
		case 1:
			
			int queAscensorSeleciono = queAscensor();
			int quePisoSeleciono = aQuePiso();
			puertas(queAscensorSeleciono);
			mover(queAscensorSeleciono, quePisoSeleciono);
			break;
		case 2:
			int desdeQuePisoLlamo = desdeQuePiso();
			int cercanos[] = ascensorMasCercano(desdeQuePisoLlamo);
			cualEsMasCercanoYMover(cercanos,desdeQuePisoLlamo);
			
			break;
		case 0:
			System.out.println("Se Sale del programa.");
			break;
		default:
			System.err.println("Opcion no valida");
			break;
	}
	}
	private void programa(){
		int opcion = -1;
		do{
			opcion = menu();
			opcionMenu(opcion);
			System.out.println();
		}while(opcion != 0);
	}
	public static void main(String[] args) {
		Principal principal = new Principal();
		principal.programa();
	}
}

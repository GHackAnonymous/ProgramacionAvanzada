import java.util.List;
import java.util.Scanner;

public class Principal {
	ColeccionFiguras coleccion;
	Scanner teclado;
	int puntoX;
	int puntoY;
	
	private Principal(){
		coleccion = new ColeccionFiguras();
		teclado = new Scanner(System.in);
	}
	private int menu(){
		
		//canbiar de aqui para abajo
		
		System.out.println("1.- Crear Figura");
		System.out.println("2.- Ver figura ordenadas por area"); 
		System.out.println("3.- Ver figura ordenadas por posocion");
		System.out.println("0.- salir");
		System.out.print("opcion >> ");
		int opcion = teclado.nextInt();
		teclado.nextLine();
		return opcion; 
	}
	private void opcionMenu(int opcion) {
		switch(opcion){
			case 1: 
				 puntos();
				 String figura = queFigura();
				 crearfiguras(figura);
				break;
			case 2:
				coleccion.listaOrdenadoArea();
				List<Figura> copy1 = coleccion.mostarfiguras();
				mostrarLista(copy1);
				break;
			case 3:
				coleccion.listaOrdenadoCordenadas();
				List<Figura> copy2 = coleccion.mostarfiguras();
				mostrarLista(copy2);
				break;
			case 0:
				System.out.println("Saliendo....");
				break;
			default:
				opcionNoValidad();
		}
	}
	private void mostrarLista(List<Figura> lista){
		for(Figura f : lista){
			System.out.println(f+" \nArea: "+f.area());
		}
	}
	private void puntos(){
		System.out.print("Punto (x,y): ");
		puntoX = teclado.nextInt();
		puntoY = teclado.nextInt();
		teclado.nextLine();
	}
	private String queFigura(){
		System.out.print("c- cuadradado/r- rectangulo/t- triangulo/o- circulo: ");
		return teclado.nextLine();
	}
	private void crearfiguras(String tipoFigura){
		switch(tipoFigura){
			case "c":
				System.out.print("Lado: ");
				int lado = teclado.nextInt();
				teclado.nextLine();
				coleccion.addCuadrado(puntoX, puntoY, "Cuadrado", lado);
				break;
			case "r":
				System.out.print("Lado 1: ");
				int lado1 = teclado.nextInt();
				teclado.nextLine();
				System.out.print("Lado 2: ");
				int lado2 = teclado.nextInt();
				teclado.nextLine();
				coleccion.addRectangilo(puntoX, puntoY, "Rectangulo", lado1, lado2);
				break;
			case "t":
				System.out.print("Base: ");
				int base = teclado.nextInt();
				teclado.nextLine();
				System.out.print("Altura: ");
				int altura = teclado.nextInt();
				teclado.nextLine();
				coleccion.addTriangulo(puntoX, puntoY, "Triangulo", base, altura);
				break;
			case "o":
				System.out.print("Radio: ");
				int radio = teclado.nextInt();
				teclado.nextLine();
				coleccion.addCirculo(puntoX, puntoY, "Circulo", radio);
				break;
			default:
				opcionNoValidad();
		}
	}
	private void opcionNoValidad(){
		System.err.println("Opion no valida\n");
	}
	private void programa(){
		int opcion = -1;
		do{
			opcion = menu();
			opcionMenu(opcion);
		}while(opcion != 0);
	}
	public static void main(String[] args) {
		Principal primero = new Principal();
		primero.programa();
	}
}

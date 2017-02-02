package ejerciciosBanco;

import java.util.Random;
import java.util.Scanner;

public class Principal {
	
	private final int CANTIDADNUMEROSCUENTA = 20;
	private final int CANTIDADCUENTAS = 4; // EN UN FUTURO SE LE PIDE AL USER
	private Random rd;
	private int[] numCuenta;
	Scanner teclado;
	Cuentas listaCuentas;
	
	
	private Principal(){
		numCuenta = new int[CANTIDADNUMEROSCUENTA];
		rd = new Random();
		teclado = new Scanner(System.in);
		listaCuentas = new Cuentas();
	}
	private void crearCuenta(){
		for(int i = 0; i < CANTIDADNUMEROSCUENTA; i++){
			numCuenta[i] = rd.nextInt(10);
		}
		System.out.print("Nombre titular: ");
		String titular = teclado.nextLine();
		int cantidad = cantidadOperacion();
		listaCuentas.meterCuenta(titular, numCuenta, cantidad);
	}
	private int verEstadoTodo(){
		Cuenta[] copy = listaCuentas.getCuentas();
		int numCuenta = 0;
		for (Cuenta cuenta: copy){
			System.out.println("Cuenta "+numCuenta+" \n"+
								cuenta.toString());
			numCuenta++;
		}
		return numCuenta;
	}
	private int menu(){
		System.out.println("1.- Crear una cuenta");
		System.out.println("2.- Ver el estado de todas las cuentas"); // override to string en cuentas con un for
		System.out.println("3.- Realizar Operacion en cuenta");
		System.out.println("0.- salir");
		System.out.print("opcion >> ");
		
		return (teclado.nextInt()); //puede fallar ?? por teclado.nextLine();
	}
	private void opcionMenu(int opcion){
		switch(opcion){
		case 1:
			crearCuenta();
			break;
		case 2:
			verEstadoTodo();
			break;
		case 3:
			int opcion2 = -1;
			int selectCuenta = 0;

			selectCuenta = selecionarCuenta();
			opcion2 = menu2();
			teclado.nextLine();
			opcionMenu2(opcion2,selectCuenta );
			break;
		case 0: break;
		default:
			opcionNoValidad();
		}
	}
	private int selecionarCuenta(){
		int numcuentas = verEstadoTodo();
		int cuentaSelect = 0;
		do{
		System.out.print("que cuenta: ");
		cuentaSelect = teclado.nextInt();
		teclado.nextLine();
		}while(cuentaSelect > numcuentas || cuentaSelect < 0);
		return cuentaSelect;
	}
	private int menu2(){
		System.out.println("1.- Ingresar una cantidad"); // override to string en cuentas con un for
		System.out.println("2.- Sacar una cantidad"); // override to string en cuentas con un for
		System.out.println("3.- Ver saldo");
		System.out.println("4.- Tranferir una cantidad a otra cuenta");
		System.out.println("0.- salir");
		System.out.print("opcion >> ");
		
		return (teclado.nextInt()); //puede fallar ?? por teclado.nextLine();
	}
	private int cantidadOperacion(){
		System.out.print("cantidad: ");
		int cantidad = teclado.nextInt();
		teclado.nextLine();
		return cantidad;
	}
	private void opcionMenu2(int opcion,int selectCuenta){
		int cantidad;
		switch(opcion){
			case 1:
			    cantidad = cantidadOperacion();
				System.out.println("Saldo introducido: "+
			    listaCuentas.ingresarSaldo(selectCuenta, cantidad));
				break;
			case 2:
				cantidad = cantidadOperacion();
				System.out.println("Saldo sacado: "+
				listaCuentas.sacarSaldo(selectCuenta, cantidad));
				break;
			case 3:
				System.out.println(listaCuentas.VerSaldo(selectCuenta));
				break;
			case 4:
				System.out.println("Selecion a que cuenta");
				int selectCuenta2 = selecionarCuenta();
				cantidad = cantidadOperacion();
				listaCuentas.tranferencia(selectCuenta, selectCuenta2, cantidad);
				break;
			case 0:break;
			default:
				opcionNoValidad();
		}
	}
	private void opcionNoValidad(){
		System.err.println("Opion no valida\n");
	}
	private void Programa(){
		int opcion = -1;
			
		do{
			opcion = menu();
			teclado.nextLine();
			opcionMenu(opcion);
		}while(opcion != 0);
		
	}
	public static void main(String[] args) {
		Principal primero = new Principal();
		primero.Programa();
	}
	
}

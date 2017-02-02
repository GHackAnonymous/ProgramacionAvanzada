package ejercicioEmpresaAgroalimentaria;

import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Principal {

	Scanner teclado;
	Almacen almacen;
	
	private Principal(){
		teclado = new Scanner(System.in);
		almacen = new Almacen();
	}
	private int menu(){
		System.out.println("1.- Crear un Producto ");
		System.out.println("2.- Listar Productos");
		System.out.println("0.- Salir");
		System.out.print("opcion >> ");
		int opcion = teclado.nextInt();
		teclado.nextLine();
		return opcion;
	}
	private void opcionMenu(int opcion){
		switch(opcion){
		case 1:
			int opcion2 = menu2();
			opcionMenu2(opcion2);
			break;
		case 2:
			listarProductos();
			break;
		case 0:
			System.out.println("Saliendo....");
			break;
		default:
			opcionNoValida();
		}
	}
	private int menu2(){
		System.out.println("1.- Producto fresco ");
		System.out.println("2.- Producto refrigerado");
		System.out.println("3.- Producto confelado por aire");
		System.out.println("4.- Producto confelado por agua");
		System.out.println("5.- Producto confelado por nitrogeno");
		System.out.print("opcion >> ");
		int opcion2 = teclado.nextInt();
		teclado.nextLine();
		return opcion2;
	}
	private void opcionMenu2(int opcion2){
		switch(opcion2){
		case 1:
			pedirProFresco();
			break;
		case 2:
			pedirProRefrigerado();
			break;
		case 3:
			pedirProCongeladoPorAire();
			break;
		case 4:
			pedirProCongeladoPorAgua();
			break;
		case 5:
			pedirProCongeladoPorNitrogeno();
			break;
		default:
			opcionNoValida();
		}
	}
	private String pedirNombre(){
		System.out.print("Nombre: ");
		String nombre = teclado.nextLine();
		return nombre;
	}
	private Date pedirFecha(){
		Date fecha = null;
		try {
			fecha = new SimpleDateFormat("yyyy-MM-dd").parse(teclado.nextLine());
		} catch (ParseException e) {e.printStackTrace();}
		return fecha;
	}
	private int pedirNumLote(){
		System.out.print("Numero de lote: ");
		return teclado.nextInt();
	}
	private String pedirPais(){
		String pais = teclado.nextLine();
		return pais;
	}
	private int pedirTemperatura(){
		System.out.println("Temperatura: ");
		int temperatura = teclado.nextInt();
		teclado.nextLine();
		return temperatura;
	}
	private boolean fechaValidacion(Date fechacaducidad, Date fechaEnvasado){
		if(fechaEnvasado.before(fechacaducidad)){
			return true;
		}
		return false;
	}
	private void pedirProFresco(){
		String nombre = pedirNombre();
		System.out.print("Fecha Caducidad [yyyy-MM-dd]: ");
		Date fechaCaducidad = pedirFecha();
		int numLote = pedirNumLote();
		teclado.nextLine();
		Date fechaEnvasado = null;
		boolean valido = false;
		do{
			fechaEnvasado = null;
			System.out.print("Fecha de envasado [yyyy-MM-dd]: ");
			fechaEnvasado = pedirFecha();
			valido = fechaValidacion(fechaCaducidad, fechaEnvasado);
		}while(valido == false);
		System.out.println("Pais de origen: ");
		String paisOrigen = pedirPais();
		almacen.addProductoFresco(nombre, fechaCaducidad, numLote,
				fechaEnvasado, paisOrigen);
	}
	private void pedirProRefrigerado(){
		String nombre = pedirNombre();
		System.out.print("Fecha Caducidad [yyyy-MM-dd]: ");
		Date fechaCaducidad = pedirFecha();
		int numLote = pedirNumLote();
		teclado.nextLine();
		System.out.println("Codigo organico: ");
		int codigoOrganico = teclado.nextInt();
		teclado.nextLine();
		Date fechaEnvasado = null;
		boolean valido = false;
		do{
			System.out.print("Fecha Envasado [yyyy-MM-dd]: ");
			fechaEnvasado = pedirFecha();
			valido = fechaValidacion(fechaCaducidad, fechaEnvasado);
		}while(valido == false);
		int temperatura = pedirTemperatura();
		System.out.println("Pais de origen: ");
		String paisOrigen = pedirPais();
		almacen.addProductoRefrigerado(nombre, fechaCaducidad, numLote,
				codigoOrganico, fechaEnvasado, temperatura, paisOrigen);
	}
	private void pedirProCongeladoPorAire(){
		String nombre = pedirNombre();
		System.out.print("Fecha Caducidad [yyyy-MM-dd]: ");
		Date fechaCaducidad = pedirFecha();
		int numLote = pedirNumLote();
		teclado.nextLine();
		Date fechaEnvasado = null;
		boolean valido = false;
		do{
			System.out.print("Fecha Envasado [yyyy-MM-dd]: ");
			fechaEnvasado = pedirFecha();
			valido = fechaValidacion(fechaCaducidad, fechaEnvasado);
		}while(valido == false);
		System.out.println("Pais de origen: ");
		String paisOrigen = pedirPais();
		int temperatura = pedirTemperatura();
		System.out.println("Porcentage de nitrogeno: ");
		int porNitrogeno = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Porcentage de Oxigeno: ");
		int porOxigeno = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Porcentage de dioxide de carbono: ");
		int porDioxideCarbono = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Porcentage de vapor de agua: ");
		int porVaporAgua = teclado.nextInt();
		teclado.nextLine();
		almacen.addProductoCongeladoAire(nombre, fechaCaducidad, numLote,
				fechaEnvasado, paisOrigen, temperatura, porNitrogeno,
				porOxigeno, porDioxideCarbono, porVaporAgua);
	}
	private void pedirProCongeladoPorAgua(){
		String nombre = pedirNombre();
		System.out.print("Fecha Caducidad [yyyy-MM-dd]: ");
		Date fechaCaducidad = pedirFecha();
		int numLote = pedirNumLote();
		teclado.nextLine();
		Date fechaEnvasado = null;
		boolean valido = false;
		do{
			System.out.print("Fecha Envasado [yyyy-MM-dd]: ");
			fechaEnvasado = pedirFecha();
			valido = fechaValidacion(fechaCaducidad, fechaEnvasado);
		}while(valido == false);
		System.out.println("Pais de origen: ");
		String paisOrigen = pedirPais();
		int temperatura = pedirTemperatura();
		System.out.println("Salinidad del agua: ");
		int salinidad = teclado.nextInt();
		teclado.nextLine();
		almacen.addProductoCongeladoAgua(nombre, fechaCaducidad, numLote,
				fechaEnvasado, paisOrigen, temperatura, salinidad);
	}
	private void pedirProCongeladoPorNitrogeno(){
		String nombre = pedirNombre();
		System.out.print("Fecha Caducidad [yyyy-MM-dd]: ");
		Date fechaCaducidad = pedirFecha();
		int numLote = pedirNumLote();
		teclado.nextLine();
		Date fechaEnvasado = null;
		boolean valido = false;
		do{
			System.out.print("Fecha Envasado [yyyy-MM-dd]: ");
			fechaEnvasado = pedirFecha();
			valido = fechaValidacion(fechaCaducidad, fechaEnvasado);
		}while(valido == false);
		System.out.println("Pais de origen: ");
		String paisOrigen = pedirPais();
		int temperatura = pedirTemperatura();
		System.out.println("Metodo de congelacion con nitrogeno: ");
		String metodo = teclado.nextLine();
		System.out.println("Tiempo expuesto [HH:mm:ss] : ");
		Date tiempo = null;
		try {
			tiempo = new SimpleDateFormat("HH:mm:ss").parse(teclado.nextLine());
		} catch (ParseException e) {e.printStackTrace();}
		almacen.addProductoCongeladoNitrogeno(nombre, fechaCaducidad, numLote,
				fechaEnvasado, paisOrigen, temperatura, metodo, tiempo);
	}
	private void listarProductos(){
		ArrayList<Producto> listaProductos = almacen.listaProductos();
		for(Producto produc : listaProductos){
			System.out.println(produc);
		}
	}
	private void opcionNoValida(){
		System.err.println("Opcion no Valida");
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

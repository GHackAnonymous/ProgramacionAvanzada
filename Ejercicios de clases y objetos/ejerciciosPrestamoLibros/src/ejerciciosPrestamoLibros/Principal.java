package ejerciciosPrestamoLibros;

import java.util.Scanner;

public class Principal {
	Libros gestorLibros;
	Scanner teclado;
	
	private Principal(){
		gestorLibros = new Libros();
		teclado = new Scanner(System.in);
	}
	private int menu(){
		System.out.println("1.- Crear un libro");
		System.out.println("2.- Ver todos los libros"); 
		System.out.println("3.- Prestar libro");
		System.out.println("4.- Ver Libros Prestados");
		System.out.println("5.- Devolver libro");
		System.out.println("0.- salir");
		System.out.print("opcion >> ");
		int opcion = teclado.nextInt();
		teclado.nextLine();
		return opcion; 
	}
	public void crearLibro(){
		System.out.print("Nombre libro: ");
		gestorLibros.crearLibro(teclado.nextLine());
	}
	private void verLibros(){
		Libro[] lista = gestorLibros.listaLibros();
		
		for(int i = 0; i< lista.length; i++){
			System.out.println(lista[i].toString());
		}	
	}
	private void verLibrosPestados(){
		Libro[] lista = gestorLibros.listaLibros();
		
		for(int i = 0; i< lista.length; i++){
			if(lista[i].getFechaPresatamo() != null){
				System.out.println(lista[i].toString()+
						"\n A nombre de: "+
						lista[i].getNombrePersonaPrestado());
			}
		}	
	}
	private void verLibrosNoPestados(){
		Libro[] lista = gestorLibros.listaLibros();
		
		for(int i = 0; i< lista.length; i++){
			if(lista[i].getFechaPresatamo() == null){
				System.out.println(lista[i].toString());
			}
		}	
	}
	private int selecionarLibro(){
		System.out.print("Selecione libro -> ");
		int opcion = teclado.nextInt();
		teclado.nextLine();
		return opcion;
	}
	private String personaPrestamo(){
		System.out.print("Como te llamas -> ");
		return teclado.nextLine();
	}
	private void opcionMenu(int opcion){
		switch(opcion){
		case 1:
			crearLibro();
			break;
		case 2:
			verLibros();
			break;
		case 3:
			verLibrosNoPestados();
			int queLibro = selecionarLibro();
			String nombrePersonaAPrestar = personaPrestamo();
			gestorLibros.hacerPrestamo(queLibro, nombrePersonaAPrestar);
			break;
		case 4:
			verLibrosPestados();
			break;
		case 5:
			verLibrosPestados();
			int queLibro2 = selecionarLibro();
			gestorLibros.devolver(queLibro2);
			break;
		case 0: break;
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

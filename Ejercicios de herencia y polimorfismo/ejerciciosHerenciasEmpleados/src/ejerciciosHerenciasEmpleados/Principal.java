package ejerciciosHerenciasEmpleados;

import java.util.List;
import java.util.Scanner;

public class Principal {

	Empleados lista;
	Scanner teclado;
	public Principal(){
		teclado = new Scanner(System.in);
		lista = new Empleados();
	}
	public void programa(){
		int opcion;
		do{
			System.out.println("1.- añadir enpleado");
			System.out.println("2.- Ver Empleados");
			System.out.println("0.- Salir");
			System.out.print("Opcion >> ");
			opcion = teclado.nextInt();
			teclado.nextLine();
			try {
				switch(opcion){
				case 1:
					System.out.print("Nombre y apellido: ");
					String nombre = teclado.nextLine();
					System.out.print("Salario: ");
					int salario = teclado.nextInt();
					teclado.nextLine();
					System.out.println("Tipo de empleado (normal, director, comercial): ");
					String tipo = teclado.nextLine();
					tipo.toLowerCase();
					switch(tipo){
						case "normal":
							lista.addEmpleNormal(nombre, salario);
							break;
						case "director":
							System.out.print("Productividad: ");
							int produc = teclado.nextInt();
							teclado.nextLine();
							lista.addEmpleDirec(nombre, salario, produc);
							break;
						case "comercial":
							System.out.print("Ventas: ");
							int venta = teclado.nextInt();
							teclado.nextLine();
							lista.addEmpleComerci(nombre, salario, venta);
							break;
						default:
							throw new OpcionNoValidaException( "Opcion no valida");	
					}
					break;
				case 2:
					List<Empleado> listaEmpleados = lista.getLista();
					for(Empleado e : listaEmpleados){
						System.out.println(e);
					}
					break;
				case 0:
					System.out.println("Saliendo.....");
					break;
				default:
						throw new OpcionNoValidaException( "Opcion no valida");	
				}
			} catch (OpcionNoValidaException e1) {
				System.out.println(e1.getMessage());
			}
		}while(opcion != 0);
	}
	public static void main(String[] args) {
		Principal primero = new Principal();
		primero.programa();
	}

}

import java.util.List;
import java.util.Scanner;

public class Principal {
	Criaturas criaturas;
	Artefactos artefactos;
	Scanner teclado;
	int vidaPorVeneno;
	
	private Principal(){
		criaturas = new Criaturas();
		artefactos = new Artefactos();
		teclado = new Scanner(System.in);
	}
	private int menu(){
		System.out.println("1.- Crear Artefacto");
		System.out.println("2.- Crear Criatura"); 
		System.out.println("3.- Ver Criatura");
		System.out.println("4.- jugar");
		System.out.println("0.- salir");
		System.out.print("opcion >> ");
		int opcion = teclado.nextInt();
		teclado.nextLine();
		return opcion; 
	}
	private void opcionMenu(int opcion) {
		switch(opcion){
			case 1: 
				String art = crearArtefacto();
				opcionArtefacto(art);
				break;
			case 2:
				String cria =crearCriatura();
				opcionCriatura(cria);
				break;
			case 3:
				verCriatura();
				break;
			case 4:
				jugar();
				break;
			case 0:
				System.out.println("Saliendo....");
				break;
			default:
				opcionNoValidad();
		}
	}
	private String crearArtefacto(){
		System.out.print("Tipo artefacto (Arma/Veneno/Pocion): ");
		return teclado.nextLine();
	}
	private void opcionArtefacto(String art) {
		String nombre;
		int vida;
		switch(art.toLowerCase()){
		case "arma":
			System.out.println("Nombre: ");
			nombre = teclado.nextLine();
			System.out.print("Cuanta vida quita: ");
			vida = teclado.nextInt();
			teclado.nextLine();
			artefactos.addArma(nombre, vida);
			break;
		case "veneno":
			System.out.println("Nombre: ");
			nombre = teclado.nextLine();
			System.out.print("Cuanta vida quita por turno: ");
			vida = teclado.nextInt();
			teclado.nextLine();
			artefactos.addVeneno(nombre, vida);
			break;
		case "pocion":
			System.out.print("Nombre: ");
			nombre = teclado.nextLine();
			System.out.print("Cuanta vida recuperas: ");
			vida = teclado.nextInt();
			teclado.nextLine();
			artefactos.addPocion(nombre, vida);
			break;
		default:
			opcionNoValidad();
		}
	}
	private void verArtefactos(){
		List<Artefacto> listaArt = artefactos.verArtefacto();
		for(Artefacto art:listaArt){
			System.out.println("\n"+art+"\n");
		}
	}
	private Artefacto optenerArtefactos(int id){
		List<Artefacto> listaArt = artefactos.verArtefacto();
		for(Artefacto art:listaArt){
			if(art.getId() == id){
				return art;
			}
		}
		return null;
	}
	private String crearCriatura() {
		System.out.print("Tipo criatura (Elfo/Orco): ");
		return teclado.nextLine();
	}
	private void opcionCriatura(String cria) {
		System.out.println("Nombre: ");
		String nombre = teclado.nextLine();
		verArtefactos();
		System.out.print("Id >> ");
		Artefacto artefactoSelecionado = optenerArtefactos(teclado.nextInt());
		teclado.nextLine();
		
		
		switch(cria.toLowerCase()){
		case "elfo":
			criaturas.addElfo(nombre, artefactoSelecionado);
			break;
		case "orco":
			criaturas.addOrco(nombre, artefactoSelecionado);
			break;
		default:
			opcionNoValidad();
		}
	}
	private void verCriatura() {
		List<Criatura> listaCria = criaturas.verCriatura();
		for(Criatura cria:listaCria){
			System.out.println("\n"+cria+"\n");
		}
	}
	private void jugar() {
		quitarVidaPorVeneno();
		System.out.print("Id criatura que mueve: ");
		int idCriaMover = teclado.nextInt();
		teclado.nextLine();
		//System.out.print("Id artefacto a usar: ");
		//int idArtefacto = teclado.nextInt();
		//teclado.nextLine();
		System.out.print("Id criatura sobre la que actua: ");
		int idCriaActua = teclado.nextInt();
		teclado.nextLine(); 
		//utilizar(idCriaMover, idArtefacto, idCriaActua);
		utilizar(idCriaMover, idCriaActua);
		System.out.println(combrobarVida());
	}
	public void quitarVidaPorVeneno(){
		criaturas.quitarVidaPorVeneno(vidaPorVeneno);
	}
	public String combrobarVida(){
		return criaturas.combrobarVida();
	}
	private void utilizar(int idCriaMover, int idCriaActua) {
		vidaPorVeneno = criaturas.efectoCriaturaSobreCriatura(idCriaMover, idCriaActua);
		System.out.println(criaturas.toStringMovimoento(idCriaMover, idCriaActua));
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

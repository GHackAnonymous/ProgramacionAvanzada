package ejerciciosAjendaTelefono;

public class Agenda {
	
	private final int MAXTELEFONO = 100;
	private Telefono[] listaTelefonos;
	private int numTelefono;
	
	public Agenda(){
		listaTelefonos = new Telefono[MAXTELEFONO];
		numTelefono = 0;
	}	
	public void anadirTelefono(String nombre, int[] numero){
		listaTelefonos[numTelefono] = new Telefono(numero, nombre);
		numTelefono++;
	}
	public Telefono buscarTelefono(String nombre){
		for(Telefono tl : listaTelefonos){
			if(tl.getNombre().equalsIgnoreCase(nombre)){
				return tl;
			}
		}
		return null;
	}
}

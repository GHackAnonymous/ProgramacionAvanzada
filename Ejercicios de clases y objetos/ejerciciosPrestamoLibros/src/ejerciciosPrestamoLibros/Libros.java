package ejerciciosPrestamoLibros;

public class Libros {
	private Libro[] listaLibros;
	private final int MAXLIBROS = 100;
	private int numLibros = 0; 
	
	public Libros(){
		listaLibros = new Libro[MAXLIBROS];
	}
	public void crearLibro( String nombre){
		listaLibros[numLibros] = new Libro(numLibros, nombre);
		numLibros++;
	}
	public Libro[] listaLibros(){
		int cantidad = numLibros;
		Libro[] copia = new Libro[numLibros];
		System.arraycopy(listaLibros, 0, copia, 0, cantidad);
		
		return copia;
	}
	public void hacerPrestamo(int queLibro, String NombrePersonaPrestamo){
		listaLibros[queLibro].hacerPrestamo(NombrePersonaPrestamo);
	}
	public void devolver(int queLibro){
		listaLibros[queLibro].devolver();
	}
}

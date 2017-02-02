
public class Pelicula {
	String caratula;
	String nombre;
	int anyo;
	String director;
	String pais;
	String tipo; 
	
	public Pelicula (String caratula, String nombre, int anyo,
	String director, String pais, String tipo){
		this.caratula = caratula;
		this.nombre = nombre;
		this.anyo = anyo;
		this.director = director;
		this.pais = pais;
		this.tipo = tipo;
	}
	
	public String getCaratula() {
		return caratula;
	}

	public void setCaratula(String caratula) {
		this.caratula = caratula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String toString (){
		return this.caratula+"$"+this.nombre+"$"+this.anyo
				+"$"+this.director+"$"+this.pais+"$"+this.tipo;
	}
}

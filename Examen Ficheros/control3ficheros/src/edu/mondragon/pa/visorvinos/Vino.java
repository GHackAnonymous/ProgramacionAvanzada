package edu.mondragon.pa.visorvinos;

public class Vino {
	
	String nombre;
	String bodega;
	String tipo;
	int anio;
	double precio;
	boolean recomendado;
	public Vino(String nombre, String bodega, String tipo, int anio, double precio, boolean recomendado) {
		this.nombre = nombre;
		this.bodega = bodega;
		this.tipo = tipo;
		this.precio = precio;
		this.anio = anio;
		this.recomendado = recomendado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getBodega() {
		return bodega;
	}
	public void setBodega(String bodega) {
		this.bodega = bodega;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public boolean isRecomendado() {
		return recomendado;
	}
	public void setRecomendado(boolean recomendado) {
		this.recomendado = recomendado;
	}
	public String stringBodega(){
		return this.bodega;
	}
	public String stringTipo(){
		return this.tipo;
	}
	public String stringAnyo(){
		return ""+this.anio;
	}
	@Override
	public String toString() {
		return this.bodega;
	}
	public Class<?> getFieldClass(int indice){
		switch (indice){
		case 3: return Integer.class;
		case 4: return Double.class;
		case 5: return Boolean.class;
		default: return String.class; 
		}
		
	}

	public Object getFieldAt(int columna) {
		switch (columna){
		case 0: return nombre;
		case 1: return bodega;
		case 2: return tipo;
		case 3: return Integer(anio);
		case 4: return new Double(precio);
		case 5: return new Boolean (recomendado);
		default: return null; 
		}
		
	}
	private Object Integer(int anio2) {
		return anio2;
	}
}

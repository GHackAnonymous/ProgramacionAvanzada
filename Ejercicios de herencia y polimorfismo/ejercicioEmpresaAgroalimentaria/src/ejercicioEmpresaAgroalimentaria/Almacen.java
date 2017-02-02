package ejercicioEmpresaAgroalimentaria;

import java.util.ArrayList;
import java.util.Date;

public class Almacen {
	
	private ArrayList<Producto> almacen;
	
	public Almacen(){
		almacen = new ArrayList<Producto>();
	}
	public void addProductoFresco(String nombre, Date fechaCaducidad, int numeroLote,
			Date fechaEnvasada, String paisOrigen){
		almacen.add(new Frescos(nombre, fechaCaducidad, numeroLote, fechaEnvasada,paisOrigen));
	}
	public void addProductoRefrigerado(String nombre, Date fechaCaducidad, int numeroLote, 
			int codigoOrganico, Date fechaEnvasada,
			int temperatura, String paisOrigen){
		almacen.add(new Refrigerados(nombre, fechaCaducidad, numeroLote, 
				codigoOrganico, fechaEnvasada,
				temperatura, paisOrigen));
	}
	public void addProductoCongeladoAire(String nombre, Date fechaCaducidad, int numeroLote, 
			Date fechaEnvasada, String paisOrigen,
			int temperatura, int porNitrogeno, int porOxigeno,
			int porDioxidoCarbono, int porVaporAgua){
		almacen.add(new Aire(nombre, fechaCaducidad, numeroLote, 
				fechaEnvasada, paisOrigen,temperatura,
				porNitrogeno, porOxigeno, porDioxidoCarbono, porVaporAgua));
	}
	public void addProductoCongeladoAgua(String nombre, Date fechaCaducidad, int numeroLote, 
			Date fechaEnvasada, String paisOrigen,
			int temperatura, int gramosPorLitrosSal){
		almacen.add(new Agua(nombre, fechaCaducidad, numeroLote, 
				fechaEnvasada, paisOrigen,
				temperatura, gramosPorLitrosSal));
	}
	public void addProductoCongeladoNitrogeno(String nombre, Date fechaCaducidad, int numeroLote, 
			Date fechaEnvasada, String paisOrigen,
			int temperatura,String metodo, Date tiempoExpuesto){
		almacen.add(new Nitrogeno(nombre, fechaCaducidad, numeroLote, 
				fechaEnvasada, paisOrigen,
				temperatura, metodo, tiempoExpuesto));
	}
	public ArrayList<Producto> listaProductos(){
		ArrayList<Producto> copia = new ArrayList<Producto>(almacen);
		return copia;
	}
}

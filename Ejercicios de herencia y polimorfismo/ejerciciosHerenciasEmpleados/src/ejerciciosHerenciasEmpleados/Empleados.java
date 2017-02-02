package ejerciciosHerenciasEmpleados;

import java.util.ArrayList;
import java.util.List;

public class Empleados {
	private List<Empleado> listaEmpleado;
	
	public Empleados(){
		listaEmpleado = new ArrayList<Empleado>();
	}
	public void addEmpleNormal(String nombre, int salario){
		listaEmpleado.add(new Normales(salario, nombre));
	}
	public void addEmpleComerci(String nombre, int salario, int ventas){
		Comerciales c = new Comerciales(salario, nombre);
		c.addVentas(ventas);
		listaEmpleado.add(c);
	}
	public void addEmpleDirec(String nombre, int salario, int productividad){
		Directivos d = new Directivos(salario, nombre);
		d.addProductividad(productividad);
		listaEmpleado.add(d);
	}
	public List<Empleado> getLista() {
		for(Empleado e : listaEmpleado){
			e.salarioTener();
		}
		List<Empleado> copia =  new ArrayList<Empleado>(listaEmpleado);
		return copia;
	}
	
}
